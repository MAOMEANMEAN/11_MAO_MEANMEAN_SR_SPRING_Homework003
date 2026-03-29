package org.example._1_mao_meanmean_sr_spring_homework003.service.impl;

import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.EventRequest;
import org.example._1_mao_meanmean_sr_spring_homework003.repository.EventRepository;
import org.example._1_mao_meanmean_sr_spring_homework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        return eventRepository.getAllEvents(offset, size);
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.getEventById(eventId);
    }

    @Override
    public Event saveEvent(EventRequest request) {
        return eventRepository.saveEvent(request);
    }

    @Override
    public Event deleteEventById(Integer eventId) {
        return eventRepository.deleteEventById(eventId);
    }

    @Override
    public Event updateEventById(Integer eventId, EventRequest request) {
        return eventRepository.updateEventById(eventId, request);
    }
}
