package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.MovieEntity;
import com.anhnguyen.mtadminservice.domain.mysql.MovietimeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieTimeRepo extends CrudRepository<MovietimeEntity,Integer> {
    @Query(value = "select * from movie_cinema.movietime where movie_cinema.movietime.id_movie = :id and movie_cinema.movietime.date_start = :date " +
            "and movie_cinema.movietime.time_start > :time order by movie_cinema.movietime.time_start asc ", nativeQuery = true)
    List<MovietimeEntity> getAllByIdAndDate(@Param("id") int idMovie,
                                            @Param("date")int date,
                                            @Param("time")int time);
}
