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
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "FmMediationNotification", version = "1.0.0")
public class FmMediationNotification extends MediationNotification implements
		Serializable {

	private static final long serialVersionUID = 1L;
	@ModeledAttribute(description = "")
	private String specificProblem;
	@ModeledAttribute(description = "")
	private String probableCause;
	@ModeledAttribute(description = "")
	private String eventType;

	/**
	 * @return the specificProblem
	 */
	public String getSpecificProblem() {
		return specificProblem;
	}

	/**
	 * @param specificProblem
	 *            the specificProblem to set
	 */
	public void setSpecificProblem(final String specificProblem) {
		this.specificProblem = specificProblem;
	}

	/**
	 * @return the probableCause
	 */
	public String getProbableCause() {
		return probableCause;
	}

	/**
	 * @param probableCause
	 *            the probableCause to set
	 */
	public void setProbableCause(final String probableCause) {
		this.probableCause = probableCause;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(final String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FmMediationNotification [specificProblem=" + specificProblem
				+ ", probableCause=" + probableCause + ", eventType="
				+ eventType + "]";
	}

}
