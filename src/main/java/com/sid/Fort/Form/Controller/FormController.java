package com.sid.Fort.Form.Controller;

import com.sid.Fort.Form.Dao.FormRepository;
import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import com.sid.Fort.Form.Service.FormServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormController {
    @Autowired
    FormServiceImp formServiceImp;

    @PostMapping("/Form")
    public FormEntity addForm(@RequestBody FormEntity form) {
        return formServiceImp.addForm(form);
    }

    @GetMapping("/Form/{TypeForm}")
    public List<FormEntity> getUserInfoByTypeForm(@PathVariable String TypeForm) {
        return formServiceImp.getUserInfoByTypeForm(TypeForm);
    }

    @GetMapping("/Form/{TypeForm}/{email}")
    public Map<String, String> getAllInfoUserByTypeForm(@PathVariable String TypeForm, @PathVariable String email) {
        return formServiceImp.getAllInfoUserByTypeForm(TypeForm, email);
    }

    @GetMapping("/Form/NbResponse/{TypeForm}")
    public int NbResponse(@PathVariable String TypeForm) {
        return formServiceImp.NbResponse(TypeForm);
    }

    @GetMapping("/Form/TypeForm/{TypeForm}/question/{question}")
    public List<DTODoughnutChart> getDataDoughnutChart(@PathVariable String TypeForm, @PathVariable String question) {
        return formServiceImp.getDataDoughnutChart(TypeForm, question);
    }

    @GetMapping("/Form/ListQestion/TypeForm/{TypeForm}")
    public List<String> getAllQuestionbyTypeForm(@PathVariable String TypeForm) {
        return formServiceImp.getAllQuestionbyTypeForm(TypeForm);
    }

    @GetMapping("/Form/RankStaffChart/TypeForm/{TypeForm}")
    public Map<String, String> getRankStaffChart(@PathVariable String TypeForm) {
        return formServiceImp.getRankStaffChart(TypeForm);
    }

    @GetMapping("/Form/TotalAnnualTurnoverChart/TypeForm/{TypeForm}")
    public Map<String, String> getTotalAnnualTurnoverChart(@PathVariable String TypeForm) {
        return formServiceImp.getTotalAnnualTurnoverChart(TypeForm);
    }
    @GetMapping("/Form/ListProductsOffere/TypeForm/{TypeForm}")
    public Map<String, String> getListProductsOffereChart(@PathVariable String TypeForm) {
        return formServiceImp.getListProductsOffereChart(TypeForm);
    }
}
