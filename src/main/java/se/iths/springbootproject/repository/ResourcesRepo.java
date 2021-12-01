package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.ResourcesEntity;

public interface ResourcesRepo extends CrudRepository<ResourcesEntity, Long> {
}
