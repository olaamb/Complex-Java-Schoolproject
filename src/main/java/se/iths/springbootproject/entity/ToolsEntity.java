package se.iths.springbootproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ToolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toolsid;

    private String toolsname;


    @ManyToOne
    private BackpackEntity backpack;

    @JsonIgnore
    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ToolsEntity(String toolsname) {
        this.toolsname = toolsname;
    }
    
    public ToolsEntity(){}

    public Long getToolsid() {
        return toolsid;
    }

    public void setToolsid(Long toolsid) {
        this.toolsid = toolsid;
    }

    public String getToolsname() {
        return toolsname;
    }

    public void setToolsname(String toolsname) {
        this.toolsname = toolsname;
    }

}
