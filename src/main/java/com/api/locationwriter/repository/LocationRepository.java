package com.api.locationwriter.repository;

import com.api.locationwriter.model.Location;

import java.util.UUID;

public interface LocationRepository
{
    void createLocation(Location location);

    Location getLatestLocationOfUser(UUID userId);
}
