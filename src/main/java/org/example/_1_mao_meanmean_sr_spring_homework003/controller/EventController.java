package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.EventRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return eventService.getAllEvents(page, size);
    }

    @GetMapping({"/{event-id}"})
    public Event getEventById(@PathVariable("event-id") Integer eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping
    public Event saveEvent(@RequestBody EventRequest request) {
        return eventService.saveEvent(request);
    }

    @DeleteMapping("/{event-id}")
    public Event deleteEventById(@PathVariable("event-id") Integer eventId) {
        return eventService.deleteEventById(eventId);
    }

    @PutMapping("/{event-id}")
    public Event updateEventById(@PathVariable("event-id") Integer eventId, @RequestBody EventRequest request) {
        return eventService.updateEventById(eventId, request);
    }

}
