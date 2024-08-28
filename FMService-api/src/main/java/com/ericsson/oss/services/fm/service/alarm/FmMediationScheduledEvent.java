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
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "FmMediationScheduledEvent", version = "1.0.0")
public class FmMediationScheduledEvent extends FmMediationEvent implements
		Serializable {

	private static final long serialVersionUID = 1L;
	@ModeledAttribute(description = "")
	private int scheduledTime;
	@ModeledAttribute(description = "")
	private int scheduledDate;
	@ModeledAttribute(description = "")
	private int timeInterval;

	/**
	 * @return the scheduledTime
	 */
	public int getScheduledTime() {
		return scheduledTime;
	}

	/**
	 * @param scheduledTime
	 *            the scheduledTime to set
	 */
	public void setScheduledTime(final int scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	/**
	 * @return the scheduledDate
	 */
	public int getScheduledDate() {
		return scheduledDate;
	}

	/**
	 * @param scheduledDate
	 *            the scheduledDate to set
	 */
	public void setScheduledDate(final int scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	/**
	 * @return the timeInterval
	 */
	public int getTimeInterval() {
		return timeInterval;
	}

	/**
	 * @param timeInterval
	 *            the timeInterval to set
	 */
	public void setTimeInterval(final int timeInterval) {
		this.timeInterval = timeInterval;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FmMediationScheduledEvent [scheduledTime=" + scheduledTime
				+ ", scheduledDate=" + scheduledDate + ", timeInterval="
				+ timeInterval + "]";
	}

}
