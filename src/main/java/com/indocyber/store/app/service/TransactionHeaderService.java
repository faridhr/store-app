package com.indocyber.store.app.service;

import com.indocyber.store.app.entity.TransactionHeader;
import com.indocyber.store.app.repository.TransactionHeaderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.LinkedList;
import java.util.List;

@Service
public class TransactionHeaderService {

    private final TransactionHeaderRepository repository;

    public TransactionHeaderService(TransactionHeaderRepository repository) {
        this.repository = repository;
    }

    public List<TransactionHeader> findAll() {
        List<TransactionHeader> resultList = new LinkedList<>();
        repository.findAll().forEach(resultList::add);
        if (resultList.size() < 1) throw new NoResultException("Data not found");
        return resultList;
    }

    public TransactionHeader save(TransactionHeader transactionHeader) {
        return repository.save(transactionHeader);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
