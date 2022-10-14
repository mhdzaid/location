package com.api.location.repository;

import com.api.location.model.Location;

import java.util.UUID;

public interface LocationRepository
{
    void createLocation(Location location);

    Location getLatestLocationOfUser(UUID userId);
}
