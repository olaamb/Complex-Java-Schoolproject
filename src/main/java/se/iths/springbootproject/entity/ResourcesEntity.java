package se.iths.springbootproject.entity;

import javax.persistence.*;

@Entity
public class ResourcesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourcesid;

    private String wood;
    private String stone;
    private String ore;

    @ManyToOne
    private BackpackEntity backpack;

    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ResourcesEntity(String wood, String stone, String ore) {
        this.wood = wood;
        this.stone = stone;
        this.ore = ore;
    }

    public ResourcesEntity(){}

    public Long getResourcesid() {
        return resourcesid;
    }

    public void setResourcesid(Long resourcesid) {
        this.resourcesid = resourcesid;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public String getOre() {
        return ore;
    }

    public void setOre(String ore) {
        this.ore = ore;
    }

}
