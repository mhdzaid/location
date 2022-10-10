//package com.api.jitpay.location.client;
//
//import com.api.jitpay.location.dto.UserLatestLocationResponse;
//import com.api.jitpay.location.mapper.LocationMapper;
//import com.api.jitpay.location.model.Location;
//import com.api.jitpay.location.service.LocationService;
//import com.api.jitpay.user.model.User;
//import com.api.jitpay.user.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//public class UserLocationClient
//{
//    private final UserService userService;
//
//    private final LocationService locationService;
//
//    private final LocationMapper locationMapper;
//
//    public UserLatestLocationResponse getLatestUserLocation(UUID userId)
//    {
//        User user = userService.getUser(userId);
//        Location location = locationService.getLatestLocationOfUser(userId);
//        UserLatestLocationResponse response = locationMapper.locationAndUserToLatestLocation(user, location);
//        return response;
//    }
//}
