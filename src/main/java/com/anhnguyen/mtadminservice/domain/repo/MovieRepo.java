package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepo extends CrudRepository<MovieEntity,Integer> {
    //List<MovieEntity> findAll();

    @Query(value = "SELECT * FROM movie_cinema.movie where movie_cinema.movie.part_time < :part_date and status = 1 limit :start,:limit  ", nativeQuery = true)
    List<MovieEntity> getListMovieIsShowing(@Param("part_date")int part_date,
                                            @Param("start")int start,
                                            @Param("limit")int limit);

    @Query(value = "SELECT * FROM movie_cinema.movie where movie_cinema.movie.part_time > :part_date and status = 1 limit :start,:limit ", nativeQuery = true)
    List<MovieEntity> getListMovieCommingSoon(@Param("part_date")int part_date,
                                            @Param("start")int start,
                                            @Param("limit")int limit);
    @Query(value = "SELECT  * from movie_cinema.movie order by movie_cinema.movie.view and status = 1 desc limit 5" ,nativeQuery = true)
    List<MovieEntity> getTopView();

}
