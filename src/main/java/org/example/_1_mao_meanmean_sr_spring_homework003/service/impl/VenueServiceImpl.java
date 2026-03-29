package org.example._1_mao_meanmean_sr_spring_homework003.service.impl;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.VenueRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.repository.VenueRepository;
import org.example._1_mao_meanmean_sr_spring_homework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenues(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        return venueRepository.getAllVenues(offset, size);
    }

    @Override
    public Venue getVenueById(Integer venueId) {
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public Venue saveVenues(VenueRequest request) {
        return venueRepository.saveVenues(request);
    }

    @Override
    public Venue deleteVenueById(Integer venueId) {
        return venueRepository.deleteVenueById(venueId);
    }

    @Override
    public Venue updateVenueById(Integer venueId, VenueRequest request) {
        return venueRepository.updateVenueById(venueId, request);
    }
}
