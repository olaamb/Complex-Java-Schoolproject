package se.iths.springbootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.entity.CharacterEntity;
import se.iths.springbootproject.service.CharacterService;

import java.util.Optional;

@RestController
@RequestMapping("characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterEntity characterEntity)
    {
        CharacterEntity createdCharacter = characterService.createCharacter(characterEntity);
        return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<CharacterEntity>> findCharacterById(@PathVariable Long id) {
        Optional<CharacterEntity> foundCharacter = characterService.findCharacterById(id);
        return new ResponseEntity<>(foundCharacter, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<CharacterEntity>> findAllCharacters() {
        Iterable<CharacterEntity> allCharacters = characterService.findAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }
}
