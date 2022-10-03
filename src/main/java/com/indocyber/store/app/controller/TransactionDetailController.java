package com.indocyber.store.app.controller;

import com.indocyber.store.app.entity.TransactionDetail;
import com.indocyber.store.app.service.TransactionDetailService;
import com.indocyber.store.app.utils.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction-detail")
public class TransactionDetailController {
    
    private final TransactionDetailService service;

    public TransactionDetailController(TransactionDetailService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<?>> getAllTransactionDetail() {
        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK, "success", service.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<?>> createTransactionDetail(@RequestBody TransactionDetail transactionDetail) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>(HttpStatus.CREATED, "success", List.of(service.save(transactionDetail))));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<?>> updateTransactionDetail(@RequestBody TransactionDetail transactionDetail) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", List.of(service.save(transactionDetail))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<?>> removeTransactionDetail(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", null));
    }
}
