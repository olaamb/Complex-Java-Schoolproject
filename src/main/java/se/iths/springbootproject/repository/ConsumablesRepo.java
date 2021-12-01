package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.ConsumablesEntity;

public interface ConsumablesRepo extends CrudRepository<ConsumablesEntity, Long> {
}
