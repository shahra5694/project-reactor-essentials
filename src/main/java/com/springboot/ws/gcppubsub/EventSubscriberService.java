package com.springboot.ws.gcppubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class EventSubscriberService {
    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Value("${pubsub.subscription}")
    private String subscription;

    /**
     *  Created an inbound channel adapter to listen to the subscription `subscription`
     *  and send messages to the input message channel.
     */

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter(@Qualifier("pubsubInputChannel") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
            PubSubInboundChannelAdapter pubSubInboundChannelAdapter = new PubSubInboundChannelAdapter(pubSubTemplate,subscription);
            pubSubInboundChannelAdapter.setOutputChannel(inputChannel);
            pubSubInboundChannelAdapter.setAckMode(AckMode.MANUAL);

            return pubSubInboundChannelAdapter;
    }

    /**
     * Created a message channel for messages arriving from the subscription `subscription`.
     */

    @Bean
    public MessageChannel pubsubInputChannel() {
        return new DirectChannel();
    }

    /**
     * Defined what happens to the messages arriving in the message channel.
     */

    @Bean
    @ServiceActivator(inputChannel = "pubsubInputChannel")
    public MessageHandler messageReceiver() {
        return message -> {
            BasicAcknowledgeablePubsubMessage originalMessage = message.getHeaders().get(GcpPubSubHeaders.ORIGINAL_MESSAGE, BasicAcknowledgeablePubsubMessage.class);
            if (originalMessage != null && originalMessage.getPubsubMessage() != null) {
                originalMessage.ack();
                generateReportHandler(message);
            }
        };
    }

    private void generateReportHandler(Message<?> message) {
        String messagePayload = new String((byte[]) message.getPayload(), StandardCharsets.UTF_8);
        log.info("Message arrived! Payload: " + messagePayload);
    }
}
