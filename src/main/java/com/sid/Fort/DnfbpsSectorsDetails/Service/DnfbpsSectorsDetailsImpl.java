package com.sid.Fort.DnfbpsSectorsDetails.Service;

import com.sid.Fort.DnfbpsSectorsDetails.Entity.DnfbpsSectorsDetails;
import com.sid.Fort.DnfbpsSectorsDetails.Dao.DnfbpsSectorsDetailsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Qualifier("Impl1")
public class DnfbpsSectorsDetailsImpl implements IDnfbpsSectorsDetails {

    @Autowired
    private DnfbpsSectorsDetailsRepository dnfbpsSectorsDetailsRepository;
    @Override
    public DnfbpsSectorsDetails getDnfbpsSectorsDetailsById(Long id) {
        try {
            return dnfbpsSectorsDetailsRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<DnfbpsSectorsDetails> getAllDnfbpsSectorsDetailss() {
        return dnfbpsSectorsDetailsRepository.findAll();
    }

    @Override
    public DnfbpsSectorsDetails AddDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id_operation) {
        return null;
    }

    @Override
    public DnfbpsSectorsDetails UpdateDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id) {
        dnfbpsSectorsDetails.setId(id);
        return dnfbpsSectorsDetailsRepository.save(dnfbpsSectorsDetails);
    }

    @Override
    public DnfbpsSectorsDetails UpdateDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails, Long id, Long id_operation) {
        return null;
    }

    @Override
    public void DeleteDnfbpsSectorsDetails(Long id) {
        dnfbpsSectorsDetailsRepository.deleteById(id);
    }

    @Override
    public DnfbpsSectorsDetails AddDnfbpsSectorsDetails(DnfbpsSectorsDetails dnfbpsSectorsDetails) {
        return dnfbpsSectorsDetailsRepository.save(dnfbpsSectorsDetails);
    }
}
