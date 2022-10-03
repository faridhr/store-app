package com.indocyber.store.app.controller;

import com.indocyber.store.app.entity.Product;
import com.indocyber.store.app.service.ProductService;
import com.indocyber.store.app.utils.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<?>> getAllProduct() {
        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK, "success", service.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<?>> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>(HttpStatus.CREATED, "success", List.of(service.save(product))));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<?>> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", List.of(service.save(product))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<?>> removeProduct(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(HttpStatus.OK, "success", null));
    }
}
