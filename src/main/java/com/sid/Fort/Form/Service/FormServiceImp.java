package com.sid.Fort.Form.Service;

import com.sid.Fort.Form.Dao.FormRepository;
import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class FormServiceImp implements IFormService {
    @Autowired
    FormRepository formRepository;
    @Autowired
    private MongoTemplate mongoTemplate;



    @Override
    public FormEntity addForm(FormEntity form) {
         Map<String, String> cols = new HashMap<String, String>();

        String clef = null;
        String valeur = null;
        FormEntity entity=new FormEntity();

        entity=form;
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.UK)
                        .withZone(ZoneId.systemDefault());


        for (String s : entity.getReponse().keySet()) {
            valeur = (String) form.getReponse().get(s);
            clef = s.replace("_", " ");
            cols.put(clef, valeur);
            System.out.println(clef);

        }
        cols.put("Date", formatter.format(Instant.now()));
        entity.setReponse(cols);
        mongoTemplate.insert(entity);
        return entity;
    }

    @Override
    public List<FormEntity> getUserInfoByTypeForm(String TypeForm) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm));

        List<FormEntity> Dto = mongoTemplate.find(query, FormEntity.class);

        return Dto;
    }

    @Override
    public Map<String, String> getAllInfoUserByTypeForm(String TypeForm, String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm).and("Reponse.email").is(email));
        query.with(Sort.by(Sort.Direction.ASC, "name"));
        Map<String, String> req = mongoTemplate.find(query, FormEntity.class).get(0).getReponse();

        try {
            Map<String, String> result = req.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            return result;
        } catch (NullPointerException e) {
            return req;

        }


    }

    @Override
    public int NbResponse(String typeForm) {
        return formRepository.countByTypeForm(typeForm);
    }

    @Override
    public List<DTODoughnutChart> getDataDoughnutChart(String TypeForm, String question) {

        List<DTODoughnutChart> list=new ArrayList<>();
        list.add(DtogetDataDoughnutChart(TypeForm,question.replace("{question}",""),"no"));
        list.add(DtogetDataDoughnutChart(TypeForm,question.replace("{question}",""),"yes"));
        list.add(DtogetDataDoughnutChart(TypeForm,question.replace("{question}",""),"Maybe"));
        return list;
    }

    @Override
    public List<String> getAllQuestionbyTypeForm(String TypeForm) {

        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm)).limit(1);
        List<FormEntity> req = mongoTemplate.find(query, FormEntity.class);
        List<String> listQuestion= new ArrayList<>() ;

        for (int i= 0; i<req.size();i++){

            for (Map.Entry<String, String> entry : req.get(i).getReponse().entrySet()) {
                String key = entry.getKey();
                listQuestion.add(key);


            }
        }
        return listQuestion ;
    }

    @Override
    public Map<String, String> getRankStaffChart(String TypeForm ) {
        Map<String, String> dataRankchart= new HashMap<>();
        dataRankchart.put("Ranging from 1 to 3",getRankStaffData(TypeForm,"Ranging from 1 to 3"));
        dataRankchart.put("Ranging from 3 to 5",getRankStaffData(TypeForm,"Ranging from 3 to 5"));
        dataRankchart.put("Ranging from 6 to 10",getRankStaffData(TypeForm,"Ranging from 6 to 10"));
        dataRankchart.put("More than 10",getRankStaffData(TypeForm,"More than 10"));
        dataRankchart.put("There is no staff compliance management",getRankStaffData(TypeForm,"There is no staff compliance management"));

//        for (Map.Entry<String, String> entry : dataRankchart.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        return dataRankchart;
    }
    private String getRankStaffData(String TypeForm,String question){
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm).and("Reponse.How many are the current compliance department staff").is(question));


        return String.valueOf(mongoTemplate.count(query, FormEntity.class));
    }

    @Override
    public Map<String, String> getTotalAnnualTurnoverChart(String TypeForm) {
        Map<String, String> dataRankchart= new HashMap<>();
        dataRankchart.put("Between 500 thousand QR and one million QR",getTotalAnnualTurnoverData(TypeForm,"Between 500 thousand QR and one million QR"));
        dataRankchart.put("Between QR 1 million and QR 5 million",getTotalAnnualTurnoverData(TypeForm,"Between QR 1 million and QR 5 million"));
        dataRankchart.put("Between QR 5 million and QR 10 million",getTotalAnnualTurnoverData(TypeForm,"Between QR 5 million and QR 10 million"));
        dataRankchart.put("Between QR 10 million and QR 50 million",getTotalAnnualTurnoverData(TypeForm,"Between QR 10 million and QR 50 million"));
        dataRankchart.put("More than 50 million QR",getTotalAnnualTurnoverData(TypeForm,"More than 50 million QR"));
//        for (Map.Entry<String, String> entry : dataRankchart.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        return dataRankchart;
    }
    private String getTotalAnnualTurnoverData(String TypeForm,String question){
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm).and("Reponse.Total annual turnover").is(question));


        return String.valueOf(mongoTemplate.count(query, FormEntity.class));
    }
    @Override
    public Map<String, String> getListProductsOffereChart(String TypeForm) {
        Map<String, String> dataRankchart= new HashMap<>();
        dataRankchart.put("Buying and selling of real estate",getListProductsOfferedData(TypeForm,"Buying and selling of real estate"));
        dataRankchart.put("Managing of client money, securities or other assets",getListProductsOfferedData(TypeForm,"Managing of client money, securities or other assets"));
        dataRankchart.put("Management of bank, savings or securities accounts",getListProductsOfferedData(TypeForm,"Management of bank, savings or securities accounts"));
        dataRankchart.put("Organisation of contributions for the creation, operation or management of companies",getListProductsOfferedData(TypeForm,"Organisation of contributions for the creation, operation or management of companies"));
        dataRankchart.put("Creating, operating or management of legal persons or arrangements, and buying and selling of business entities",getListProductsOfferedData(TypeForm,"Creating, operating or management of legal persons or arrangements, and buying and selling of business entities"));

        return dataRankchart;
    }
    public String getListProductsOfferedData(String TypeForm,String question){
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm).and("Reponse.Select from this list products offered to customers").is(question));

