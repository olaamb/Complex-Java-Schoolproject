package se.iths.springbootproject.entity;

import javax.persistence.*;

@Entity
public class ConsumablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumablesid;

    private String fruit;
    private String meat;
    private String vegetables;

    @ManyToOne
    @JoinColumn(name = "backpack_backpackid")
    private BackpackEntity backpack;

    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ConsumablesEntity(String fruit, String meat, String vegetables) {
        this.fruit = fruit;
        this.meat = meat;
        this.vegetables = vegetables;
    }
    public ConsumablesEntity(){}

    public Long getConsumablesid() {
        return consumablesid;
    }

    public void setConsumablesid(Long consumablesid) {
        this.consumablesid = consumablesid;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }
}
