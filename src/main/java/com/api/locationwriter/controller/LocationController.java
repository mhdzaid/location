package com.api.locationwriter.controller;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService locationService;

    @PostMapping("/api/location/user/{userId}")
    public ResponseEntity<Void> createLocation(@PathVariable String userId, @RequestBody LocationCreationRequest request)
    {
        locationService.createLocation(request);
        return ResponseEntity.ok().build();
    }

}
