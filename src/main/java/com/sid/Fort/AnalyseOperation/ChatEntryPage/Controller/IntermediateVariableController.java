package com.sid.Fort.AnalyseOperation.ChatEntryPage.Controller;

import com.sid.Fort.AnalyseOperation.ChatEntryPage.Entity.ChartEntryPage;
import com.sid.Fort.AnalyseOperation.ChatEntryPage.Service.ChartEntryPageService;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntermediateVariableController {


    @Autowired
    private ChartEntryPageService chartEntryPageService;

    @GetMapping("ChartEntryPage/Opiration/{id_Operation}/Question/{OrderQuestion}")
    public List<ChartEntryPage> getIntermediateVariable(@PathVariable Long id_Operation,@PathVariable int OrderQuestion) {

        return chartEntryPageService.getIntermediateVariable(id_Operation, OrderQuestion);
    }
    @GetMapping("ChartEntryPage/Scenarios/{id_Scenario}/Question/{OrderQuestion}")
    public Double getValeusIntermediateVariable(@PathVariable Integer OrderQuestion,@PathVariable Scenarios id_Scenario) {
        return chartEntryPageService.getValeusIntermediateVariable(OrderQuestion, id_Scenario);
    }
}
