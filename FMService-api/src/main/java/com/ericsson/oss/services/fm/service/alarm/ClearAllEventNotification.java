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
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "ClearAllEventNotification", version = "1.0.0")
public class ClearAllEventNotification extends MediationNotification implements
		Serializable {
	@ModeledAttribute(description = "")
	private String topObjectName;

	/**
	 * @return the topObjectName
	 */
	public String getTopObjectName() {
		return topObjectName;
	}

	/**
	 * @param topObjectName
	 *            the topObjectName to set
	 */
	public void setTopObjectName(final String topObjectName) {
		this.topObjectName = topObjectName;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClearAllEventNotification [topObjectName=" + topObjectName
				+ "]";
	}

}
