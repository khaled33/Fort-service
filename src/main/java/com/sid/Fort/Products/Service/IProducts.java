package com.sid.Fort.Products.Service;


import com.sid.Fort.Products.Entity.Products;

import java.util.List;

public interface IProducts  {
    public Products getProductsById(Long id);
    public List<Products> getProductsBySIdSectors(Long id_Sectors);
    public List<Products> getAllProducts();
    public Products AddProducts(Products Products);
    public Products AddProducts(Products Products,Long id_Sectors);
    public Products UpdateProducts(Products Products,Long id);
    public void DeleteProducts(Long id,Long id_operation,Long id_Scenario);
    public void DeleteProducts(Long id);
}
