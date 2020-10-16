package com.sid.Fort.Form.Service;

import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import org.aspectj.apache.bcel.generic.FieldOrMethod;

import java.util.List;
import java.util.Map;

public interface IFormService {

    FormEntity addForm(FormEntity form);
    List<FormEntity> getUserInfoByTypeForm(String TypeForm);
    Map<String, String>  getAllInfoUserByTypeForm(String TypeForm,String email);
    int NbResponse (String typeForm);
    List<DTODoughnutChart> getDataDoughnutChart(String TypeForm,String question);
    List<String> getAllQuestionbyTypeForm(String TypeForm);
    Map<String,String> getRankStaffChart(String TypeForm);

    Map<String, String> getTotalAnnualTurnoverChart(String TypeForm);

    Map<String, String> getListProductsOffereChart(String TypeForm);
}
