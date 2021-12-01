package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.repository.AccountRepo;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo)
    {
        this.accountRepo = accountRepo;
    }

    public AccountEntity createAccount(AccountEntity accountEntity)
    {
        return accountRepo.save(accountEntity);
    }

}
