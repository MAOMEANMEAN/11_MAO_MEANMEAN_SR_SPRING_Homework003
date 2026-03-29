package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.EventRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.model.response.ApiResponseAttendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.response.ApiResponseEvent;
import org.example._1_mao_meanmean_sr_spring_homework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseEvent<List<Event>>> getAllEvents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Event> events = eventService.getAllEvents(page, size);
        ApiResponseEvent<List<Event>> response = ApiResponseEvent.<List<Event>>builder().timestamp(Instant.now()).message("Retrieved events successfully").status(HttpStatus.OK).payload(events).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping({"/{event-id}"})
    public ResponseEntity<ApiResponseEvent<Event>> getEventById(@PathVariable("event-id") Integer eventId) {
        Event event = eventService.getEventById(eventId);
        ApiResponseEvent<Event> response = ApiResponseEvent.<Event>builder().timestamp(Instant.now()).message("Retrieved event with id " + eventId + " successfully").status(HttpStatus.OK).payload(event).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseEvent<Event>> saveEvent(@RequestBody EventRequest request) {
        Event event = eventService.saveEvent(request);
        ApiResponseEvent<Event> response = ApiResponseEvent.<Event>builder().timestamp(Instant.now()).message("Created event successfully").status(HttpStatus.CREATED).payload(event).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponseEvent<Void>> deleteEventById(@PathVariable("event-id") Integer eventId) {
        Event event = eventService.deleteEventById(eventId);
        ApiResponseEvent<Void> response = ApiResponseEvent.<Void>builder().timestamp(Instant.now()).message("Deleted event with id " + eventId + " successfully").status(HttpStatus.OK).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponseEvent<Event>> updateEventById(@PathVariable("event-id") Integer eventId, @RequestBody EventRequest request) {
        Event event = eventService.updateEventById(eventId ,request);
        ApiResponseEvent<Event> response = ApiResponseEvent.<Event>builder().timestamp(Instant.now()).message("Updated event with id " + eventId + " successfully").status(HttpStatus.OK).payload(event).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
