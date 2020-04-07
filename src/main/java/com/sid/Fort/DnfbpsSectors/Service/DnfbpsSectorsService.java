package com.sid.Fort.DnfbpsSectors.Service;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;

import java.util.List;

public interface DnfbpsSectorsService {
    public DnfbpsSectors getDnfbpsSectorsById(Long id);
    public List<DnfbpsSectors> getAllDnfbpsSectors();
    public DnfbpsSectors UpdateDnfbpsSectors(DnfbpsSectors dnfbpssectors,Long id);
    public void DeleteDnfbpsSectors(Long id);
    public DnfbpsSectors AddDnfbpsSectors(DnfbpsSectors dnfbpssectors);
}
