package org.example._1_mao_meanmean_sr_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_mao_meanmean_sr_spring_homework003.model.entity.Venue;
import org.example._1_mao_meanmean_sr_spring_homework003.model.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {

    @Results(id="venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    @Select("""
                SELECT * FROM venues OFFSET #{offset} LIMIT #{size}
            """)
    List<Venue> getAllVenues(Integer offset, Integer size);

    @ResultMap("venueMapper")
    @Select("""
                SELECT * FROM venues WHERE venue_id = #{venueId};
            """)
    Venue getVenueById(Integer venueId);

    @ResultMap("venueMapper")
    @Select("""
                INSERT INTO venues VALUES (default, #{req.venueName}, #{req.location}) RETURNING * ;
            """)
    Venue saveVenues(@Param("req") VenueRequest request);

    @ResultMap("venueMapper")
    @Select("""
                DELETE FROM venues WHERE venue_id = #{venueId};
            """)
    Venue deleteVenueById(Integer venueId);

    @ResultMap("venueMapper")
    @Select("""
                UPDATE venues SET venue_name = #{req.venueName},
                                  location = #{req.location}
                              WHERE venue_id = #{id} RETURNING *;
            """)
    Venue updateVenueById(@Param("id") Integer venueId, @Param("req") VenueRequest request);
}
