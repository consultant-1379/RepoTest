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
package com.ericsson.oss.services.fm.service.model;

import java.io.Serializable;
import java.util.List;

import com.ericsson.oss.itpf.sdk.eventbus.annotation.PersistenceType;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledAttribute;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledEventDefinition;
import com.ericsson.oss.mediation.core.events.MediationTaskRequest;



/**
 * FmMediationAckRequest job class, with all required information for Acknowledgement
 * requests.
 * 
 * @author xborsre
 * 
 * 
 */
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "EventBasedMediationClient", description = "FmMediationAckRequest", version = "1.0.0")
public class FmMediationAckRequest extends MediationTaskRequest implements  Serializable {

    
    @ModeledAttribute(description = "operatorName")
    private String operatorName;
    @ModeledAttribute(description = "alarmId")
    private List<String> alarmId;
    @ModeledAttribute(description = "ackStatus")
    private AckStatus ackStatus;
   

    public FmMediationAckRequest() {
    }
    
    

	public FmMediationAckRequest(final String nodeAddress, final String jobId,
            final String operatorName, final List<String> alarmId) {
        //super(nodeAddress, jobId);
        this.operatorName = operatorName;
        this.alarmId = alarmId;
       
    }

	
    /**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(final String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * @return the alarmId
	 */
	public List<String> getAlarmId() {
		return alarmId;
	}

	/**
	 * @param alarmId the alarmId to set
	 */
	public void setAlarmId(final List<String> alarmId) {
		this.alarmId = alarmId;
	}
    
	
	/**
	 * @return the ackStatus
	 */
	public AckStatus getAckStatus() {
		return ackStatus;
	}



	/**
	 * @param ackStatus the ackStatus to set
	 */
	public void setAckStatus(final AckStatus ackStatus) {
		this.ackStatus = ackStatus;
	}


	public enum AckStatus {
		ACKNOWLEDGE,
		UNACKNOWLEDGE;
	}	

}
