/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.fmservice.impl;

import java.util.HashMap;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.nms.fm.fm_communicator.*;
import com.ericsson.nms.fm.fm_communicator.Notification.AckStatus;
import com.ericsson.nms.fm.fm_communicator.Notification.EventSeverity;
import com.ericsson.nms.fm.fm_communicator.Notification.EventState;
import com.ericsson.nms.fm.fm_communicator.Notification.NotificationType;
import com.ericsson.oss.services.fm.service.alarm.*;


/**
 * @author tcsbosr
 * 
 */
public class ModeledEventSenderImpl {
	private static final String subject = "FMService_queue";
	private ActiveMQConnection connection = null;
	private Session session = null;
	private MessageProducer producer = null;
	private static final String OSS_IP = "172.16.69.108";
	
	private static final String OSS_PORT = "50057";
	private static final int MAX_TRIES = 5;
	private Logger logger = LoggerFactory.getLogger(ModeledEventSenderImpl.class);

	/**
	 * @param Object
	 *            Notification received from event bus
	 * 
	 */
	public void fmQueueSend(final Object obj) {

		logger.trace("ModeledEventSenderImpl.fmQueueSend -->");
		try {

			for (int i = 0; i < MAX_TRIES; i++) {

				if (producer == null || connection == null || session == null) {
					fmQueueCloseConn();
					reconnect();
				} else {
					break;
				}
			}
			final ObjectMessage message = session.createObjectMessage();
			final Notification notif = prepareNotif(obj);
			final Notification[] notif1 = new Notification[1];
			notif1[0]=notif;
			message.setObject(notif1);
			producer.send(message);
			logger.trace("Notification sent to FMCommunicator- "
					+ message.getObject().toString());
		} catch (Exception e) {
			logger.error("Exception occured while sending notification to FMCommunicator -"
							+ e.getMessage());
		}
		logger.trace("ModeledEventSenderImpl.fmQueueSend <--");
	}

	public void fmQueueCloseConn() {
		logger.trace("ModeledEventSenderImpl.fmQueueCloseConn -->");
		try {
			if (connection != null) {
				connection.close();
				connection = null;
			}
			if (session != null) {
				session.close();
				session = null;
			}
			if (producer != null) {
				producer.close();
				producer = null;
			}
			producer = null;
			connection = null;
			session = null;
			logger.trace("Connection closed to FMService_Queue ");
		} catch (JMSException e) {
			 logger.error("Exception occured while xlosing connection to FMService_Queue -"+
			 e.getMessage());
		}
		logger.trace("ModeledEventSenderImpl.fmQueueCloseConn <--");
	}

	public void reconnect() {
		logger.trace("ModeledEventSenderImpl.reconnect -->");
		try {
			logger.trace("Trying to reconnect ...");

			connection = ActiveMQConnection.makeConnection("failover://tcp://"
					+ OSS_IP + ":" + OSS_PORT);
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			final Destination destination = session.createQueue(subject);
			producer = session.createProducer(destination);
		} catch (Exception e) {
			 logger.error("Failed to reconnect - " + e.getMessage());
		}
		logger.trace("ModeledEventSenderImpl.reconnect <--");
	}

