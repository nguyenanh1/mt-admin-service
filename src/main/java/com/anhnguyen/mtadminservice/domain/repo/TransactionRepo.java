package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<TransactionEntity,Integer> {
}
