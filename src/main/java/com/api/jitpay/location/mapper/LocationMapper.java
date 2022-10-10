package com.api.jitpay.location.mapper;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper
{
    Location locationRequestToLocation(LocationCreationRequest locationCreationRequest);

//    UserLatestLocationResponse locationAndUserToLatestLocation(User user, Location location);
}
