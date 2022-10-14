package com.api.location.mapper;

import com.api.location.dto.LocationCreationRequest;
import com.api.location.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper
{
    Location locationRequestToLocation(LocationCreationRequest locationCreationRequest);

//    UserLatestLocationResponse locationAndUserToLatestLocation(User user, Location location);
}
