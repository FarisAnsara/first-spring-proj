package org.example.Spring.models;

import jakarta.persistence.*;


@Entity
public class Company {

    @EmbeddedId
    private CompanyId companyId;
    private String city;


    public Company() {
    }

    public CompanyId getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyId companyId) {
        this.companyId = companyId;
    }

    public Company(CompanyId companyId, String city) {
        this.companyId = companyId;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Company{" + ", city='" + city + '\'' + '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
