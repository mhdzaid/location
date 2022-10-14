package com.api.location.service;

import com.api.location.dto.LocationCreationRequest;
import com.api.location.model.Location;

import java.util.UUID;

public interface LocationService
{
    void createLocation(LocationCreationRequest request);

    Location getLatestLocationOfUser(UUID userId);
}
