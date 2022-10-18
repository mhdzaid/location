package com.api.locationwriter.service.impl;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.listener.LocationEventListener;
import com.api.locationwriter.mapper.LocationMapper;
import com.api.locationwriter.model.Location;
import com.api.locationwriter.publisher.LocationEventPublisher;
import com.api.locationwriter.repository.LocationRepository;
import com.api.locationwriter.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class LocationServiceImpl implements LocationService
{
    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    private final LocationEventListener locationEventListener;

    @Override
    public void createLocation(LocationCreationRequest request)
    {
        Location location = locationMapper.locationRequestToLocation(request);
        locationRepository.createLocation(location);
        locationEventListener.handleLocationCreationEvent(location);
    }
}
