package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.MoviecategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieCategoryRepo extends CrudRepository<MoviecategoryEntity,Integer> {
    List<MoviecategoryEntity> findAllByIdMovie(Integer idMovie);
}
