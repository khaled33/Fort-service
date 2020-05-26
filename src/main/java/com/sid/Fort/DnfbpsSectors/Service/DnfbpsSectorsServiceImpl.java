package com.sid.Fort.DnfbpsSectors.Service;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectorsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class DnfbpsSectorsServiceImpl implements DnfbpsSectorsService {

    @Autowired
    private DnfbpsSectorsRepository dnfbpsSectorsRepository;
    @Override
    public DnfbpsSectors getDnfbpsSectorsById(Long id) {
        try {
            return dnfbpsSectorsRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<DnfbpsSectors> getAllDnfbpsSectors() {
        return dnfbpsSectorsRepository.findAllByOrderByDesignationAsc();
    }

    @Override
    public DnfbpsSectors UpdateDnfbpsSectors(DnfbpsSectors dnfbpssectors, Long id) {
        dnfbpssectors.setId(id);
        return dnfbpsSectorsRepository.save(dnfbpssectors);
    }

    @Override
    public void DeleteDnfbpsSectors(Long id) {
        dnfbpsSectorsRepository.deleteById(id);
    }

    @Override
    public DnfbpsSectors AddDnfbpsSectors(DnfbpsSectors dnfbpssectors) {
        return dnfbpsSectorsRepository.save(dnfbpssectors);
    }
}
