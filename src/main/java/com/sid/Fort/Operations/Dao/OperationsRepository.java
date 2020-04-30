package com.sid.Fort.Operations.Dao;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.Operations.Entity.Operations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperationsRepository extends JpaRepository<Operations,Long> {
    @Query("SELECT op.designation FROM Operations as op where id=?1")
    public String getDesignationOpirationById(Long id_Opiration);

    @Query("SELECT op.dnfbpsSectors.designation FROM Operations as op where id=?1")
    String getSectorsByOpirationId(Long id_Opiration);


}
