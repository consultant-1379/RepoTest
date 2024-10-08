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
package com.ericsson.oss.fmservice.channel;

import com.ericsson.oss.itpf.sdk.modeling.eventbus.channel.annotation.ModeledChannelDefinition;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.channel.annotation.ModeledChannelType;


/**
 * @author tcsjapa
 *
 */
@ModeledChannelDefinition(channelId = "FMMediationChannel", channelURI = "jms:/queue/test", channelType = ModeledChannelType.POINT_TO_POINT)
public class FMMediationChannel {

}
