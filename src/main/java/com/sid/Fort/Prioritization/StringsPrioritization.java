package com.sid.Fort.Prioritization;

import com.sid.Fort.Prioritization.Entity.Case;

import java.util.ArrayList;
import java.util.List;

public interface StringsPrioritization {


    static final String Comprehensiveness_of_AML_Legal_Framework = "Comprehensiveness of AML Legal Framework";
    static final String Availability_and_Enforcement_of_Criminal_Sanctions = "Availability and Enforcement of Criminal Sanctions";
    static final String Level_of_Market_Pressure_to_Meet_AML_Standards = "Level of Market Pressure to Meet AML Standards";
    static final String Availability_and_Effectiveness_of_Entry_Controls = "Availability and Effectiveness of Entry Controls";
    static final String Effectiveness_of_Supervision_Oversight_Activities = "Effectiveness of Supervision/Oversight Activities";
    static final String Availability_and_Enforcement_of_Administrative_Sanctions = "Availability and Enforcement of Administrative Sanctions";
    static final String Integrity_of_Banks_Staff = "Integrity of Banks’ Staff";
    static final String AML_Knowledge_of_Banks_Staff = "AML Knowledge of Banks’ Staff";
    static final String Effectiveness_of_Compliance_Systems = "Effectiveness of Compliance Systems";
    static final String Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting = "Effectiveness of Suspicious Activity Monitoring and Reporting";
    static final String Availability_and_Access_to_Beneficial_Ownership_information = "Availability and Access to Beneficial Ownership information";
    static final String Availability_of_Reliable_Identification_Infrastructure = "Availability of Reliable Identification Infrastructure";
    static final String Availability_of_Independent_Information_Sources = "Availability of Independent Information Sources";

    static final Double bestcase=0.7;
    static final Double Weights=99.00;

    static List<String> getQeustion(){
        List<String> qs=new ArrayList<>();
        qs.add(Comprehensiveness_of_AML_Legal_Framework);
        qs.add(Availability_and_Enforcement_of_Criminal_Sanctions);
        qs.add(Level_of_Market_Pressure_to_Meet_AML_Standards);
        qs.add(Availability_and_Effectiveness_of_Entry_Controls);
        qs.add(Effectiveness_of_Supervision_Oversight_Activities);
        qs.add(Availability_and_Enforcement_of_Administrative_Sanctions);
        qs.add(Integrity_of_Banks_Staff);
        qs.add(AML_Knowledge_of_Banks_Staff);
        qs.add(Effectiveness_of_Compliance_Systems);
        qs.add(Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting);
        qs.add(Availability_and_Access_to_Beneficial_Ownership_information);
        qs.add(Availability_of_Reliable_Identification_Infrastructure);
        qs.add(Availability_of_Independent_Information_Sources);
        return qs;
    }
    static List<String> getQeustion1(){
        List<String> qs=new ArrayList<>();
        qs.add(Comprehensiveness_of_AML_Legal_Framework);
        qs.add(Effectiveness_of_Supervision_Oversight_Activities);
        qs.add(Availability_and_Enforcement_of_Administrative_Sanctions);
        qs.add(Availability_and_Enforcement_of_Criminal_Sanctions);
        qs.add(Availability_and_Effectiveness_of_Entry_Controls);
        qs.add(Integrity_of_Banks_Staff);
        qs.add(AML_Knowledge_of_Banks_Staff);
        qs.add(Effectiveness_of_Compliance_Systems);
        qs.add(Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting);
        qs.add(Availability_and_Access_to_Beneficial_Ownership_information);
        qs.add(Availability_of_Reliable_Identification_Infrastructure);
        qs.add(Availability_of_Independent_Information_Sources);
        return qs;
    }
    static List<String> getQeustion2(){
        List<String> qs=new ArrayList<>();
        qs.add(Comprehensiveness_of_AML_Legal_Framework);
        qs.add(Availability_and_Enforcement_of_Criminal_Sanctions);
        qs.add(Availability_and_Effectiveness_of_Entry_Controls);
        qs.add(Effectiveness_of_Supervision_Oversight_Activities);
        qs.add(Availability_and_Enforcement_of_Administrative_Sanctions);
        qs.add(Integrity_of_Banks_Staff);
        qs.add(AML_Knowledge_of_Banks_Staff);
        qs.add(Effectiveness_of_Compliance_Systems);
        qs.add(Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting);
        qs.add(Availability_and_Access_to_Beneficial_Ownership_information);
        qs.add(Availability_of_Reliable_Identification_Infrastructure);
        qs.add(Availability_of_Independent_Information_Sources);
        return qs;
    }


}
