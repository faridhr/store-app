package com.indocyber.store.app.repository;

import com.indocyber.store.app.entity.TransactionHeader;
import org.springframework.data.repository.CrudRepository;

public interface TransactionHeaderRepository extends CrudRepository<TransactionHeader, Long> {
}
