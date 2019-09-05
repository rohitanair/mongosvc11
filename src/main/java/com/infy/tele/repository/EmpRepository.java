package com.infy.tele.repository;

import com.infy.tele.domain.Emp;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * Spring Data Couchbase repository for the Emp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpRepository extends N1qlCouchbaseRepository<Emp, String> {

}
