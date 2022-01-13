package se.iths.springbootproject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.entity.RoleEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class ProjectUserPrincipal implements UserDetails {

    private AccountEntity accountEntity;

    public ProjectUserPrincipal(AccountEntity accountEntity) {
        super();

        this.accountEntity = accountEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roles = accountEntity.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());
        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.accountEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.accountEntity.getAccountname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
