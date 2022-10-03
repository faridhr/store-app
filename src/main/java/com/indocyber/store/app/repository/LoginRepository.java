package com.indocyber.store.app.repository;

import com.indocyber.store.app.entity.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long> {
}
