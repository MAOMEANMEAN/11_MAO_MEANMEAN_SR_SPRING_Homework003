package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.VenueRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public List<Venue> getAllVenues(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return venueService.getAllVenues(page, size);
    }

    @GetMapping("/{venue-id}")
    public Venue getVenueById(@PathVariable("venue-id") Integer venueId) {
        return venueService.getVenueById(venueId);
    }

    @PostMapping
    public Venue saveVenues(@RequestBody VenueRequest request) {
        return venueService.saveVenues(request);
    }

    @DeleteMapping("/{venue-id}")
    public Venue deleteVenueById(@PathVariable("venue-id") Integer venueId) {
        return venueService.deleteVenueById(venueId);
    }

    @PutMapping("/{venue-id}")
    public Venue updateVenueById(@PathVariable("venue-id") Integer venueId, @RequestBody VenueRequest request) {
        return venueService.updateVenueById(venueId, request);
    }
}
