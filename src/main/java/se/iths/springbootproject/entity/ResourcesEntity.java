package se.iths.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ResourcesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourcesid;

    private String resourcename;


    @ManyToOne
    private BackpackEntity backpack;

    @JsonIgnore
    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ResourcesEntity(String resourcename) {
        this.resourcename = resourcename;
    }

    public ResourcesEntity(){}

    public Long getResourcesid() {
        return resourcesid;
    }

    public void setResourcesid(Long resourcesid) {
        this.resourcesid = resourcesid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String wood) {
        this.resourcename = wood;
    }
}
