package com.apu.mongodemo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final SearchService searchService;

    @PostMapping    
    public ResponseEntity<String> save(@RequestBody Product p){
        return ResponseEntity.ok(service.save(p));
    }

    @GetMapping
    public ResponseEntity<List<Product>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")  
    public ResponseEntity<Product>findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/searchbyname")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(searchService.searchByName(name));
    }

    @GetMapping("/searchbynamestartswith")
    public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam String name) {
        return ResponseEntity.ok(searchService.searchByNameStartsWith(name));
    }
    
    @GetMapping("/searchbypricelt")
    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam BigDecimal price) {
        return ResponseEntity.ok(searchService.searchByPriceLt(price));
    }

    @GetMapping("/searchsortby")
    public ResponseEntity<List<Product>> searchSorted(@RequestParam String fd) {
        return ResponseEntity.ok(searchService.searchSortBy(fd));
    }

    @GetMapping("/searchpage")
    public ResponseEntity<List<Product>> searchPage(@RequestParam int page, @RequestParam int nr) {
        return ResponseEntity.ok(searchService.searchPage(page, nr));
    }

}
