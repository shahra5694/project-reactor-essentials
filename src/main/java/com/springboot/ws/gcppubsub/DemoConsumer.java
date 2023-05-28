package com.springboot.ws.gcppubsub;

import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoConsumer extends PubSubConsumer {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Value("${pubsub.subscription}")
    private String subscription;

    @Override
    public String subscription() {
        return this.subscription;
    }

    @Override
    protected void consume(BasicAcknowledgeablePubsubMessage basicAcknowledgeablePubsubMessage) {
           PubsubMessage pubsubMessage = basicAcknowledgeablePubsubMessage.getPubsubMessage();
           try {
               log.info("Record to be consumed :::: {} ", pubsubMessage.getData().toStringUtf8());
               log.info("Message ID ::: {} ", pubsubMessage.getMessageId());
               log.info("Consumer Attribute Map ::: {} ", pubsubMessage.getAttributesMap());
           }
           catch(Exception ex) {
               log.error("Error Occurred while receiving pubsub message:::::", ex);
           }
           basicAcknowledgeablePubsubMessage.ack();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        log.info("Subscribing [{}] to subscription [{}]", this.getClass().getSimpleName(),this.subscription());
        pubSubTemplate.subscribe(this.subscription(),this.consumer());
    }
}
