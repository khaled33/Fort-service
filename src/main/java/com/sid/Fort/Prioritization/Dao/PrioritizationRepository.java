package com.sid.Fort.Prioritization.Dao;

import com.sid.Fort.Prioritization.Entity.PrioritizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrioritizationRepository extends JpaRepository<PrioritizationEntity,Long> {
    List<PrioritizationEntity> getAllByScenariosId(Long ScenariosId);

    void deleteAllByScenariosId(Long id_scenarios);
}
