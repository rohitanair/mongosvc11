package com.infy.tele.repository;

import com.infy.tele.domain.Cust;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * Spring Data Couchbase repository for the Cust entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustRepository extends N1qlCouchbaseRepository<Cust, String> {

}
