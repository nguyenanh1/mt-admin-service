package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepo extends CrudRepository<TransactionEntity,Integer> {
    @Query(value = "")
    List<TransactionEntity> findAllByIdUserAndTypeOrderByTimeDesc(Integer idUser,int type);
}
