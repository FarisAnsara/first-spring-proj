package org.example.Spring.Respositories;

import org.example.Spring.models.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
    @Query("SELECT MAX(c.companyId.id) FROM Company c")
    Long findMaxCompanyID();
    @Query("SELECT c FROM Company c WHERE c.companyId.name = :name")
    Company findByName(@Param("name") String name);
}
