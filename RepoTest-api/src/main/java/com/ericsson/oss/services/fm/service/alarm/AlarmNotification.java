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
import java.util.Date;
import java.util.Map;

import com.ericsson.oss.itpf.sdk.eventbus.annotation.PersistenceType;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledAttribute;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledEventDefinition;

/**
 * @author tcsjapa
 * 
 */
@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "FMMediationChannel", description = "AlarmNotification", version = "1.0.0")
public class AlarmNotification extends FmMediationNotification implements
		Serializable {

	private static final long serialVersionUID = 1L;
	@ModeledAttribute(description = "perceivedSeverity")
	private FmEventSeverity perceivedSeverity;
	@ModeledAttribute(description = "sourceType")
	private String sourceType;
	@ModeledAttribute(description = "otherAttributes")
	//private String otherAttributes;
	private Map<String, String> otherAttributes;
	@ModeledAttribute(description = "eventAgentId")
	private String eventAgentId;
	@ModeledAttribute(description = "theTime")
	private Date theTime;
	@ModeledAttribute(description = "timeZone")
	private String timeZone;
	@ModeledAttribute(description = "fmMediationEventId")
	private FmMediationEventId fmMediationEventId;

	/**
	 * @return the fmMediationEventId
	 */
	public FmMediationEventId getFmMediationEventId() {
		return fmMediationEventId;
	}

	/**
	 * @param fmMediationEventId
	 *            the fmMediationEventId to set
	 */
	public void setFmMediationEventId(
			final FmMediationEventId fmMediationEventId) {
		this.fmMediationEventId = fmMediationEventId;
	}

	/**
	 * @return the perceivedSeverity
	 */
	public FmEventSeverity getPerceivedSeverity() {
		return perceivedSeverity;
	}

	/**
	 * @param perceivedSeverity
	 *            the perceivedSeverity to set
	 */
	public void setPerceivedSeverity(final FmEventSeverity perceivedSeverity) {
		this.perceivedSeverity = perceivedSeverity;
	}

	/**
	 * @return the sourceType
	 */
	public String getSourceType() {
		return sourceType;
	}

	/**
	 * @param sourceType
	 *            the sourceType to set
	 */
	public void setSourceType(final String sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * @return the otherAttributes
	 */
	public Map<String, String> getOtherAttributes() {
		return otherAttributes;
	}

	/**
	 * @param otherAttributes
	 *            the otherAttributes to set
	 */
	public void setOtherAttributes(final Map<String, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}

	/**
	 * @return the eventAgentId
	 */
	public String getEventAgentId() {
		return eventAgentId;
	}

	/**
	 * @param eventAgentId
	 *            the eventAgentId to set
	 */
	public void setEventAgentId(final String eventAgentId) {
		this.eventAgentId = eventAgentId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the theTime
	 */
	public Date getTheTime() {
		return theTime;
	}

	/**
	 * @param theTime
	 *            the theTime to set
	 */
	public void setTheTime(final Date theTime) {
		this.theTime = theTime;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(final String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlarmNotification [perceivedSeverity=" + perceivedSeverity
				+ ", sourceType=" + sourceType + ", otherAttributes="
				+ otherAttributes + ", eventAgentId=" + eventAgentId + "]";
	}

}
