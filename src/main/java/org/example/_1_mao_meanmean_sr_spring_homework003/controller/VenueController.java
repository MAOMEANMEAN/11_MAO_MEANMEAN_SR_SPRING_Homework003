package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import org.example._1_mao_meanmean_sr_spring_homework003.exception.NotFoundException;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.VenueRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.model.response.ApiResponseVenue;
import org.example._1_mao_meanmean_sr_spring_homework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseVenue<List<Venue>>> getAllVenues(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Venue> venues = venueService.getAllVenues(page, size);
        ApiResponseVenue<List<Venue>> response = ApiResponseVenue.<List<Venue>>builder().timestamp(Instant.now()).message("Retrieved venues successfully").status(HttpStatus.OK).payload(venues).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponseVenue<Venue>> getVenueById(@PathVariable("venue-id") Integer venueId) { 
        Venue venue = venueService.getVenueById(venueId);
        ApiResponseVenue<Venue> response = ApiResponseVenue.<Venue>builder().timestamp(Instant.now()).message("Retrieved venue with id " + venueId + " successfully").status(HttpStatus.OK).payload(venue).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseVenue<Venue>> saveVenues(@RequestBody VenueRequest request) {
        Venue venue = venueService.saveVenues(request);
        ApiResponseVenue<Venue> response = ApiResponseVenue.<Venue>builder().timestamp(Instant.now()).message("Created venue successfully").status(HttpStatus.CREATED).payload(venue).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponseVenue<Void>> deleteVenueById(@PathVariable("venue-id") Integer venueId) {
        Venue venue = venueService.deleteVenueById(venueId);
        ApiResponseVenue<Void> response = ApiResponseVenue.<Void>builder().timestamp(Instant.now()).message("Deleted venue with id " + venueId + " successfully").status(HttpStatus.OK).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponseVenue<Venue>> updateVenueById(@PathVariable("venue-id") Integer venueId, @RequestBody VenueRequest request) {
        try {
            Venue venue = venueService.updateVenueById(venueId ,request);
            ApiResponseVenue<Venue> response = ApiResponseVenue.<Venue>builder().timestamp(Instant.now()).message("Updated venue with id " + venueId + " successfully").status(HttpStatus.OK).payload(venue).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (NotFoundException e){
            ApiResponseVenue<Venue> response = ApiResponseVenue.<Venue>builder().timestamp(Instant.now()).message("Updated venue with id " + venueId + " not found").status(HttpStatus.OK).payload(null).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
