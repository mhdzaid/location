package com.api.locationwriter.service.impl;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.mapper.LocationMapper;
import com.api.locationwriter.model.Location;
import com.api.locationwriter.repository.LocationRepository;
import com.api.locationwriter.service.LocationService;
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
