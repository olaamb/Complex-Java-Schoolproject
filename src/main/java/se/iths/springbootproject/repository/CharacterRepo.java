package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.CharacterEntity;

@Repository
public interface CharacterRepo extends CrudRepository<CharacterEntity, Long> {
}
