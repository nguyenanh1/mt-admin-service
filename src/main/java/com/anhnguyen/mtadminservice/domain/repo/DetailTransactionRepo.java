package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.DetailTransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailTransactionRepo extends CrudRepository<DetailTransactionEntity,Integer> {
    DetailTransactionEntity findByIdTicket(int idTicket);
    List<DetailTransactionEntity> findAllByIdTransaction(int idTrans);
}
