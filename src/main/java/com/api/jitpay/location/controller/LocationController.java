package com.api.jitpay.location.controller;

import com.api.jitpay.location.dto.LocationCreationRequest;
import com.api.jitpay.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService locationService;

//    private final UserLocationClient locationClient;

    @PostMapping("/api/user/{userId}/location")
    public ResponseEntity<Void> createLocation(@PathVariable String userId, @RequestBody LocationCreationRequest request)
    {
        locationService.createLocation(request);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/api/user/{userId}/location/_latest")
//    public ResponseEntity<UserLatestLocationResponse> getLatestUserLocation(@PathVariable String userId)
//    {
//        UserLatestLocationResponse response = locationClient.getLatestUserLocation(UUID.fromString(userId));
//        return ResponseEntity.ok().body(response);
//    }
}
