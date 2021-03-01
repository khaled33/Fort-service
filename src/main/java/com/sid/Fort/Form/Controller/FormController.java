package com.sid.Fort.Form.Controller;

import com.sid.Fort.Form.Dao.FormRepository;
import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import com.sid.Fort.Form.Service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormController {

    @Autowired
    IFormService formServiceImp;

    @PostMapping("/Form")
    public FormEntity addForm(@RequestBody FormEntity form) {
        System.out.println(form.toString());
        return formServiceImp.addForm(form);
    }

    @GetMapping("/Form/{TypeForm}/{id_user}")
    public List<FormEntity> getUserInfoByTypeForm(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.getUserInfoByTypeForm(TypeForm,id_user);
    }

    @GetMapping("/Form/{TypeForm}/{email}/{id_user}")
    public Map<String, String> getAllInfoUserByTypeForm(@PathVariable String TypeForm, @PathVariable String email,@PathVariable String id_user) {
        return formServiceImp.getAllInfoUserByTypeForm(TypeForm, email,id_user);
    }

    @GetMapping("/Form/NbResponse/{TypeForm}/{id_user}")
    public int NbResponse(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.NbResponse(TypeForm,id_user);
    }

    @GetMapping("/Form/TypeForm/{TypeForm}/question/{question}/{id_user}")
    public List<DTODoughnutChart> getDataDoughnutChart(@PathVariable String TypeForm, @PathVariable String question,@PathVariable String id_user) {
        return formServiceImp.getDataDoughnutChart(TypeForm, question,id_user);
    }

    @GetMapping("/Form/ListQestion/TypeForm/{TypeForm}/{id_user}")
    public List<String> getAllQuestionbyTypeForm(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.getAllQuestionbyTypeForm(TypeForm,id_user);
    }

    @GetMapping("/Form/RankStaffChart/TypeForm/{TypeForm}/{id_user}")
    public Map<String, String> getRankStaffChart(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.getRankStaffChart(TypeForm,id_user);
    }

    @GetMapping("/Form/TotalAnnualTurnoverChart/TypeForm/{TypeForm}/{id_user}")
    public Map<String, String> getTotalAnnualTurnoverChart(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.getTotalAnnualTurnoverChart(TypeForm,id_user);
    }
    @GetMapping("/Form/ListProductsOffere/TypeForm/{TypeForm}/{id_user}")
    public Map<String, String> getListProductsOffereChart(@PathVariable String TypeForm,@PathVariable String id_user) {
        return formServiceImp.getListProductsOffereChart(TypeForm,id_user);
    }
}
