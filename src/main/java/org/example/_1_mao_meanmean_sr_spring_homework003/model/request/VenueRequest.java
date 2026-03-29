package org.example._1_mao_meanmean_sr_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    private String venueName;
    private String location;
}
