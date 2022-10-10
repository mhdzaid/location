package com.api.jitpay.location.service.impl;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.mapper.LocationMapper;
import com.api.jitpay.location.model.Location;
import com.api.jitpay.location.repository.LocationRepository;
import com.api.jitpay.location.service.LocationService;
import lombok.AllArgsConstructor;
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

    @Override
    public void createLocation(LocationCreationRequest request)
    {
        Location location = locationMapper.locationRequestToLocation(request);
        locationRepository.createLocation(location);
    }

    @Override
    public Location getLatestLocationOfUser(UUID userId)
    {
        return locationRepository.getLatestLocationOfUser(userId);
    }
}
