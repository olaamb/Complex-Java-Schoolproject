package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.ResourcesEntity;

@Repository
public interface ResourcesRepo extends CrudRepository<ResourcesEntity, Long> {
}
