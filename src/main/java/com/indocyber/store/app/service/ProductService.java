package com.indocyber.store.app.service;

import com.indocyber.store.app.entity.Product;
import com.indocyber.store.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        List<Product> productList = new LinkedList<>();
        repository.findAll().forEach(e -> {
            e.setDiscountPrice(this.discount(e.getPrice(), e.getDiscount()));
            productList.add(e);
        });
        if (productList.size() < 1) throw new NoResultException("Data not found");
        return productList;
    }

    private Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoResultException("Data with id " + id + " not found"));
    }

    private List<Product> findByName(String name) {
        List<Product> productList = repository.findByProductNameContains(name);
        if (productList.size() < 1) throw new NoResultException("Data " + name + " not found");
        return productList;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Double discount(Double value, Integer discount) {
        if (discount.equals(0)) return discount.doubleValue();
        return value - (value.intValue() / discount);
    }
}
