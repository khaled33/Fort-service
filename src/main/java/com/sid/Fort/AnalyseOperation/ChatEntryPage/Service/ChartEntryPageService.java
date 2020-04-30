package com.sid.Fort.AnalyseOperation.ChatEntryPage.Service;

import com.sid.Fort.AnalyseOperation.ChatEntryPage.Entity.ChartEntryPage;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartEntryPageService {
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;
    @Autowired
    private ScenariosRepository scenariosRepository;

    public List<ChartEntryPage> getIntermediateVariable(Long id_Operation, int OrderQuestion) {

        List<ChartEntryPage> entryPageList = new ArrayList<>();
        List<Scenarios> scenarios = scenariosRepository.findScenariosByOperationsId(id_Operation);

        if (scenarios.size() != 0) {
            for (Scenarios scenario : scenarios) {
                ChartEntryPage chartEntryPage = new ChartEntryPage();
                Double questionsResponsesScenariosRepositoryINTERMEDIATE_variable_type;
                questionsResponsesScenariosRepositoryINTERMEDIATE_variable_type = questionsResponsesScenariosRepository.getINTERMEDIATE_VARIABLE_TYPE(OrderQuestion, scenariosRepository.getOne(scenario.getId()));
                if (questionsResponsesScenariosRepositoryINTERMEDIATE_variable_type != null) {
                    chartEntryPage.setTextSenario(scenario.getDesignation());
                    chartEntryPage.setValeur(questionsResponsesScenariosRepositoryINTERMEDIATE_variable_type);

                    entryPageList.add(chartEntryPage);
                }
            }

            return entryPageList;
        }
        return null;
    }

    public Double getValeusIntermediateVariable(Integer Order, Scenarios id_Scenario) {

        Double valeusQrps = questionsResponsesScenariosRepository.getINTERMEDIATE_VARIABLE_TYPE(Order, id_Scenario);
        if (valeusQrps != null) {
            return valeusQrps;
        }
        return null;
    }
}
