package com.api.locationwriter.mapper;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper
{
    @Mapping(target="latitude", source="request.location.latitude")
    @Mapping(target="longitude", source="request.location.longitude")
    Location locationRequestToLocation(LocationCreationRequest request);

}
