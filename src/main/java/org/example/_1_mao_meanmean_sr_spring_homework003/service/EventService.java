package org.example._1_mao_meanmean_sr_spring_homework003.service;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(Integer page, Integer size);

    Event getEventById(Integer eventId);

    Event saveEvent(EventRequest request);

    Event deleteEventById(Integer eventId);

    Event updateEventById(Integer eventId, EventRequest request);
}
