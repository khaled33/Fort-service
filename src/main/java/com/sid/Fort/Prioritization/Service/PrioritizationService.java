package com.sid.Fort.Prioritization.Service;

import com.sid.Fort.Prioritization.Entity.Case;
import com.sid.Fort.Prioritization.Entity.PrioritizationEntity;

import java.util.List;

public interface PrioritizationService {
   List<PrioritizationEntity> PrioritizationCalcule(Long id_Scenarios);
   List<PrioritizationEntity> PrioritizationCalcule1(Long id_Scenarios);
}
