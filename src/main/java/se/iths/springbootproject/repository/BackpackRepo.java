package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.BackpackEntity;

public interface BackpackRepo extends CrudRepository<BackpackEntity, Long> {
}
