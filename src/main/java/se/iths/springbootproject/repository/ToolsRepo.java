package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.ToolsEntity;

public interface ToolsRepo extends CrudRepository<ToolsEntity, Long> {
}
