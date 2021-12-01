package se.iths.springbootproject.entity;

import javax.persistence.*;


@Entity
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long characterid;


    private String charactername;

    @ManyToOne
    @JoinColumn(name = "account_accountid")
    private AccountEntity account;

    @OneToOne
    private BackpackEntity backpack;

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }


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