	/**
	 * @param object
	 * @return notification
	 */
	public Notification alarmNotificationToNotification(final Object object) {
		final Notification notification = new Notification();
		AlarmNotification alarmNotification = null;
		ErrorNotification errorNotification = null;
		NodeSuspendNotification nodeSuspendNotification = null;
		if (object.getClass().getName()
				.equals(AlarmNotification.class.getName())) {
			alarmNotification = (AlarmNotification) object;
			notification.setNotificationType(NotificationType.ALARM_EVENT);
			logger.debug("--------Enter in AlarmNotification------");
		} else if (object.getClass().getName()
				.equals(ErrorNotification.class.getName())) {
			errorNotification = (ErrorNotification) object;
			alarmNotification = errorNotification;
			notification.setNotificationType(NotificationType.ERROR_EVENT);
			logger.debug("--------Enter in ErrorNotification-------");
		} else if (object.getClass().getName()
				.equals(NodeSuspendNotification.class.getName())) {
			nodeSuspendNotification = (NodeSuspendNotification) object;
			alarmNotification = nodeSuspendNotification;
			notification.setNotificationType(NotificationType.NODE_SUSPENDED);
			logger.debug("---------Enter in NodeSuspendNotification------------");
		}
		notification.setManagedObjectInstance(alarmNotification
				.getNodeAddress() != null ? alarmNotification.getNodeAddress()
				: "");
		logger.trace("fdn is coming"
				+ notification.getManagedObjectInstance());
		notification
				.setProbableCause(alarmNotification.getProbableCause() != null ? alarmNotification
						.getProbableCause() : "");
		notification
				.setSpecificProblem(alarmNotification.getSpecificProblem() != null ? alarmNotification
						.getSpecificProblem() : "");
		notification
				.setTheTime(alarmNotification.getTheTime() != null ? alarmNotification
						.getTheTime() : null);
		notification
				.setTimeZone(alarmNotification.getTimeZone() != null ? alarmNotification
						.getTimeZone() : "");
		notification.setNumId(alarmNotification.getFmMediationEventId()
				.getNumId());
		notification.setStringId(alarmNotification.getFmMediationEventId()
				.getStringId() != null ? alarmNotification
				.getFmMediationEventId().getStringId() : "");
		notification
				.setEventType(alarmNotification.getEventType() != null ? alarmNotification
						.getEventType() : "");
		switch (alarmNotification.getPerceivedSeverity()) {
		case INDETERMINATE:
			notification.setSeverity(EventSeverity.INDERMINATE);
			break;
		case CRITICAL:
			notification.setSeverity(EventSeverity.CRITICAL);
			break;
		case MAJOR:
			notification.setSeverity(EventSeverity.MAJOR);
			break;
		case MINOR:
			notification.setSeverity(EventSeverity.MINOR);
			break;
		case WARNING:
			notification.setSeverity(EventSeverity.WARNING);
			break;
		case CLEARED:
			notification.setSeverity(EventSeverity.CLEARED);
			break;
		default:
			break;
		}
		notification
				.setSourceType(alarmNotification.getSourceType() != null ? alarmNotification
						.getSourceType() : "");
		notification
				.setOtherAttributes((HashMap<String, String>) (alarmNotification.getOtherAttributes() != null ? alarmNotification
						.getOtherAttributes() : null));
		notification.setStringId(alarmNotification.getFmMediationEventId()
				.getStringId() != null ? alarmNotification
				.getFmMediationEventId().getStringId() : "");
		notification.setNumId(new Long(alarmNotification
				.getFmMediationEventId().getNumId()) != null ? new Long(
				alarmNotification.getFmMediationEventId().getNumId()) : null);
		return notification;
	}

	/**
	 * @param syncNotification
	 * @return notification
	 */
	public Notification syncNotificationToNotification(
			final SyncNotification syncNotification) {
		logger.debug(" -------------------- in SyncNotification -----------------------");
		final Notification notification = new Notification();
		switch (syncNotification.getAckInfo().getAckStatus()) {
		case ACKNOWLEDGED:
			notification.setAckState(AckStatus.ACKNOWLEDGED);
			break;
		case NOT_ACKNOWLEDGED:
			notification.setAckState(AckStatus.UNACKNOWLEDGED);
			break;
		default:
			break;
		}
		notification.setOperatorName(syncNotification.getAckInfo()
				.getOperator() != null ? syncNotification.getAckInfo()
				.getOperator() : "");
		notification
				.setManagedObjectInstance(syncNotification.getNodeAddress() != null ? syncNotification
						.getNodeAddress() : "");
		notification
				.setProbableCause(syncNotification.getProbableCause() != null ? syncNotification
						.getProbableCause() : "");
		notification
				.setSpecificProblem(syncNotification.getSpecificProblem() != null ? syncNotification
						.getSpecificProblem() : "");
		notification
				.setTheTime(syncNotification.getTheTime() != null ? syncNotification
						.getTheTime() : null);
		notification
				.setTimeZone(syncNotification.getTimeZone() != null ? syncNotification
						.getTimeZone() : "");
		notification.setNumId(syncNotification.getFmMediationEventId()
				.getNumId());
		notification.setStringId(syncNotification.getFmMediationEventId()
				.getStringId() != null ? syncNotification
				.getFmMediationEventId().getStringId() : "");
		notification
				.setEventType(syncNotification.getEventType() != null ? syncNotification
						.getEventType() : "");

		switch (syncNotification.getPerceivedSeverity()) {
		case INDETERMINATE:
			notification.setSeverity(EventSeverity.INDERMINATE);
			break;
		case CRITICAL:
			notification.setSeverity(EventSeverity.CRITICAL);
			break;
		case MAJOR:
			notification.setSeverity(EventSeverity.MAJOR);
			break;
		case MINOR:
			notification.setSeverity(EventSeverity.MINOR);
			break;
		case WARNING:
			notification.setSeverity(EventSeverity.WARNING);
			break;
		case CLEARED:
			notification.setSeverity(EventSeverity.CLEARED);
			break;
		default:
			break;
		}
		notification
				.setSourceType(syncNotification.getSourceType() != null ? syncNotification
						.getSourceType() : "");
		notification
				.setOtherAttributes((HashMap<String, String>) (syncNotification.getOtherAttributes() != null ? syncNotification
						.getOtherAttributes() : ""));
		notification.setStringId(syncNotification.getFmMediationEventId()
				.getStringId() != null ? syncNotification
				.getFmMediationEventId().getStringId() : "");
		notification.setNumId(new Long(syncNotification.getFmMediationEventId()
				.getNumId()) != null ? new Long(syncNotification
				.getFmMediationEventId().getNumId()) : null);

		return notification;
	}

