package com.indocyber.store.app.controller;

import com.indocyber.store.app.entity.TransactionHeader;
import com.indocyber.store.app.service.TransactionHeaderService;
import com.indocyber.store.app.utils.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transaction-header")
public class TransactionHeaderController {
    
    private final TransactionHeaderService service;

    public TransactionHeaderController(TransactionHeaderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<?>> getAllTransactionHeader() {
        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK, "success", service.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<?>> createTransactionHeader(@RequestBody TransactionHeader transactionHeader) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>(HttpStatus.CREATED, "success", List.of(service.save(transactionHeader))));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<?>> updateTransactionHeader(@RequestBody TransactionHeader transactionHeader) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", List.of(service.save(transactionHeader))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<?>> removeTransactionHeader(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", null));
    }
}
