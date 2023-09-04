package org.example.Spring;

import org.example.Spring.Controllers.UserController;
import org.example.Spring.Respositories.CompanyRepository;
import org.example.Spring.Respositories.RolesRepository;
import org.example.Spring.Respositories.UserRepository;
import org.example.Spring.models.CompanyId;
import org.example.Spring.models.Company;
import org.example.Spring.models.Roles;
import org.example.Spring.models.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.example")
@EntityScan(basePackages = "org.example.Spring")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner init(UserRepository userRepository, CompanyRepository companyRepository, RolesRepository rolesRepository) {
//        UserController userController = new UserController(userRepository, companyRepository, rolesRepository);
//
//        List<String> names = Arrays.asList("John", "Julie", "Jennifer", "Helen", "Rachel");
//        List<String> companyNames = Arrays.asList("ProgressSoft", "Amazon", "MicroSoft", "Google", "PwC");
//        List<String> cities = Arrays.asList("Amman", "Los Angolas", "Amman", "Amman", "London");
//        Roles developer = new Roles("developer");
//        Roles engineer = new Roles("engineer");
//        rolesRepository.saveAll(Arrays.asList(developer,engineer));
//
//        return args -> {
//            for (int i = 0; i < names.size(); i++) {
//                String name = names.get(i);
//                String companyName = companyNames.get(i);
//                String city = cities.get(i);
//                List<Roles> roles = (List<Roles>) rolesRepository.findAll();
//                CompanyId companyId = new CompanyId(i + 1, companyName);
//                Company company = new Company(companyId, city);
//                companyRepository.save(company);
//                Users user = new Users(name, name.toLowerCase() + "@" + companyName.toLowerCase() + ".com", company);
//                user.setRoles(new HashSet<>(roles));
//                userRepository.save(user);
//                userController.addUser(user);
//            }
//        };
//    }
}
