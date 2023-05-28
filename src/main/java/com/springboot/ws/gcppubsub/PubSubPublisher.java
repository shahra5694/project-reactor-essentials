package com.springboot.ws.gcppubsub;

import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;


@Slf4j
public abstract class PubSubPublisher {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    protected abstract String topic();

    public void publish(PubsubMessage pubsubMessage) throws Exception {
        log.info("Publishing to the topic [{}], message [{}] ", topic(), pubsubMessage);
        pubSubTemplate.publish(topic(),pubsubMessage).get();
    }
}
