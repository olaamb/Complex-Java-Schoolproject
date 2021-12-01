package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.ToolsEntity;

@Repository
public interface ToolsRepo extends CrudRepository<ToolsEntity, Long> {
}
