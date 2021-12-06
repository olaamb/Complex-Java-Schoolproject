package se.iths.springbootproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long regionid;

    private String regionname;

    @ManyToMany
    private List<AccountEntity> accounts = new ArrayList<>();

    public RegionEntity(Long regionid, String regionname) {
        this.regionid = regionid;
        this.regionname = regionname;
    }

    public RegionEntity(){}

    public Long getRegionid() {
        return regionid;
    }

    public void setRegionid(Long regionid) {
        this.regionid = regionid;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}
