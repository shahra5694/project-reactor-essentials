package academy.development;

import com.springboot.ws.gcppubsub.DemoPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ContextConfiguration(classes = {DemoPublisher.class})
//@WebFluxTest(excludeAutoConfiguration = ReactiveSecurityAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
public class PubSub {

    @Autowired
    private DemoPublisher demoPublisher;

    @MockBean
    private PubSubTemplate pubSubTemplate;

    @Test
    void verifyPublisher() throws Exception {
        demoPublisher.publishMessage("Hello Loblaw");
    }
}
