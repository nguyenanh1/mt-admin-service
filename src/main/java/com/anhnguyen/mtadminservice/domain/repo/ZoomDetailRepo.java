package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.ZoomDetailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZoomDetailRepo extends CrudRepository<ZoomDetailEntity,Integer> {
    List<ZoomDetailEntity> findAllByRoom(int room);
}
