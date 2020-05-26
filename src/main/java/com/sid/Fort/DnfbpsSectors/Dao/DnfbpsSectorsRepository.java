package com.sid.Fort.DnfbpsSectors.Dao;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DnfbpsSectorsRepository extends JpaRepository<DnfbpsSectors,Long> {
    List<DnfbpsSectors> findAllByOrderByDesignationAsc();
}
