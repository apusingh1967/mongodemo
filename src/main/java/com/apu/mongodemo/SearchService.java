package com.apu.mongodemo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class SearchService {

    private final MongoTemplate template;

    public List<Product>searchByName(String name){
        Query q = new Query();
        q.addCriteria(Criteria.where("name").is(name));
        return template.find(q, Product.class);
    }

    public List<Product>searchByNameStartsWith(String name){
        Query q = new Query();
        q.addCriteria(Criteria.where("name").regex("^" + name));
        return template.find(q, Product.class);
    }

    public List<Product>searchByPriceLt(BigDecimal price){
        Query q = new Query();
        q.addCriteria(Criteria.where("price").lt(price));
        return template.find(q, Product.class);
    }

    public List<Product>searchSortBy(String fd){
        Query q = new Query();
        q.with(Sort.by(Direction.ASC, fd));
        return template.find(q, Product.class);
    }

    public List<Product>searchPage(int page, int nr){
        Query q = new Query();
        var p = PageRequest.of(page, nr);
        q.with(p);
        return template.find(q, Product.class);
    }

}
