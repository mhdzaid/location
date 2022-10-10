package com.api.jitpay.location.repository;

import com.api.jitpay.location.model.Location;

import java.util.UUID;

public interface LocationRepository
{
    void createLocation(Location location);

    Location getLatestLocationOfUser(UUID userId);
}
