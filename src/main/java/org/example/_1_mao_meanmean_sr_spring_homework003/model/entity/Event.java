package org.example._1_mao_meanmean_sr_spring_homework003.model.entity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private Instant eventDate;
    private Venue venue;
    private List<Attendee> attendees;
}