	/**
	 * @param ackNotification
	 * @return notification
	 */
	public Notification ackNotificationToNotification(
			final AckNotification ackNotification) {
		logger.debug(" -------------------- in AckNotification -----------------------");
		final Notification notification = new Notification();
		switch (ackNotification.getAckInfo().getAckStatus()) {
		case ACKNOWLEDGED:
			notification.setAckState(AckStatus.ACKNOWLEDGED);
			break;
		case NOT_ACKNOWLEDGED:
			notification.setAckState(AckStatus.UNACKNOWLEDGED);
			break;
		default:
			break;
		}
		notification
				.setOperatorName(ackNotification.getAckInfo().getOperator() != null ? ackNotification
						.getAckInfo().getOperator() : "");
		notification
				.setProbableCause(ackNotification.getProbableCause() != null ? ackNotification
						.getProbableCause() : "");
		notification
				.setSpecificProblem(ackNotification.getSpecificProblem() != null ? ackNotification
						.getSpecificProblem() : "");
		notification
				.setEventType(ackNotification.getEventType() != null ? ackNotification
						.getEventType() : "");
		notification
				.setManagedObjectInstance(ackNotification.getNodeAddress() != null ? ackNotification
						.getNodeAddress() : "");
		return notification;
	}

	/**
	 * @param clearAllEventNotification
	 * @return notification
	 */
	public Notification clearAllEventNotificationToNotification(
			final ClearAllEventNotification clearAllEventNotification) {
		logger.debug(" -------------------- in ClearAllEventNotification -----------------------");
		final Notification notification = new Notification();
		notification.setTopObjectName(clearAllEventNotification
				.getTopObjectName() != null ? clearAllEventNotification
				.getTopObjectName() : "");
		notification.setManagedObjectInstance(clearAllEventNotification
				.getNodeAddress() != null ? clearAllEventNotification
				.getNodeAddress() : "");
		return notification;
	}

	/**
	 * @param alarmSyncEndNotification
	 * @return notification
	 */
	public Notification alarmSyncEndNotificationNotificationToNotification(
			final AlarmSyncEndNotification alarmSyncEndNotification) {
		logger.debug(" -------------------- in AlarmSyncEndNotification -----------------------");
		final Notification notification = new Notification();
		notification.setManagedObjectInstance(alarmSyncEndNotification
				.getNodeAddress() != null ? alarmSyncEndNotification
				.getNodeAddress() : "");
		return notification;
	}

