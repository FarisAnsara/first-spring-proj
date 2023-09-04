package org.example.Spring.Respositories;

import org.example.Spring.models.Company;
import org.example.Spring.models.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    @Query("SELECT c FROM Roles c WHERE c.name = :name")
    Company findByName(@Param("name") String name);
}
