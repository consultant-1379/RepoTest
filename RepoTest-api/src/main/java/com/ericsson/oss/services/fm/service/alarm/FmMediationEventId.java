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
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "FmMediationEventId", version = "1.0.0")
public class FmMediationEventId implements Serializable {

	@ModeledAttribute(description = "")
	private long numId;
	@ModeledAttribute(description = "")
	private String stringId;

	/**
	 * @return the numId
	 */
	public long getNumId() {
		return numId;
	}

	/**
	 * @param numId
	 *            the numId to set
	 */
	public void setNumId(final long numId) {
		this.numId = numId;
	}

	/**
	 * @return the stringId
	 */
	public String getStringId() {
		return stringId;
	}

	/**
	 * @param stringId
	 *            the stringId to set
	 */
	public void setStringId(final String stringId) {
		this.stringId = stringId;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FmMediationEventId [numId=" + numId + ", stringId=" + stringId
				+ "]";
	}

}
