package se.iths.springbootproject.utilities;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import se.iths.springbootproject.entity.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Scope("singleton")
public class PregeneratedData {

    @PersistenceContext
    EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    public void sampleData() {


        AccountEntity account1 = new AccountEntity("Olas Account");
        AccountEntity account2 = new AccountEntity("Seans Account");

        CharacterEntity character1 = new CharacterEntity("John");
        CharacterEntity character2 = new CharacterEntity("Anders");
        CharacterEntity character3 = new CharacterEntity("Björn");

        BackpackEntity backpack1 = new BackpackEntity("Johns Backpack");
        BackpackEntity backpack2 = new BackpackEntity("Anders Backpack");
        BackpackEntity backpack3 = new BackpackEntity("Björns Backpack");

        ConsumablesEntity consumables1 = new ConsumablesEntity("Apples");
        ConsumablesEntity consumables2 = new ConsumablesEntity("Beef");

        ToolsEntity tools1 = new ToolsEntity("Stone Axe");

        ResourcesEntity resources1 = new ResourcesEntity("Oak","Rough Stone","Copper");



        account1.addCharacter(character1);
        account1.addCharacter(character2);
        account2.addCharacter(character3);

        character1.addBackpack(backpack1);
        character2.addBackpack(backpack2);
        character3.addBackpack(backpack3);

        backpack1.addConsumables(consumables1);
        backpack2.addConsumables(consumables2);
        backpack3.addConsumables(consumables1);

        backpack3.addTools(tools1);

        backpack3.addResources(resources1);

        entityManager.persist(account1);
        entityManager.persist(account2);

/*        entityManager.persist(character1);
        entityManager.persist(character2);
        entityManager.persist(character3);

        entityManager.persist(backpack1);
        entityManager.persist(backpack1);
        entityManager.persist(backpack3);

        entityManager.persist(consumables1);
        entityManager.persist(consumables2);

        entityManager.persist(tools1);

        entityManager.persist(resources1);*/
    }

}
