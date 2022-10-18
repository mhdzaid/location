package com.api.locationwriter.listener;

import com.api.locationwriter.client.KafkaProducerClient;
import com.api.locationwriter.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class LocationEventListener
{
    private final KafkaProducerClient kafkaProducerClient;

    @Async
    public void handleLocationCreationEvent(Location location)
    {
        kafkaProducerClient.sendMessage(location);
    }
}