//        query.addCriteria(Criteria.where("typeForm").is("Accountants Assessment Of Products").and( "Reponse.Select from this list products offered to customers").is("Managing of client money, securities or other assets"));

        return String.valueOf(mongoTemplate.count(query, FormEntity.class));
    }

    private DTODoughnutChart DtogetDataDoughnutChart(String TypeForm,String question,String reponse) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeForm").is(TypeForm).and("Reponse."+question).is(reponse));
        int count= (int) mongoTemplate.count(query, FormEntity.class);

        DTODoughnutChart dtoDoughnutChart=new DTODoughnutChart();
         dtoDoughnutChart.setX(reponse);
         dtoDoughnutChart.setValue(count);
         dtoDoughnutChart.setQuestion(question);
         return dtoDoughnutChart;
    }

//    private List<FormEntity> DtoUserInfoForm(List<FormEntity> ListformEntities, String TypeForm) {
//
//        Map<String, String> DtoResponse = new HashMap<String, String>();
//        FormEntity formEntity = new FormEntity();
//        List<FormEntity> formEntitiesList = new ArrayList<FormEntity>();
//
//        switch (TypeForm) {
//            case "Accountants":
//            case "Notaries":
//
//                for (FormEntity entity : ListformEntities) {
//                    formEntity.setId(entity.getId());
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("name", entity.getReponse().get("name"));
//                        DtoResponse.put("Registration Nb", entity.getReponse().get("RegistrationNb"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("address", entity.getReponse().get("addres"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//
//                    formEntitiesList.add(formEntity);
////                    formEntitiesList=formEntitiesLis;
//
//                }
////                System.out.println(formEntitiesList.get(0).getId());
////                System.out.println(formEntitiesList.get(1).getId());
//                switch (TypeForm) {
//                    case "Accountants":
//                        formEntity.setTypeForm("Accountants");
//                        break;
//                    case "Notaries":
//                        formEntity.setTypeForm("Notaries");
//                        break;
//                }
//                break;
//            case "Banking Sector":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Financial Institution Name", entity.getReponse().get("Financial Institution Name"));
//                        DtoResponse.put("Full address of the institution", entity.getReponse().get("Full address of the institution"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("Place of registration", entity.getReponse().get("Place of registration"));
//                        DtoResponse.put("Legal Status", entity.getReponse().get("Legal Status"));
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Banking Sector");
//
//                break;
//            case "Insurance Sector":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Financial Institution Name", entity.getReponse().get("Financial Institution Name"));
//                        DtoResponse.put("Full address of the institution", entity.getReponse().get("Full address of the institution"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("Place of registration", entity.getReponse().get("Place of registration"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Insurance Sector");
//
//                break;
//            case "Lawyers":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("name", entity.getReponse().get("name"));
//                        DtoResponse.put("RegistrationNb", entity.getReponse().get("RegistrationNb"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("addres", entity.getReponse().get("addres"));
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Lawyers");
//
//                break;
//            case "Trust And Company":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("name", entity.getReponse().get("name"));
//                        DtoResponse.put("RegistrationNb", entity.getReponse().get("RegistrationNb"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("Full address of the institution", entity.getReponse().get("Full address of the institution"));
//                        DtoResponse.put("Legal form", entity.getReponse().get("Legal form"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Trust And Company");
//
//                break;
//            case "Accountants Assessment Of Products":
//            case "Trust and company service providers: Assessment of products":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Name of Accountant", entity.getReponse().get("Name of Accountant"));
//                        DtoResponse.put("Full address", entity.getReponse().get("Full address"));
//                        DtoResponse.put("Place of registration", entity.getReponse().get("Place of registration"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//
//                switch (TypeForm) {
//                    case "Accountants Assessment Of Products":
//                        formEntity.setTypeForm("Accountants Assessment Of Products");
//                        break;
//                    case "Trust and company service providers: Assessment of products":
//                        formEntity.setTypeForm("Trust and company service providers: Assessment of products");
//                        break;
//                }
//
//                break;
//            case "Banking Sector Assessment Of Products":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Financial Institution Name", entity.getReponse().get("Financial Institution Name"));
//                        DtoResponse.put("Full address", entity.getReponse().get("Full address"));
//                        DtoResponse.put("Place of registration", entity.getReponse().get("Place of registration"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Banking Sector Assessment Of Products");
//
//                break;
//            case "Notaries Assessment Of Products":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Name of Notarie", entity.getReponse().get("Name of Notarie"));
//                        DtoResponse.put("addres", entity.getReponse().get("addres"));
//                        DtoResponse.put("Place of registration", entity.getReponse().get("Place of registration"));
//                        DtoResponse.put("tel", entity.getReponse().get("tel"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Notaries Assessment of products");
//
//                break;
//            case "AML CFT Questionnaire":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Name of entity", entity.getReponse().get("Name of entity"));
//                        DtoResponse.put("Registration number", entity.getReponse().get("Registration number"));
//                        DtoResponse.put("Telephone number", entity.getReponse().get("Telephone_number"));
//                        DtoResponse.put("addres", entity.getReponse().get("addres"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Legal form", entity.getReponse().get("Legal form"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("AML/CFT Questionnaire");
//
//                break;
//            case "Sectoriel Risk Assessment Related To Lawyers":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Name of office", entity.getReponse().get("Name of office"));
//                        DtoResponse.put("Registration number", entity.getReponse().get("Registration number"));
//                        DtoResponse.put("Telephone number", entity.getReponse().get("tel"));
//                        DtoResponse.put("addres", entity.getReponse().get("addres"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Name of senior officer responsible for AML", entity.getReponse().get("Name of senior officer responsible for AML"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Sectoriel Risk Assessment Related To Lawyers");
//
//                break;
//            case "Sectoriel Risk Assessment Related To Real Estate Agents":
//
//                for (FormEntity entity : ListformEntities) {
//                    for (int i = 0; i < entity.getReponse().size(); i++) {
//                        formEntity.setId(entity.getId());
//
//                        DtoResponse.put("email", entity.getReponse().get("email"));
//                        DtoResponse.put("Name", entity.getReponse().get("Name of office"));
//                        DtoResponse.put("Registration number", entity.getReponse().get("Registration number"));
//                        DtoResponse.put("Telephone number", entity.getReponse().get("tel"));
//                        DtoResponse.put("addres", entity.getReponse().get("addres"));
//                        DtoResponse.put("website", entity.getReponse().get("website"));
//                        DtoResponse.put("date", entity.getReponse().get("Date"));
//
//                        DtoResponse.put("Legal form", entity.getReponse().get("Legal form"));
//                        formEntity.setReponse(DtoResponse);
//
//                    }
//                    formEntitiesList.add(formEntity);
//                }
//                formEntity.setTypeForm("Sectoriel Risk Assessment Related To Real Estate Agents");
//
//                break;
//        }
//
//        return formEntitiesList;
//    }
}
