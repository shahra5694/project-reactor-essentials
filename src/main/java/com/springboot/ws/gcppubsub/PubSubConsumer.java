package com.springboot.ws.gcppubsub;

import com.google.cloud.pubsub.v1.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;

import java.util.function.Consumer;

public abstract class PubSubConsumer {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    /* Name of the Subscription */
    public abstract String subscription();

    protected abstract void consume(BasicAcknowledgeablePubsubMessage basicAcknowledgeablePubsubMessage);

    public Consumer<BasicAcknowledgeablePubsubMessage> consumer() {
        return this::consume;
    }

    public Subscriber consumeMessage() {
        return this.pubSubTemplate.subscribe(this.subscription(),this.consumer());
    }
}
