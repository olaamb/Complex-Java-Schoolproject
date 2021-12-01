package se.iths.springbootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.ResourcesEntity;
import se.iths.springbootproject.service.ResourcesService;


import java.util.Optional;

@RestController
@RequestMapping("resources")
public class ResourcesController {

    private final ResourcesService resourcesService;

    public ResourcesController(ResourcesService resourcesService)
    {
        this.resourcesService = resourcesService;
    }

    @PostMapping
    public ResponseEntity<ResourcesEntity> createResources(@RequestBody ResourcesEntity resourcesEntity)
    {
        ResourcesEntity createdResources = resourcesService.createResources(resourcesEntity);
        return new ResponseEntity<>(createdResources, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteResources(@PathVariable Long id) {
        resourcesService.deleteResources(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ResourcesEntity>> findResourcesById(@PathVariable Long id) {
        Optional<ResourcesEntity> foundResources = resourcesService.findResourcesById(id);
        return new ResponseEntity<>(foundResources, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<Iterable<ResourcesEntity>> findAllResources() {
        Iterable<ResourcesEntity> allResources = resourcesService.findAllResources();
        return new ResponseEntity<>(allResources, HttpStatus.OK);
    }
}
