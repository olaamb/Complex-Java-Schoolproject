package se.iths.springbootproject.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.BackpackEntity;
import se.iths.springbootproject.service.BackpackService;

import java.util.Optional;

@RestController
@RequestMapping("backpacks")
public class BackpackController {

    private final BackpackService backpackservice;

    public BackpackController(BackpackService backpackService)
    {
        this.backpackservice = backpackService;
    }

    @PostMapping
    public ResponseEntity<BackpackEntity> createBackpack(@RequestBody BackpackEntity backpackEntity)
    {
        BackpackEntity createdBackpack = backpackservice.createBackpack(backpackEntity);
        return new ResponseEntity<>(createdBackpack, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBackpack(@PathVariable Long id) {
        backpackservice.deleteBackpack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<BackpackEntity>> findBackpackById(@PathVariable Long id) {
        Optional<BackpackEntity> foundBackpack = backpackservice.findBackpackById(id);
        return new ResponseEntity<>(foundBackpack, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<Iterable<BackpackEntity>> findAllBackpacks() {
        Iterable<BackpackEntity> allBackpacks = backpackservice.findAllBackpacks();
        return new ResponseEntity<>(allBackpacks, HttpStatus.OK);
    }


}
