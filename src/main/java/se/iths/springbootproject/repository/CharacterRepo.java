package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.CharacterEntity;

public interface CharacterRepo extends CrudRepository<CharacterEntity, Long> {
}
