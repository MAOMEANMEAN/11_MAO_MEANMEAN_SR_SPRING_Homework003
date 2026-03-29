package org.example._1_mao_meanmean_sr_spring_homework003.service;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees(Integer page, Integer size);

    Attendee getAttendeeById(Integer attendeeId);

    Attendee saveAttendee(AttendeeRequest request);

    Attendee deleteAttendeeById(Integer attendeeId);

    Attendee updateAttendeeById(Integer attendeeId, AttendeeRequest request);
}
