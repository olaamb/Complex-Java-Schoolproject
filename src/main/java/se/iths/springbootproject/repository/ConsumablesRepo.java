package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.ConsumablesEntity;

@Repository
public interface ConsumablesRepo extends CrudRepository<ConsumablesEntity, Long> {
}
