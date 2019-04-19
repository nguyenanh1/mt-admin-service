package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface ZoomRepo extends CrudRepository<RoomEntity,Integer> {

}
