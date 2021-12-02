package se.iths.springbootproject.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.springbootproject.service.ConsumablesService;

@RestController
@RequestMapping("consumables")
public class ConsumablesController {

    private final ConsumablesService consumablesService;

    public ConsumablesController(ConsumablesService consumablesService)
    {
        this.consumablesService = consumablesService;
    }


}
