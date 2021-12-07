package se.iths.springbootproject.utilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.iths.springbootproject.entity.*;
import se.iths.springbootproject.repository.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Scope("singleton")
@Configuration
public class PregeneratedData {

    @Bean
    CommandLineRunner sampleData(AccountRepo accountRepo, BackpackRepo backpackRepo, CharacterRepo characterRepo, ConsumablesRepo consumablesRepo, ResourcesRepo resourcesRepo, ToolsRepo toolsRepo) {
    return args -> {
    AccountEntity account1 = new AccountEntity("OlasAccount");
    AccountEntity account2 = new AccountEntity("SeansAccount");

    CharacterEntity character1 = new CharacterEntity("John");
    CharacterEntity character2 = new CharacterEntity("Anders");
    CharacterEntity character3 = new CharacterEntity("Björn");

    BackpackEntity backpack1 = new BackpackEntity("JohnsBackpack");
    BackpackEntity backpack2 = new BackpackEntity("AndersBackpack");
    BackpackEntity backpack3 = new BackpackEntity("BjörnsBackpack");

    ConsumablesEntity consumables1 = new ConsumablesEntity("Apples");
    ConsumablesEntity consumables2 = new ConsumablesEntity("Beef");

    ToolsEntity tools1 = new ToolsEntity("StoneAxe");

    ResourcesEntity resources1 = new ResourcesEntity("Wood");

    account1.addCharacter(character1);
    account1.addCharacter(character2);
    account2.addCharacter(character3);

        character1.addBackpack(backpack1);
        character2.addBackpack(backpack2);
        character3.addBackpack(backpack3);
//        backpack1.setCharacter(character1);
//        backpack2.setCharacter(character2);
//        backpack3.setCharacter(character3);

        backpack1.addConsumables(consumables1);
        backpack2.addConsumables(consumables2);
        backpack3.addTools(tools1);
        backpack3.addResources(resources1);

        accountRepo.save(account1);
        accountRepo.save(account2);


        characterRepo.save(character1);
        characterRepo.save(character2);
        characterRepo.save(character3);

        backpackRepo.save(backpack1);
        backpackRepo.save(backpack2);
        backpackRepo.save(backpack3);
};
    }
}