	/**
	 * @param alarmSyncAbortNotification
	 * @return notification
	 */
	public Notification alarmSyncAbortNotificationNotificationToNotification(
			final AlarmSyncAbortNotification alarmSyncAbortNotification) {
		logger.debug(" -------------------- in AlarmSyncAbortNotification -----------------------");
		final Notification notification = new Notification();
		notification.setManagedObjectInstance(alarmSyncAbortNotification
				.getNodeAddress() != null ? alarmSyncAbortNotification
				.getNodeAddress() : "");
		return notification;
	}

	/**
	 * @param alarmSyncStartNotification
	 * @return notification
	 */
	public Notification alarmSyncStartNotificationToNotification(
			final AlarmSyncStartNotification alarmSyncStartNotification) {
		logger.debug(" -------------------- in AlarmSyncStartNotification -----------------------");
		final Notification notification = new Notification();
		notification.setManagedObjectInstance(alarmSyncStartNotification
				.getNodeAddress() != null ? alarmSyncStartNotification
				.getNodeAddress() : "");
		return notification;
	}

	/**
	 * @param eventCloseNotification
	 * @return notification
	 */
	public Notification eventCloseNotificationToNotification(
			final EventCloseNotification eventCloseNotification) {
		logger.debug(" -------------------- in EventCloseNotification -----------------------");
		final Notification notification = new Notification();
		notification.setManagedObjectInstance(eventCloseNotification
				.getNodeAddress() != null ? eventCloseNotification
				.getNodeAddress() : "");
		notification
				.setOperatorName(eventCloseNotification.getOperator() != null ? eventCloseNotification
						.getOperator() : "");
		notification.setOriginatorName(eventCloseNotification
				.getOrginatorName() != null ? eventCloseNotification
				.getOrginatorName() : "");

		switch (eventCloseNotification.getPreviousEventState()) {
		case E_STATE_ACTIVE_ACKNOWLEGED:
			notification.setPreviousEventState(EventState.ACTIVE_ACKNOWLEDGED);
			break;
		case E_STATE_CLEARED_ACKNOWLEGED:
			notification.setPreviousEventState(EventState.CLEARED_ACKNOWLEDGED);
			break;
		case E_STATE_ACTIVE_UNACKNOWLEGED:
			notification
					.setPreviousEventState(EventState.ACTIVE_UNACKNOWLEDGED);
			break;
		case E_STATE_CLOSED:
			notification.setPreviousEventState(EventState.CLOSED);
			break;
		case E_STATE_CLEARED_UNACKNOWLEGED:
			notification
					.setPreviousEventState(EventState.CLEARED_UNACKNOWLEDGED);
			break;
		default:
			break;
		}
		return notification;
	}

	/**
	 * @param Object Notification received from event bus
	 *            
	 * @return Notification which will be sent to FM Communicator
	 */
	public Notification prepareNotif(final Object object) {

		Notification notification = new Notification();
		try {

			logger.trace("ModeledEventSenderImpl.prepareNotif -->");
			switch (object.getClass().getSimpleName()) {

			case "AlarmNotification":

			case "ErrorNotification":

			case "NodeSuspendNotification":
				// Conversion will be same for
				// AlarmNotification,ErrorNotification and
				// NodeSuspendNotification
				notification = alarmNotificationToNotification(object);
				break;
			case "SyncNotification":
				notification = syncNotificationToNotification((SyncNotification) object);
				break;
			case "AckNotification":
				notification = ackNotificationToNotification((AckNotification) object);
				break;
			case "ClearAllEventNotification":
				notification = clearAllEventNotificationToNotification((ClearAllEventNotification) object);
				break;
			case "AlarmSyncEndNotification":
				notification = alarmSyncEndNotificationNotificationToNotification((AlarmSyncEndNotification) object);
				break;
			case "AlarmSyncAbortNotification":
				notification = alarmSyncAbortNotificationNotificationToNotification((AlarmSyncAbortNotification) object);
				break;
			case "AlarmSyncStartNotification":
				notification = alarmSyncStartNotificationToNotification((AlarmSyncStartNotification) object);
				break;
			case "EventCloseNotification":
				notification = eventCloseNotificationToNotification((EventCloseNotification) object);
				break;
			default:
				 logger.trace("Notification "+object.getClass().getSimpleName()+" unhandeled here");
				break;
			}
		} catch (Exception e) {
			 logger.error("Conversion to notification failed -" +
			 e.getMessage());
		}
		return notification;
	}

}
