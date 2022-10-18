package com.api.locationwriter.publisher;

import com.api.locationwriter.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationEventPublisher
{
    private final ApplicationEventPublisher applicationEventPublisher;

    public void raiseLocationCreationEvent(Location location)
    {
        applicationEventPublisher.publishEvent(location);
    }
}
