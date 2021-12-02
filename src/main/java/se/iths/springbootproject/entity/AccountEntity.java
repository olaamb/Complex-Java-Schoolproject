package se.iths.springbootproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountid;
    private String accountname;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List <CharacterEntity> characters = new ArrayList<>();

    public AccountEntity(String accountname) {
        this.accountname = accountname;
    }

    public AccountEntity(){}

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public List<CharacterEntity> getCharacters()
    {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters)
    {
        this.characters = characters;
    }

    public void addCharacter(CharacterEntity character) {
        characters.add(character);
        character.setAccount(this);
    }
}


