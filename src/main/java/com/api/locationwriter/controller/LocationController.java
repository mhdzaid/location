package com.api.locationwriter.controller;

import com.api.locationwriter.dto.LocationCreationRequest;
import com.api.locationwriter.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService locationService;

//    private final UserLocationClient locationClient;

    @Autowired
    private ServerProperties serverProperties;

    @PostMapping("/api/location/user/{userId}")
    public ResponseEntity<Void> createLocation(@PathVariable String userId, @RequestBody LocationCreationRequest request)
    {
        locationService.createLocation(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/location/user/{userId}")
    public ResponseEntity<Void> test(@PathVariable String userId)
    {
        log.info("This is port :{}", serverProperties.getPort());
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/api/user/{userId}/location/_latest")
//    public ResponseEntity<UserLatestLocationResponse> getLatestUserLocation(@PathVariable String userId)
//    {
//        UserLatestLocationResponse response = locationClient.getLatestUserLocation(UUID.fromString(userId));
//        return ResponseEntity.ok().body(response);
//    }
}
