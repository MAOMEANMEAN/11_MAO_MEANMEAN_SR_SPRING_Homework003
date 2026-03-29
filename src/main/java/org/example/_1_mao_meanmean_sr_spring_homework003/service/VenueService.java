package org.example._1_mao_meanmean_sr_spring_homework003.service;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(Integer page, Integer size);

    Venue getVenueById(Integer venue_Id);

    Venue saveVenues(VenueRequest request);

    Venue deleteVenueById(Integer venueId);

    Venue updateVenueById(Integer venueId, VenueRequest request);
}
