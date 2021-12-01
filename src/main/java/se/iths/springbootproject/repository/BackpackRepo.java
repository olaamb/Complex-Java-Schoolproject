package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.BackpackEntity;

@Repository
public interface BackpackRepo extends CrudRepository<BackpackEntity, Long> {
}
