package org.example._1_mao_meanmean_sr_spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Event;

import java.util.List;

@Mapper
public interface EventAttendeeRepository {

    @Results(id = "eventAttendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    @Select("""
                SELECT * FROM event_attendee ea INNER JOIN attendees a ON ea.attendee_id = a.attendee_id WHERE event_id = #{eventId};
            """)
    List<Attendee> getAttendeesByEventId (Integer eventId);
}
