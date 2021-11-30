package se.iths.springbootproject.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BackpackEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long backpackid;
    
    private String backpackname;

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

}
