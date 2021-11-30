package se.iths.springbootproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long characterid;


    private String charactername;


    public CharacterEntity(String charactername) {
        this.charactername = charactername;
    }

    public CharacterEntity(){}

    public Long getCharacterid() {
        return characterid;
    }

    public void setCharacterid(Long characterid) {
        this.characterid = characterid;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }
}
