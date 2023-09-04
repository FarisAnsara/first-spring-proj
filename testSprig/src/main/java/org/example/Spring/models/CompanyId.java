package org.example.Spring.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class CompanyId implements Serializable {

    long id;
    String name;

    public CompanyId(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyId() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
