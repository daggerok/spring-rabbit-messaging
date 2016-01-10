package daggerok.messaging.rabbit;

import daggerok.messaging.rabbit.config.messaging.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MessagingRabbitApplication.class)
public class MessagingRabbitApplicationTests {
    @Autowired ApplicationContext applicationContext;

    @Autowired Sender sender;

    @Autowired CountDownLatch countDownLatch;

    @Test
    public void contextLoads() {
        assertNotNull("null applicationContext", applicationContext);

        assertTrue("receiver bean wasn't found", applicationContext.containsBean("receiver"));
        assertTrue("sender bean wasn't found", applicationContext.containsBean("sender"));

        assertTrue("rabbitCfg bean wasn't found", applicationContext.containsBean("rabbitCfg"));

        assertTrue("cfg bean wasn't found", applicationContext.containsBean("cfg"));

        assertTrue("messagingRabbitApplication bean wasn't found",
                applicationContext.containsBean("messagingRabbitApplication"));
    }

    @Test
    public void testSenderReceiver() throws Exception {
        sender.send("hello, folks!");
        countDownLatch.await(5, TimeUnit.SECONDS);
        // just run test and verify such lines from logs output:
        // ... d.m.rabbit.config.messaging.Sender       : sending a message...
        // ... d.m.rabbit.config.messaging.Receiver     : received new message! content: hello, folks!
    }
}