package com.sid.Fort.DnfbpsSectorsDetails.Service;



import com.sid.Fort.DnfbpsSectorsDetails.Dao.DnfbpsSectorsDetails;

import java.util.List;

public interface IDnfbpsSectorsDetails {
    public DnfbpsSectorsDetails getDnfbpsSectorsDetailsById(Long id);
    public List<DnfbpsSectorsDetails> getAllDnfbpsSectorsDetailss();

    DnfbpsSectorsDetails AddDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id_operation);

    public DnfbpsSectorsDetails UpdateDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id);

    DnfbpsSectorsDetails UpdateDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id, Long id_operation);

    public void DeleteDnfbpsSectorsDetails(Long id);
    public DnfbpsSectorsDetails AddDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails);
}
