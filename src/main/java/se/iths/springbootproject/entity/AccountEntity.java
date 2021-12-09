package se.iths.springbootproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountid;
    private String accountname;
    private String password;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List <CharacterEntity> characters = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRole(RoleEntity role) {
        roles.add(role);
        role.getAccounts().add(this);
    }

    public void removeRole(RoleEntity role) {
        roles.remove(role);
        role.getAccounts().remove(this);
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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


