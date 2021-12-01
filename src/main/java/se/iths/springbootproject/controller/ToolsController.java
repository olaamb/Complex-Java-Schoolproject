package se.iths.springbootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.ToolsEntity;
import se.iths.springbootproject.service.ToolsService;

import java.util.Optional;

@RestController
@RequestMapping("tools")
public class ToolsController {

    private final ToolsService toolsService;

    public ToolsController(ToolsService toolsService)
    {
        this.toolsService = toolsService;
    }

    @PostMapping
    public ResponseEntity<ToolsEntity> createTools(@RequestBody ToolsEntity toolsEntity)
    {
        ToolsEntity createdTools = toolsService.createTools(toolsEntity);
        return new ResponseEntity<>(createdTools, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTools(@PathVariable Long id) {
        toolsService.deleteTools(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ToolsEntity>> findToolsById(@PathVariable Long id) {
        Optional<ToolsEntity> foundTools = toolsService.findToolsById(id);
        return new ResponseEntity<>(foundTools, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<Iterable<ToolsEntity>> findAllTools() {
        Iterable<ToolsEntity> allTools = toolsService.findAllTools();
        return new ResponseEntity<>(allTools, HttpStatus.OK);
    }
}
