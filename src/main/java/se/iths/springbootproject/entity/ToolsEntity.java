package se.iths.springbootproject.entity;


import javax.persistence.*;

@Entity
public class ToolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toolsid;

    private String axe;
    private String hammer;
    private String sickle;
    private String pickaxe;

    @ManyToOne
    @JoinColumn(name = "backpack_backpackid")
    private BackpackEntity backpack;

    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

    public ToolsEntity(String axe, String hammer, String sickle, String pickaxe) {
        this.axe = axe;
        this.hammer = hammer;
        this.sickle = sickle;
        this.pickaxe = pickaxe;
    }
    
    public ToolsEntity(){}

    public Long getToolsid() {
        return toolsid;
    }

    public void setToolsid(Long toolsid) {
        this.toolsid = toolsid;
    }

    public String getAxe() {
        return axe;
    }

    public void setAxe(String axe) {
        this.axe = axe;
    }

    public String getHammer() {
        return hammer;
    }

    public void setHammer(String hammer) {
        this.hammer = hammer;
    }

    public String getSickle() {
        return sickle;
    }

    public void setSickle(String sickle) {
        this.sickle = sickle;
    }

    public String getPickaxe() {
        return pickaxe;
    }

    public void setPickaxe(String pickaxe) {
        this.pickaxe = pickaxe;
    }


}
