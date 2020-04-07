package com.sid.Fort.Products.Dao;

import com.sid.Fort.Products.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    public List<Products> findProductsByDnfbpsSectorsId(Long SectorsId );
}
