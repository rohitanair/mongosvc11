package com.infy.tele.web.rest;

import com.infy.tele.domain.Cust;
import com.infy.tele.service.CustService;
import com.infy.tele.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.infy.tele.domain.Cust}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*") public class CustResource {

    private final Logger log = LoggerFactory.getLogger(CustResource.class);

    private static final String ENTITY_NAME = "mongosvc11Cust";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CustService custService;

    public CustResource(CustService custService) {
        this.custService = custService;
    }

    /**
     * {@code POST  /custs} : Create a new cust.
     *
     * @param cust the cust to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cust, or with status {@code 400 (Bad Request)} if the cust has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/custs")
    public ResponseEntity<Cust> createCust(@RequestBody Cust cust) throws URISyntaxException {
        log.debug("REST request to save Cust : {}", cust);
        if (cust.getId() != null) {
            throw new BadRequestAlertException("A new cust cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cust result = custService.save(cust);
        return ResponseEntity.created(new URI("/api/custs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /custs} : Updates an existing cust.
     *
     * @param cust the cust to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cust,
     * or with status {@code 400 (Bad Request)} if the cust is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cust couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/custs")
    public ResponseEntity<Cust> updateCust(@RequestBody Cust cust) throws URISyntaxException {
        log.debug("REST request to update Cust : {}", cust);
        if (cust.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Cust result = custService.save(cust);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cust.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /custs} : get all the custs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of custs in body.
     */
    @GetMapping("/custs")
    public List<Cust> getAllCusts() {
        log.debug("REST request to get all Custs");
        return custService.findAll();
    }

    /**
     * {@code GET  /custs/:id} : get the "id" cust.
     *
     * @param id the id of the cust to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cust, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/custs/{id}")
    public ResponseEntity<Cust> getCust(@PathVariable String id) {
        log.debug("REST request to get Cust : {}", id);
        Optional<Cust> cust = custService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cust);
    }

    /**
     * {@code DELETE  /custs/:id} : delete the "id" cust.
     *
     * @param id the id of the cust to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/custs/{id}")
    public ResponseEntity<Void> deleteCust(@PathVariable String id) {
        log.debug("REST request to delete Cust : {}", id);
        custService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
