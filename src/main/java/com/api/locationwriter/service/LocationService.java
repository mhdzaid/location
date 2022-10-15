package com.api.locationwriter.service;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.model.Location;

import java.util.UUID;

public interface LocationService
{
    void createLocation(LocationCreationRequest request);
}
