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
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "MediationNotification", version = "1.0.0")
public class MediationNotification implements Serializable {

	@ModeledAttribute(description = "")
	private String jobID;
	// @ModeledAttribute(description = "")
	// private String FDN;
	@ModeledAttribute(description = "")
	private String nodeAddress;

	/**
	 * @return the jobID
	 */
	public String getJobID() {
		return jobID;
	}

	/**
	 * @param jobID
	 *            the jobID to set
	 */
	public void setJobID(final String jobID) {
		this.jobID = jobID;
	}

	/**
	 * @return the nodeAddress
	 */
	public String getNodeAddress() {
		return nodeAddress;
	}

	/**
	 * @param nodeAddress
	 *            the nodeAddress to set
	 */
	public void setNodeAddress(final String nodeAddress) {
		this.nodeAddress = nodeAddress;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MediationNotification [jobID=" + jobID + "]";
	}

}
