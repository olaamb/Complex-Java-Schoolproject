package se.iths.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.springbootproject.entity.RoleEntity;
import se.iths.springbootproject.repository.RoleRepository;

@SpringBootApplication
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpRole(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
        };
    }

}
