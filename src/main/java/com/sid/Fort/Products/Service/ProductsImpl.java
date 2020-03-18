package com.sid.Fort.Products.Service;

import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectorsRepository;
import com.sid.Fort.Products.Dao.Products;
import com.sid.Fort.Products.Dao.ProductsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductsImpl implements IProducts {
    @Autowired
    private ProductsRepository productsRepository;
      @Autowired
    private DnfbpsSectorsRepository sectorsRepository;

    @Override
    public Products getProductsById(Long id) {
        try {
            return productsRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<Products> getProductsBySIdSectors(Long id_Sectors) {
        try {
            return productsRepository.findProductsByDnfbpsSectorsId(id_Sectors);
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id_Sectors));
        }
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products AddProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products AddProducts(Products Products, Long id_Sectors) {
        return sectorsRepository.findById(id_Sectors)
                .map(response -> {
                    Products.setDnfbpsSectors(response);
                    return productsRepository.save(Products);
                }).orElseThrow(() -> new RuntimeException("operation id=" + id_Sectors + "n'existe pas"));
    }

    @Override
    public Products UpdateProducts(Products products, Long id) {
        products.setId(id);
        return productsRepository.save(products);
    }

    @Override
    public void DeleteProducts(Long id) {
        productsRepository.deleteById(id);
    }
}
