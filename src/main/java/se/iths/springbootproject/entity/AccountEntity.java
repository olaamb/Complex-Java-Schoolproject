package se.iths.springbootproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountid;


    private String accountname;

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
}


