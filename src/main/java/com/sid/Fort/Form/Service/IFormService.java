package com.sid.Fort.Form.Service;

import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import org.aspectj.apache.bcel.generic.FieldOrMethod;

import java.util.List;
import java.util.Map;

public interface IFormService {

    FormEntity addForm(FormEntity form);
    List<FormEntity> getUserInfoByTypeForm(String TypeForm,String id_UserAdmin);
    Map<String, String>  getAllInfoUserByTypeForm(String TypeForm,String email,String id_UserAdmin);
    int NbResponse (String typeForm,String id_UserAdmin);
    List<DTODoughnutChart> getDataDoughnutChart(String TypeForm,String question,String id_UserAdmin);
    List<String> getAllQuestionbyTypeForm(String TypeForm,String id_UserAdmin);
    Map<String,String> getRankStaffChart(String TypeForm,String id_UserAdmin);

    Map<String, String> getTotalAnnualTurnoverChart(String TypeForm,String id_UserAdmin);

    Map<String, String> getListProductsOffereChart(String TypeForm,String id_UserAdmin);
}
