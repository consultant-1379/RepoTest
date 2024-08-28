
package com.ericsson.oss.fmservice.channel;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.channel.annotation.ModeledChannelDefinition;
import com.ericsson.oss.itpf.sdk.modeling.eventbus.channel.annotation.ModeledChannelType;

/**
 * This class defines the channel which will be used by
 * <code>EventBasedMediationClientBean</code> to receive
 * <code>MediationTaskRequest</code> events.
 * 
 * @author eleejhn
 */
@ModeledChannelDefinition(channelId = "EventBasedMediationClient", channelURI = "jms:/queue/MediationClientConsumerQueue", channelType = ModeledChannelType.POINT_TO_POINT)
public class EventBasedMediationClientChannel {
}
