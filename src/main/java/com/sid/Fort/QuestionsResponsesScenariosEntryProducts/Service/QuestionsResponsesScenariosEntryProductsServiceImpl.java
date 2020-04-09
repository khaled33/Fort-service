package com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Service;

import com.sid.Fort.Products.Dao.ProductsRepository;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Dao.QuestionsResponsesScenariosEntryProductsRepository;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity.QuestionsResponsesScenariosEntryProducts;
import com.sid.Fort.Responses.Dao.ResponsesRepository;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsResponsesScenariosEntryProductsServiceImpl implements QuestionsResponsesScenariosEntryProductsService {
    @Autowired
    private QuestionsResponsesScenariosEntryProductsRepository questionsResponsesScenariosEntryProductsRepository;
    @Autowired
    ScenariosRepository scenariosRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    private ResponsesRepository responsesRepository;


    @Override
    public QuestionsResponsesScenariosEntryProducts getQuestionsResponsesScenariosEntryProductsById(Long id) {
        return questionsResponsesScenariosEntryProductsRepository.getOne(id);
    }

    @Override
    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProducts() {
        return questionsResponsesScenariosEntryProductsRepository.findAll();
    }

    @Override
    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProductsByIdScenarios(Long id_Scenarios) {
        return questionsResponsesScenariosEntryProductsRepository.findAllQuestionsResponsesScenariosEntryProductsByScenariosId(id_Scenarios);
    }

    @Override
    public QuestionsResponsesScenariosEntryProducts AddQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts,
                                                                                                Long scenario_id, Long product_id) {

        QuestionsResponsesScenariosEntryProducts.setId(1L);
        Scenarios scenarios = scenariosRepository.getOne(scenario_id);
        Products products = productsRepository.getOne(product_id);

        Long id_Question = QuestionsResponsesScenariosEntryProducts.getQuestionsEntryProducts().getId();

        QuestionsResponsesScenariosEntryProducts.setScenarios(scenarios);
        QuestionsResponsesScenariosEntryProducts.setProducts(products);
        QuestionsResponsesScenariosEntryProducts OldquestionsResponsesScenarios = questionsResponsesScenariosEntryProductsRepository.findByQuestionsEntryProductsIdAndScenariosIdAndProductsId(id_Question, scenario_id, product_id);
        if (QuestionsResponsesScenariosEntryProducts.getResponses_sel() != null && QuestionsResponsesScenariosEntryProducts.getResponses_sel() != -1) {
            Responses responses = responsesRepository.getOne(QuestionsResponsesScenariosEntryProducts.getResponses_sel());

            QuestionsResponsesScenariosEntryProducts.setValue(responses.getValue());
            QuestionsResponsesScenariosEntryProducts.setResponses(responses);
        } else {
            QuestionsResponsesScenariosEntryProducts.setValue(0d);
            QuestionsResponsesScenariosEntryProducts.setResponses(null);
        }


        if (OldquestionsResponsesScenarios != null) {
            QuestionsResponsesScenariosEntryProducts.setId(OldquestionsResponsesScenarios.getId());
        }
        QuestionsResponsesScenariosEntryProducts.setCorrespondingScore(CorrespondingScore(QuestionsResponsesScenariosEntryProducts));


        return questionsResponsesScenariosEntryProductsRepository.save(QuestionsResponsesScenariosEntryProducts);

    }

    @Override
    public QuestionsResponsesScenariosEntryProducts UpdateQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts, Long id) {
        return null;
    }

    @Override
    public void DeleteQuestionsResponsesScenariosEntryProducts(Long id) {

    }

    public double CorrespondingScore(QuestionsResponsesScenariosEntryProducts Qrs) {


        double CorrespondingScore = 0;
        String textQeustion = Qrs.getQuestionsEntryProducts().getText();

      //  if (textQeustion.equals("Total Value") || textQeustion.equals("Average Transaction Size") || textQeustion.equals("Level of Cash Activity") || textQeustion.equals("Frequency of International Transactions") || textQeustion.equals("Client Base Profile")|| textQeustion.equals("Existence of Investment/Deposit Feature")) {
            if (Qrs.getValue() == 2)
                CorrespondingScore = 1;
            else if (Qrs.getValue() == 3) {
                if ( textQeustion.equals("Existence of Investment/Deposit Feature")|| textQeustion.equals("Other Vulnerable Factors - Non face to face use of the product/service"))
                CorrespondingScore = 0.75;
                else
                CorrespondingScore = 0.8;
            } else if (Qrs.getValue() == 4)
                if (textQeustion.equals("Existence of Investment/Deposit Feature")|| textQeustion.equals("Other Vulnerable Factors - Non face to face use of the product/service"))
                    CorrespondingScore = 0.25;
                else if (textQeustion.equals("Other Vulnerable Factors - Difficulty in tracing the transaction records of the product/service") || textQeustion.equals("Availability of Additional  Specific AML Controls "))
                    CorrespondingScore = 0;
                else
                CorrespondingScore = 0.5;
            else if (Qrs.getValue() == 5 )
                if (textQeustion.equals("Existence of Investment/Deposit Feature")||textQeustion.equals("Other Vulnerable Factors - Existence of ML typologies on the abuse of the product/service")||textQeustion.equals("Other Vulnerable Factors - Use of the product/service in  fraud or tax evasion schemes")|| textQeustion.equals("Other Vulnerable Factors - Non face to face use of the product/service"))
                CorrespondingScore = 0;

                else CorrespondingScore = 0.2;
            else if (Qrs.getValue() == 6)
                CorrespondingScore = 0.01;
            else if (Qrs.getValue() == 7 && textQeustion.equals("Level of Cash Activity") || textQeustion.equals("Frequency of International Transactions"))
                CorrespondingScore = 0.01;
            else CorrespondingScore = 1;

            if (Qrs.getValue() == 8)
                if (textQeustion.equals("Level of Cash Activity") || textQeustion.equals("Frequency of International Transactions"))
                    CorrespondingScore = 1;
                else
                CorrespondingScore = 0;

        //}

         if (Qrs.getValue() == 3 && textQeustion.equals("Other Vulnerable Factors -Anonymous/Omnibus use of the product/service"))
            CorrespondingScore = 0;

         if (Qrs.getValue() == 3 &&  textQeustion.equals("Availability of Additional  Specific AML Controls "))
            CorrespondingScore = 0.2;

         if (Qrs.getValue() == 4 && textQeustion.equals("Existence of Investment/Deposit Feature"))
            CorrespondingScore = 0.25;
        return CorrespondingScore;
    }

}
