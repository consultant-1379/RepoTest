package com.ericsson.oss.fmservice.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.ericsson.nms.fm.fm_communicator.*;
import com.ericsson.oss.itpf.sdk.eventbus.model.EventSender;
import com.ericsson.oss.itpf.sdk.eventbus.model.annotation.Modeled;
import com.ericsson.oss.mediation.core.events.MediationTaskRequest;
import com.ericsson.oss.services.fm.service.model.*;
import com.ericsson.oss.services.fm.service.model.FmMediationAckRequest.AckStatus;

/**
 * @author tcsjapa
 * 
 *This FMServiceBean is used to interact with SUPI for monitoring the  nodes
 *    
 */
@Stateless
@Remote(FMServiceRemote.class)
public class FMServiceBean implements FMServiceRemote {

	@Inject
	private Logger logger;

	private int counter = 0;

	@Inject
	@Modeled
	private EventSender<MediationTaskRequest> fmMediationRequestEventSender;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ericsson.nms.fm.fm_communicator.FMServiceRemote#startSupervision(java.lang.String)
	 */
	@Override
	public int startSupervision(final String fdn,
			final FmNeProperties fmNeProperties, final RIAData riaData) {
		this.logger.trace("FMSServiceBean.startSupervision -->");
		this.logger.trace("Start Supervision received for FDN = " + fdn);
		counter = 0;
		return ++counter;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ericsson.nms.fm.fm_communicator.FMServiceRemote#stopSupervision(java.lang.String)
	 */
	@Override
	public int stopSupervision(final String fdn) {
		this.logger.trace("FMSServiceBean.stopSupervision -->");
		this.logger.trace("Stop Supervision received for FDN = " + fdn);
		counter = 0;
		this.logger.trace("FMSServiceBean.stopSupervision <--");
		return ++counter;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ericsson.nms.fm.fm_communicator.FMServiceRemote#startSync(java.lang.String)
	 */
	@Override
	public int startSync(final String fdn) {
		this.logger.trace("FMSServiceBean.startSync -->");
		this.logger.trace("Start Synchronisation received for FDN = " + fdn);
		counter = 0;
		// code for sending ack/unack request to meadiation event based client
		final FmFmMediationAlarmSyncRequest fmFmMediationAlarmSyncRequest = new FmFmMediationAlarmSyncRequest();
		fmFmMediationAlarmSyncRequest.setNodeAddress(fdn);
		fmMediationRequestEventSender.send(fmFmMediationAlarmSyncRequest);
		this.logger.trace("FMSServiceBean.startSync <--");
		return ++counter;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ericsson.nms.fm.fm_communicator.FMServiceRemote#ackAlarm(com.ericsson.nms.fm.fm_communicator.AckRequest[])
	 */
	@Override
	public int ackAlarm(final AckRequest ackRequest) {
		this.logger.trace("FMSServiceBean.ackRequest -->");
		this.logger
				.trace("Acknowledge received for - " + ackRequest.toString());
		counter = 0;
		final FmMediationAckRequest fmMediationAckRequest = new FmMediationAckRequest();
		fmMediationAckRequest.setNodeAddress(ackRequest.getOor());
		final List<String> alarmList = new ArrayList<String>();
		alarmList.add(ackRequest.getAlarmId());
		fmMediationAckRequest.setAlarmId(alarmList);
		fmMediationAckRequest.setOperatorName(ackRequest.getOperator());

		if (ackRequest.getAckStatus().equals("ACKNOWLEDGE")) {
			fmMediationAckRequest.setAckStatus(AckStatus.ACKNOWLEDGE);
		} else {
			fmMediationAckRequest.setAckStatus(AckStatus.UNACKNOWLEDGE);
		}

		fmMediationRequestEventSender.send(fmMediationAckRequest);
		this.logger.trace("FMSServiceBean.ackRequest <--");
		return ++counter;
	}
}
