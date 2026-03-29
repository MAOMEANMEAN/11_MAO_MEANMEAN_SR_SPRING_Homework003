package org.example._1_mao_meanmean_sr_spring_homework003.service.impl;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.AttendeeRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.repository.AttendeeRepository;
import org.example._1_mao_meanmean_sr_spring_homework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendees(Integer page, Integer size) {
        Integer offset = (page -1) * size;
        return attendeeRepository.getAllAttendees(offset, size);
    }

    @Override
    public Attendee getAttendeeById(Integer attendeeId) {
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public Attendee saveAttendee(AttendeeRequest request) {
        return attendeeRepository.saveAttendee(request);
    }

    @Override
    public Attendee deleteAttendeeById(Integer attendeeId) {
        return attendeeRepository.deleteAttendeeById(attendeeId);
    }

    @Override
    public Attendee updateAttendeeById(Integer attendeeId, AttendeeRequest request) {
        return attendeeRepository.updateAttendeeById(attendeeId, request);
    }
}
