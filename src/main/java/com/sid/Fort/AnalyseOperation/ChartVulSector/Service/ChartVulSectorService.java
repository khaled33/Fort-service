package com.sid.Fort.AnalyseOperation.ChartVulSector.Service;

import com.sid.Fort.AnalyseOperation.ChartVulSector.Entity.ChartVulSector;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao.ChatVulProductRepository;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Entity.ChatVulProduct;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartVulSectorService {
    @Autowired
    private ScenariosRepository scenariosRepository;
    @Autowired
    private ChatVulProductRepository chatVulProductRepository;

    public List<ChartVulSector> getOpenDoorchart(Long id_Operation) {
        List<Scenarios> scenarios = scenariosRepository.findScenariosByOperationsId(id_Operation);
        List<ChartVulSector> chartVulSectorsList = new ArrayList<>();
        if (scenarios.size() != 0) {
            for (Scenarios scenario : scenarios) {
                double Rest;
                double Largest_Product_Vulnerability = 0;

                List<ChatVulProduct> chatVulProducts = chatVulProductRepository.getByOperationAndProductsIdOrder(id_Operation, scenario.getId());
                ChartVulSector chartVulSector = new ChartVulSector();

                if (chatVulProducts != null) {
                    if (chatVulProducts.size() != 0) {
                        for (ChatVulProduct chatVulProduct : chatVulProducts) {
                            Rest = (int) Math.ceil(chatVulProducts.size() / 5) + 1;

                            if (Rest < 2) {
                                Largest_Product_Vulnerability = chatVulProduct.getVulnerabiliteFinale();
                            } else if (Rest == 2) {
                                Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale()) / 2;
                            } else if (Rest == 3) {
                                Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale() + chatVulProducts.get(2).getVulnerabiliteFinale()) / 3;
                            } else if (Rest == 4) {
                                Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale() + chatVulProducts.get(2).getVulnerabiliteFinale() + chatVulProducts.get(3).getVulnerabiliteFinale()) / 4;
                            }
                        }

                        chartVulSector.setTxSec(scenario.getDesignation());
                        chartVulSector.setVal(Largest_Product_Vulnerability);

                    } else {
                        chartVulSector.setTxSec(scenario.getDesignation());
                        chartVulSector.setVal(0D);

                    }

                    chartVulSectorsList.add(chartVulSector);
                }

            }
            return chartVulSectorsList;
        }
        return null;
    }

    public Double getOneByScenariosOpenDoorchart(Long id_Scenarios, Long id_Operation) {
        Scenarios scenarios = scenariosRepository.getOne(id_Scenarios);
        double Rest;
        double Largest_Product_Vulnerability = 0;

        List<ChatVulProduct> chatVulProducts = chatVulProductRepository.getByOperationAndProductsIdOrder(id_Operation, scenarios.getId());

        if (chatVulProducts != null) {
            if (chatVulProducts.size() != 0) {
                for (ChatVulProduct chatVulProduct : chatVulProducts) {
                    Rest = (int) Math.ceil(chatVulProducts.size() / 5) + 1;

                    if (Rest < 2) {
                        Largest_Product_Vulnerability = chatVulProduct.getVulnerabiliteFinale();
                    } else if (Rest == 2) {
                        Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale()) / 2;
                    } else if (Rest == 3) {
                        Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale() + chatVulProducts.get(2).getVulnerabiliteFinale()) / 3;
                    } else if (Rest == 4) {
                        Largest_Product_Vulnerability = (chatVulProducts.get(0).getVulnerabiliteFinale() + chatVulProducts.get(1).getVulnerabiliteFinale() + chatVulProducts.get(2).getVulnerabiliteFinale() + chatVulProducts.get(3).getVulnerabiliteFinale()) / 4;
                    }
                }


            }

        }

        if (Largest_Product_Vulnerability != 0)
            return Largest_Product_Vulnerability;
        else
            return null;


    }
}
