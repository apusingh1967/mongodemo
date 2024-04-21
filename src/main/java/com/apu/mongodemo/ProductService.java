package com.apu.mongodemo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor public class ProductService {

    private final ProductRepository repository;

    public String save(Product p){
        return repository.save(p).getId();
    }

    public Product findById(String id){
        return repository.findById(id).orElse(null);
    }

    public List<Product>findAll(){
        return repository.findAll();
    }

    public void delete(String id){
        repository.deleteById(id);
    }

}
