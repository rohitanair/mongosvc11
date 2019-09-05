package com.infy.tele.service;

import com.infy.tele.domain.Emp;
import com.infy.tele.repository.EmpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Emp}.
 */
@Service
public class EmpService {

    private final Logger log = LoggerFactory.getLogger(EmpService.class);

    private final EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    /**
     * Save a emp.
     *
     * @param emp the entity to save.
     * @return the persisted entity.
     */
    public Emp save(Emp emp) {
        log.debug("Request to save Emp : {}", emp);
        return empRepository.save(emp);
    }

    /**
     * Get all the emps.
     *
     * @return the list of entities.
     */
    public List<Emp> findAll() {
        log.debug("Request to get all Emps");
        return empRepository.findAll();
    }


    /**
     * Get one emp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<Emp> findOne(String id) {
        log.debug("Request to get Emp : {}", id);
        return empRepository.findById(id);
    }

    /**
     * Delete the emp by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Emp : {}", id);
        empRepository.deleteById(id);
    }
}
