package com.ericsson.oss.fmservice.ejb;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.ericsson.oss.fmservice.impl.ModeledEventSenderImpl;
import com.ericsson.oss.itpf.sdk.eventbus.model.annotation.Modeled;
import com.ericsson.oss.services.fm.service.alarm.AckNotification;
import com.ericsson.oss.services.fm.service.alarm.AlarmNotification;
import com.ericsson.oss.services.fm.service.alarm.AlarmSyncAbortNotification;
import com.ericsson.oss.services.fm.service.alarm.AlarmSyncEndNotification;
import com.ericsson.oss.services.fm.service.alarm.AlarmSyncStartNotification;
import com.ericsson.oss.services.fm.service.alarm.ClearAllEventNotification;
import com.ericsson.oss.services.fm.service.alarm.ErrorNotification;
import com.ericsson.oss.services.fm.service.alarm.EventCloseNotification;
import com.ericsson.oss.services.fm.service.alarm.NodeSuspendNotification;
import com.ericsson.oss.services.fm.service.alarm.SyncNotification;

/**
 * @author tcsbosr
 *ModeledEventSenderImpl Class is used to send alarm notification to ActiveMQ
 */
public class ReceiveModeledEvent {

	@Inject
	private Logger logger;
	public ModeledEventSenderImpl modeledEventSenderImpl = new ModeledEventSenderImpl();

	/**
	 * @param alarm
	 */

	public void receiveSpecificEvent(
			@Observes @Modeled final AlarmNotification alarmNotification) {

		this.logger.trace("AlarmNotification received from the channel..."
				+ alarmNotification);
		modeledEventSenderImpl.fmQueueSend(alarmNotification);

	}

	/**
	 * @param syncNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final SyncNotification syncNotification) {
		this.logger
				.trace(" ------ SyncNotification received from Event Bus channel ------"
						+ syncNotification);

		modeledEventSenderImpl.fmQueueSend(syncNotification);
	}

	/**
	 * @param alarmSyncAbortNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final AlarmSyncAbortNotification alarmSyncAbortNotification) {
		this.logger
				.trace(" -------- AlarmSyncAbortNotification received from Event Bus Channel ------"
						+ alarmSyncAbortNotification);

		modeledEventSenderImpl.fmQueueSend(alarmSyncAbortNotification);
	}

	/**
	 * @param alarmSyncEndNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final AlarmSyncEndNotification alarmSyncEndNotification) {
		this.logger
				.trace(" ------ AlarmSyncEndNotification received from Event Bus channel ------"
						+ alarmSyncEndNotification);

		modeledEventSenderImpl.fmQueueSend(alarmSyncEndNotification);
	}

	/**
	 * @param clearAllEventNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final ClearAllEventNotification clearAllEventNotification) {
		this.logger
				.trace(" ------ ClearAllEventNotification received from Event Bus channel ------"
						+ clearAllEventNotification);
		modeledEventSenderImpl.fmQueueSend(clearAllEventNotification);
	}

	/**
	 * @param alarmSyncStartNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final AlarmSyncStartNotification alarmSyncStartNotification) {
		this.logger
				.trace(" ------ AlarmSyncStartNotification received from Event Bus channel ------"
						+ alarmSyncStartNotification);
		modeledEventSenderImpl.fmQueueSend(alarmSyncStartNotification);
	}

	/**
	 * @param eventCloseNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final EventCloseNotification eventCloseNotification) {
		this.logger
				.trace(" ------ EventCloseNotification received from Event Bus channel ------"
						+ eventCloseNotification);
		modeledEventSenderImpl.fmQueueSend(eventCloseNotification);
	}

	/**
	 * @param errorNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final ErrorNotification errorNotification) {
		this.logger
				.trace(" ------ ErrorNotification received from Event Bus channel ------"
						+ errorNotification);
		modeledEventSenderImpl.fmQueueSend(errorNotification);
	}

	/**
	 * @param nodeSuspendNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final NodeSuspendNotification nodeSuspendNotification) {
		this.logger
				.trace(" ------ NodeSuspendNotification received from Event Bus channel ------"
						+ nodeSuspendNotification);
		modeledEventSenderImpl.fmQueueSend(nodeSuspendNotification);
	}

	/**
	 * @param nodeSuspendNotification
	 */
	public void receiveSpecificEvent(
			@Observes @Modeled final AckNotification ackNotification) {
		this.logger
				.trace(" ------ AckNotification received from Event Bus channel ------"
						+ ackNotification);
		modeledEventSenderImpl.fmQueueSend(ackNotification);
	}
}
