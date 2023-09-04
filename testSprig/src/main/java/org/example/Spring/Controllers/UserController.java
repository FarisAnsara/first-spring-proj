package org.example.Spring.Controllers;

import org.example.Spring.Respositories.CompanyRepository;
import org.example.Spring.Respositories.RolesRepository;
import org.example.Spring.Respositories.UserRepository;
import org.example.Spring.models.CompanyId;
import org.example.Spring.models.Company;
import org.example.Spring.models.Roles;
import org.example.Spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
//@CrossOrigin(origins = "http://localhost:8080")
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserRepository userRespository;
    private CompanyRepository companyRepository;
    private RolesRepository rolesRepository;

    public UserController(UserRepository userRespository, CompanyRepository companyRepository, RolesRepository rolesRepository) {
        this.userRespository = userRespository;
        this.companyRepository = companyRepository;
        this.rolesRepository = rolesRepository;
    }

    @GetMapping(value = "/users5", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> users = new ArrayList<>();
        userRespository.findAll().forEach(www -> users.add(www));
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/postTest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        setCompanyOfUser(user);
        setRolesOfUser(user);
        Users createdUser = userRespository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    private void setRolesOfUser(Users user) {
        Set<Roles> roleName = user.getRoles();
        rolesRepository.saveAll(roleName);
    }

    private void setCompanyOfUser(Users user) {
        String companyName = user.getCompany().getCompanyId().getName();
        String city = user.getCompany().getCity();
        Company company = companyRepository.findByName(companyName);
        company = ifCompanyIsNullCreateNewCompany(company, companyName, city);
        user.setCompany(company);
    }

    private Company ifCompanyIsNullCreateNewCompany(Company company, String companyName, String city) {
        if (company != null)
            return company;
        long newId = ifCompanyIdNullEqualsZero();
        CompanyId companyId = new CompanyId(newId, companyName);
        return companyRepository.save(new Company(companyId, city));
    }

    private long ifCompanyIdNullEqualsZero() {
        if(companyRepository.findMaxCompanyID() != null) {
            return companyRepository.findMaxCompanyID() + 1;
        }
        return 0;
    }
}
