package se.iths.springbootproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsumablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumablesid;

    private String Fruit;
    private String Meat;
    private String Vegetables;

    public ConsumablesEntity(String fruit, String meat, String vegetables) {
        Fruit = fruit;
        Meat = meat;
        Vegetables = vegetables;
    }
    public ConsumablesEntity(){}

    public Long getConsumablesid() {
        return consumablesid;
    }

    public void setConsumablesid(Long consumablesid) {
        this.consumablesid = consumablesid;
    }

    public String getFruit() {
        return Fruit;
    }

    public void setFruit(String fruit) {
        Fruit = fruit;
    }

    public String getMeat() {
        return Meat;
    }

    public void setMeat(String meat) {
        Meat = meat;
    }

    public String getVegetables() {
        return Vegetables;
    }

    public void setVegetables(String vegetables) {
        Vegetables = vegetables;
    }
}
