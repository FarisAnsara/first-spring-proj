package org.example.Spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {

    @Id
    private String name;
    public Roles(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Roles{" + "name='" + name + '\'' + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles() {
    }
}
