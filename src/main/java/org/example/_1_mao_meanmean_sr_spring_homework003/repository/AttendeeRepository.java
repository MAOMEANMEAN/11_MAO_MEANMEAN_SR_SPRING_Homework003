package org.example._1_mao_meanmean_sr_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Attendee;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    @Select("""
                SELECT * FROM attendees OFFSET #{offset} LIMIT #{size}
            """)
    List<Attendee> getAllAttendees(Integer offset, Integer size);

    @ResultMap("attendeeMapper")
    @Select("""
                SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
            """)
    Attendee getAttendeeById(Integer attendeeId);

    @ResultMap("attendeeMapper")
    @Select("""
                INSERT INTO attendees VALUES (default, #{req.attendeeName}, #{req.email}) RETURNING *;
            """)
    Attendee saveAttendee(@Param("req") AttendeeRequest request);

    @ResultMap("attendeeMapper")
    @Select("""
                DELETE FROM attendees WHERE attendee_id = #{attendeeId}
            """)
    Attendee deleteAttendeeById(Integer attendeeId);

    @ResultMap("attendeeMapper")
    @Select("""
                UPDATE attendees SET attendee_name = #{req.attendeeName},
                                     email = #{req.email}
                                 WHERE attendee_id = #{id} RETURNING *;
            """)
    Attendee updateAttendeeById(@Param("id") Integer attendeeId, @Param("req") AttendeeRequest request);
}
