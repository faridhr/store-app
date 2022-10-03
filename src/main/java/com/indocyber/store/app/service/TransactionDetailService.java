package com.indocyber.store.app.service;

import com.indocyber.store.app.entity.TransactionDetail;
import com.indocyber.store.app.repository.TransactionDetailRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.LinkedList;
import java.util.List;

@Service
public class TransactionDetailService {

    private final TransactionDetailRepository repository;

    public TransactionDetailService(TransactionDetailRepository repository) {
        this.repository = repository;
    }

    public List<TransactionDetail> findAll() {
        List<TransactionDetail> resultList = new LinkedList<>();
        repository.findAll().forEach(resultList::add);
        if (resultList.size() < 1) throw new NoResultException("Data not found");
        return resultList;
    }

    public TransactionDetail save(TransactionDetail TransactionDetail) {
        return repository.save(TransactionDetail);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
