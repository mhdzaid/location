package com.api.jitpay.location.service;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.model.Location;

import java.util.UUID;

public interface LocationService
{
    void createLocation(LocationCreationRequest request);

    Location getLatestLocationOfUser(UUID userId);
}
