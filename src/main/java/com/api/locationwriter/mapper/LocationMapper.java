package com.api.locationwriter.mapper;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper
{
    Location locationRequestToLocation(LocationCreationRequest locationCreationRequest);

}
