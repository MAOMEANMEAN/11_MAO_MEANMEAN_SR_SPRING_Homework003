package org.example._1_mao_meanmean_sr_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;

import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private Instant eventDate;
    private Integer venueId;
    private List<Integer> attendeeIds;
}
