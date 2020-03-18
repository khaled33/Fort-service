package com.sid.Fort.Scenarios.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScenariosRepository extends JpaRepository<Scenarios,Long> {
    public List<Scenarios> findScenariosByOperationsId(Long id_opiration);
}
