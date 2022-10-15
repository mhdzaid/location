package com.api.locationwriter.repository.impl;

import com.api.locationwriter.model.Location;
import com.api.locationwriter.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class LocationRepositoryImpl implements LocationRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createLocation(Location location)
    {
        jdbcTemplate.update("insert into location " +
                "(latitude, longitude, created_on, userId) VALUES (?, ?, ?, ?, ?) RETURNING id;",
                  location.getLatitude(), location.getLongitude(), location.getCreatedOn(), location.getUserId());

    }

    @Override
    public Location getLatestLocationOfUser(UUID userId)
    {
        String query = "select * from location where user_id = ? order by id limit 1";
        Location location = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Location.class), userId);
        return location;
    }

}
