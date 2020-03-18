package com.sid.Fort.Scenarios.Service;

import com.sid.Fort.Scenarios.Dao.Scenarios;

import java.util.List;

public interface IScenariosService {

    public Scenarios getScenariosById(Long id);
    public List<Scenarios> getScenariosById_Opiration(Long id);
    public List<Scenarios> getAllScenarios();
    public Scenarios AddScenarios(Scenarios scenarios);

    Scenarios AddScenarios(Scenarios scenarios, Long id_opiration);

    public Scenarios UpdateScenarios(Scenarios scenarios, Long id);
    public void DeleteScenarios(Long id);
}
