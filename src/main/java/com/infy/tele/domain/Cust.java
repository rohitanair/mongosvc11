package com.infy.tele.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.Id;
import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import java.io.Serializable;

import static com.infy.tele.config.Constants.ID_DELIMITER;
import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

/**
 * A Cust.
 */
@Document
public class Cust implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String PREFIX = "cust";

    @SuppressWarnings("unused")
    @IdPrefix
    private String prefix = PREFIX;

    @Id
    @GeneratedValue(strategy = UNIQUE, delimiter = ID_DELIMITER)
    private String id;

    @Field("name")
    private String name;

    @Field("addr")
    private String addr;

    @Field("contact_number")
    private Integer contactNumber;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Cust name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public Cust addr(String addr) {
        this.addr = addr;
        return this;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public Cust contactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cust)) {
            return false;
        }
        return id != null && id.equals(((Cust) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cust{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", addr='" + getAddr() + "'" +
            ", contactNumber=" + getContactNumber() +
            "}";
    }
}
