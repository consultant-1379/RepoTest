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
package com.ericsson.oss.services.fm.service.alarm;

import java.io.Serializable;

import com.ericsson.oss.itpf.sdk.eventbus.annotation.PersistenceType;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledAttribute;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledEventDefinition;

/**
 * @author tcsjapa
 *
 */
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "AckInfo", version = "1.0.0")
public class AckInfo implements Serializable {
	@ModeledAttribute(description = "")
	private FmMediationEventAckStatus ackStatus;
	@ModeledAttribute(description = "")
	private String operator;
	@ModeledAttribute(description = "")
	private String ackTime;

	/**
	 * @return the ackStatus
	 */
	public FmMediationEventAckStatus getAckStatus() {
		return ackStatus;
	}

	/**
	 * @param ackStatus
	 *            the ackStatus to set
	 */
	public void setAckStatus(final FmMediationEventAckStatus ackStatus) {
		this.ackStatus = ackStatus;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(final String operator) {
		this.operator = operator;
	}

	/**
	 * @return the ackTime
	 */
	public String getAckTime() {
		return ackTime;
	}

	/**
	 * @param ackTime
	 *            the ackTime to set
	 */
	public void setAckTime(final String ackTime) {
		this.ackTime = ackTime;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AckInfo [ackStatus=" + ackStatus + ", operator=" + operator
				+ ", ackTime=" + ackTime + "]";
	}

}
