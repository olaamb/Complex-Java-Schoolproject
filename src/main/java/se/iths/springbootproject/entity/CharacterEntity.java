package se.iths.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long characterid;

    private String charactername;

    @OneToOne(cascade = CascadeType.ALL)
    private BackpackEntity backpack;

    @ManyToOne
    @JoinColumn(name = "account_accountid")
    private AccountEntity accounts;

    public CharacterEntity(String charactername) {
        this.charactername = charactername;
    }

    public CharacterEntity(){}

    @JsonIgnore
    public AccountEntity getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountEntity accounts) {
        this.accounts = accounts;
    }

    public BackpackEntity getBackpack() {
        return backpack;
    }

    public void setBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
    }

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

    public void setAccount(AccountEntity accounts)
    {
        this.accounts = accounts;
    }

    public void addBackpack(BackpackEntity backpack) {
        this.backpack = backpack;
        backpack.setCharacter(this);
    }
}
