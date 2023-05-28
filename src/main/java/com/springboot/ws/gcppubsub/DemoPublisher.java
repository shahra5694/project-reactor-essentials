package com.springboot.ws.gcppubsub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class DemoPublisher extends PubSubPublisher {

    @Value("${pubsub.topic}")
    private String topic;

    @Override
    protected String topic() {
        return this.topic;
    }

    public void publishMessage(Object message) throws Exception {
        log.info("Sending Message to the topic ::: {}", this.topic());
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(ByteString.copyFromUtf8(convertToJson(message)))
                .build();

        super.publish(pubsubMessage);
    }

    public String convertToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writeValueAsString(obj);
    }

}
