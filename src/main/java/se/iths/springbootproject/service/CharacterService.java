package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.entity.CharacterEntity;
import se.iths.springbootproject.repository.CharacterRepo;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public CharacterEntity createCharacter (CharacterEntity characterEntity){
        return characterRepo.save(characterEntity);
    }

    public void deleteCharacter (Long characterId){
        CharacterEntity foundCharacter = characterRepo.findById(characterId).orElseThrow(EntityNotFoundException::new);
        characterRepo.deleteById(foundCharacter.getCharacterid());
    }

    public Optional<CharacterEntity> findCharacterById(Long characterId) {
        return characterRepo.findById(characterId);
    }

    public Iterable<CharacterEntity> findAllCharacters() {
        return characterRepo.findAll();
    }
}
