package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.AttendeeRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.service.AttendeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public List<Attendee> getAllAttendees(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return attendeeService.getAllAttendees(page, size);
    }
    @GetMapping("/{attendee-id}")
    public Attendee getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        return attendeeService.getAttendeeById(attendeeId);
    }
    @PostMapping
    public Attendee saveAttendee(@RequestBody AttendeeRequest request) {
        return attendeeService.saveAttendee(request);
    }

    @DeleteMapping("/{attendee-id}")
    public Attendee deleteAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        return attendeeService.deleteAttendeeById(attendeeId);
    }

    @PutMapping("/{attendee-id}")
    public Attendee updateAttendeeById(@PathVariable("attendee-id")Integer attendeeId, @RequestBody AttendeeRequest request) {
        return attendeeService.updateAttendeeById(attendeeId, request);
    }
}
