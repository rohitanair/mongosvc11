package com.infy.tele.service;

import com.infy.tele.domain.Cust;
import com.infy.tele.repository.CustRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Cust}.
 */
@Service
public class CustService {

    private final Logger log = LoggerFactory.getLogger(CustService.class);

    private final CustRepository custRepository;

    public CustService(CustRepository custRepository) {
        this.custRepository = custRepository;
    }

    /**
     * Save a cust.
     *
     * @param cust the entity to save.
     * @return the persisted entity.
     */
    public Cust save(Cust cust) {
        log.debug("Request to save Cust : {}", cust);
        return custRepository.save(cust);
    }

    /**
     * Get all the custs.
     *
     * @return the list of entities.
     */
    public List<Cust> findAll() {
        log.debug("Request to get all Custs");
        return custRepository.findAll();
    }


    /**
     * Get one cust by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<Cust> findOne(String id) {
        log.debug("Request to get Cust : {}", id);
        return custRepository.findById(id);
    }

    /**
     * Delete the cust by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Cust : {}", id);
        custRepository.deleteById(id);
    }
}
