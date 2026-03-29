package org.example._1_mao_meanmean_sr_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id", one = @One(select = "org.example._1_mao_meanmean_sr_spring_homework003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id", many = @Many(select = "org.example._1_mao_meanmean_sr_spring_homework003.repository.EventAttendeeRepository.getAttendeesByEventId"))
    })
    @Select("""
                SELECT * FROM events OFFSET #{offset} LIMIT #{size};
            """)
    List<Event> getAllEvents(Integer offset, Integer size);

    @ResultMap("eventMapper")
    @Select("""
                SELECT * FROM events WHERE event_id = #{eventId};
            """)
    Event getEventById(Integer eventId);

    @ResultMap("eventMapper")
    @Select("""
                INSERT INTO events VALUES (default, #{req.eventName}, #{req.eventDate}, #{req.venueId}) RETURNING *;
            """)
    Event saveEvent(@Param("req") EventRequest request);

    @ResultMap("eventMapper")
    @Select("""
               DELETE FROM events WHERE event_id = #{eventId};
           """)
    Event deleteEventById(Integer eventId);

    @ResultMap("eventMapper")
    @Select("""
                UPDATE events SET event_name = #{req.eventName},
                                  event_date = #{req.eventDate},
                                  venue_id = #{req.venueId} RETURNING *;
            """)
    Event updateEventById(@Param("id") Integer eventId, @Param("req") EventRequest request);
}
