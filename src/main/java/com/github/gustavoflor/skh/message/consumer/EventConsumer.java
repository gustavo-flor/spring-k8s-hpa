package com.github.gustavoflor.skh.message.consumer;

import com.github.gustavoflor.skh.message.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class EventConsumer implements Consumer<Message<Event>> {

    private static final String START_MESSAGE = "Started: event={} partition={}";
    private static final String FINISHED_MESSAGE = "Finished: event={} partition={}";
    private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);

    @Override
    public void accept(final Message<Event> message) {
        final var event = message.getPayload();
        final var partition = message.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION, Integer.class);
        LOGGER.info(START_MESSAGE, event, partition);
        event.sleep();
        LOGGER.info(FINISHED_MESSAGE, event, partition);
    }

}
