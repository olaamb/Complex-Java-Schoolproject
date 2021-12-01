package se.iths.springbootproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BackpackEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long backpackid;
    private String backpackname;

    @OneToMany(mappedBy = "backpack", cascade = CascadeType.ALL)
    private List<ToolsEntity> tools = new ArrayList<>();

    @OneToMany(mappedBy = "backpack", cascade = CascadeType.ALL)
    private List<ResourcesEntity> resources = new ArrayList<>();

    @OneToMany(mappedBy = "backpack", cascade = CascadeType.ALL)
    private List<ConsumablesEntity> consumables = new ArrayList<>();

    public BackpackEntity(String backpackname) {
        this.backpackname = backpackname;
    }
    public BackpackEntity(){}

    public Long getBackpackid() {
        return backpackid;
    }

    public void setBackpackid(Long backpackid) {
        this.backpackid = backpackid;
    }

    public String getBackpackname() {
        return backpackname;
    }

    public void setBackpackname(String backpackname) {
        this.backpackname = backpackname;
    }

    public List<ToolsEntity> getTools() {
        return tools;
    }

    public void setTools(List<ToolsEntity> tools) {
        this.tools = tools;
    }

    public List<ResourcesEntity> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesEntity> resources) {
        this.resources = resources;
    }

    public List<ConsumablesEntity> getConsumables() {
        return consumables;
    }

    public void setConsumables(List<ConsumablesEntity> consumables) {
        this.consumables = consumables;
    }


}
