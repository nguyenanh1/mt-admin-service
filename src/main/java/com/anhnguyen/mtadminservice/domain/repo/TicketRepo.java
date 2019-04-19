package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends CrudRepository<TicketEntity,Integer> {
    @Query(value = "SELECT * FROM movie_cinema.ticket where movie_cinema.ticket.id_movietime = :idMovie order by movie_cinema.ticket.id_zoom_detail asc",nativeQuery = true)
    List<TicketEntity> getListTicket(@Param("idMovie") Integer idMovie);
}
