package se.iths.springbootproject.entity;

import javax.persistence.*;

@Entity
public class ConsumablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumablesid;

    private String consumablesname;

    @ManyToOne
    private BackpackEntity backpack;

    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ConsumablesEntity(String consumablesname) {
        this.consumablesname = consumablesname;
    }
    public ConsumablesEntity(){}

    public Long getConsumablesid() {
        return consumablesid;
    }

    public void setConsumablesid(Long consumablesid) {
        this.consumablesid = consumablesid;
    }

    public String getConsumablesname() {
        return consumablesname;
    }

    public void setConsumablesname(String consumablesname) {
        this.consumablesname = consumablesname;
    }

}
