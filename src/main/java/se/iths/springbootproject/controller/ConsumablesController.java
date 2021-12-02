package se.iths.springbootproject.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.BackpackEntity;
import se.iths.springbootproject.entity.ConsumablesEntity;
import se.iths.springbootproject.service.ConsumablesService;

import java.util.Optional;

@RestController
@RequestMapping("consumables")
public class ConsumablesController {

    private final ConsumablesService consumablesService;

    public ConsumablesController(ConsumablesService consumablesService)
    {
        this.consumablesService = consumablesService;
    }

    @PostMapping
    public ResponseEntity<ConsumablesEntity> createConsumables(@RequestBody ConsumablesEntity consumablesEntity)
    {
        ConsumablesEntity createdConsumables = consumablesService.createConsumables(consumablesEntity);
        return new ResponseEntity<>(createdConsumables, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteConsumables(@PathVariable Long id) {
        consumablesService.deleteConsumables(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ConsumablesEntity>> findConsumablesById(@PathVariable Long id) {
        Optional<ConsumablesEntity> foundConsumables = consumablesService.findConsumablesById(id);
        return new ResponseEntity<>(foundConsumables, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<ConsumablesEntity>> findAllConsumables() {
        Iterable<ConsumablesEntity> allConsumables = consumablesService.findAllConsumables();
        return new ResponseEntity<>(allConsumables, HttpStatus.OK);
    }
}
