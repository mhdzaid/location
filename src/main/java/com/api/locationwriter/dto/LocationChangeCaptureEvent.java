package com.api.locationwriter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationChangeCaptureEvent
{
    private Long id;

    private double latitude;

    private double longitude;

    private LocalDateTime createdOn;

    private UUID userId;
}
