package org.example._1_mao_meanmean_sr_spring_homework003.controller;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.AttendeeRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.model.response.ApiResponseAttendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.response.ApiResponseVenue;
import org.example._1_mao_meanmean_sr_spring_homework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseAttendee<List<Attendee>>> getAllAttendees(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Attendee> attendees = attendeeService.getAllAttendees(page, size);
        ApiResponseAttendee<List<Attendee>> response = ApiResponseAttendee.<List<Attendee>>builder().timestamp(Instant.now()).message("Retrieved attendees successfully").status(HttpStatus.OK).payload(attendees).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponseAttendee<Attendee>> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        Attendee attendee = attendeeService.getAttendeeById(attendeeId);
        ApiResponseAttendee<Attendee> response = ApiResponseAttendee.<Attendee>builder().timestamp(Instant.now()).message("Retrieved attendee with id " + attendeeId + " successfully").status(HttpStatus.OK).payload(attendee).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponseAttendee<Attendee>> saveAttendee(@RequestBody AttendeeRequest request) {
        Attendee attendee = attendeeService.saveAttendee(request);
        ApiResponseAttendee<Attendee> response = ApiResponseAttendee.<Attendee>builder().timestamp(Instant.now()).message("Created attendee successfully").status(HttpStatus.CREATED).payload(attendee).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponseAttendee<Void>> deleteAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        Attendee attendee = attendeeService.deleteAttendeeById(attendeeId);
        ApiResponseAttendee<Void> response = ApiResponseAttendee.<Void>builder().timestamp(Instant.now()).message("Deleted attendee with id " + attendeeId + " successfully").status(HttpStatus.OK).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponseAttendee<Attendee>> updateAttendeeById(@PathVariable("attendee-id")Integer attendeeId, @RequestBody AttendeeRequest request) {
        Attendee attendee = attendeeService.updateAttendeeById(attendeeId ,request);
        ApiResponseAttendee<Attendee> response = ApiResponseAttendee.<Attendee>builder().timestamp(Instant.now()).message("Updated attendee with id " + attendeeId + " successfully").status(HttpStatus.OK).payload(attendee).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
