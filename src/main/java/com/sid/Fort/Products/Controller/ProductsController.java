package com.sid.Fort.Products.Controller;

import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.Products.Service.IProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private IProducts iProducts;

    @GetMapping("/Product/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable Long id) {
        Products rest = iProducts.getProductsById(id);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @GetMapping("/Products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> rest = iProducts.getAllProducts();
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @PostMapping("/Product/Sector/{id_Sectors}")
    public ResponseEntity<Products> AddProducts(@RequestBody Products Products, @PathVariable Long id_Sectors) {
        return new ResponseEntity<>(iProducts.AddProducts(Products, id_Sectors), HttpStatus.CREATED);
    }

    @GetMapping("/Products/Sectors/{id_Sectors}")
    public ResponseEntity<List<Products>> getProductsBySIdSectors(@PathVariable Long id_Sectors) {
        List<Products> rest = iProducts.getProductsBySIdSectors(id_Sectors);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @PostMapping("/Product")
    public ResponseEntity<Products> AddProducts(@RequestBody Products Products) {
        Products rest = iProducts.AddProducts(Products);
        return new ResponseEntity<>(rest, HttpStatus.CREATED);
    }

    @PutMapping("/Product/{id}")
    public ResponseEntity<Products> UpdateProducts(@RequestBody Products Products, @PathVariable Long id) {
        Products rest = iProducts.UpdateProducts(Products, id);
        return new ResponseEntity<>(rest, HttpStatus.CREATED);
    }

    @DeleteMapping("/Product/{id}")
    public ResponseEntity<Void> DeleteProducts(@PathVariable Long id) {
        iProducts.DeleteProducts(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
