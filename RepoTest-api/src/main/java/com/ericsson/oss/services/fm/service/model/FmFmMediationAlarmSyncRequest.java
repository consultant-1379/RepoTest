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

import com.ericsson.oss.itpf.sdk.eventbus.annotation.PersistenceType;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.annotation.ModeledEventDefinition;
import com.ericsson.oss.mediation.core.events.MediationTaskRequest;




/**
 * 
 * FmFmMediationAlarmSyncRequest
 * 
 * <p>
 * FmFmMediationAlarmSyncRequest for alarm synchronization mediation request.
 * <p>
 * 
 * @author xborsre
 * 
 */

@ModeledEventDefinition(persistenceType = PersistenceType.NON_PERSISTENT, defaultChannelId = "EventBasedMediationClient", description = "FmFmMediationAlarmSyncRequest", version = "1.0.0")
public class FmFmMediationAlarmSyncRequest extends MediationTaskRequest implements Serializable {
}
