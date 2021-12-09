package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository {
    RoleEntity findByRole(String role);
}
