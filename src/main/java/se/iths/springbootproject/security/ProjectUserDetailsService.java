package se.iths.springbootproject.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.repository.AccountRepo;

@Service
public class ProjectUserDetailsService implements UserDetailsService {

    private final AccountRepo accountRepo;

    public ProjectUserDetailsService(AccountRepo accountRepo) {
        super();
        this.accountRepo = accountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String accountname) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepo.findByAccountname(accountname);
        if (accountEntity == null) {
            throw new UsernameNotFoundException("No account exists with the name: " + "accountname");
        }
        return new ProjectUserDetailsService(accountEntity);
    }
}
