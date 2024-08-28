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
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledEventDefinition;

/**
 * @author tcsjapa
 *
 */
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "EventCloseNotification", version = "1.0.0")
public class EventCloseNotification extends MediationNotification implements
		Serializable {

	private EventState previousEventState;
	private String operator;
	private String orginatorName;

	/**
	 * @return the previousEventState
	 */
	public EventState getPreviousEventState() {
		return previousEventState;
	}

	/**
	 * @param previousEventState
	 *            the previousEventState to set
	 */
	public void setPreviousEventState(final EventState previousEventState) {
		this.previousEventState = previousEventState;
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
	 * @return the orginatorName
	 */
	public String getOrginatorName() {
		return orginatorName;
	}

	/**
	 * @param orginatorName
	 *            the orginatorName to set
	 */
	public void setOrginatorName(final String orginatorName) {
		this.orginatorName = orginatorName;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventCloseNotification [previousEventState="
				+ previousEventState + ", operator=" + operator
				+ ", orginatorName=" + orginatorName + "]";
	}

}
