package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.repository.AccountRepo;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public AccountEntity createAccount(AccountEntity accountEntity) {
        return accountRepo.save(accountEntity);
    }

    public void deleteAccount(Long accountId) {
        AccountEntity foundAccount = accountRepo.findById(accountId).orElseThrow(EntityNotFoundException::new);
        accountRepo.deleteById(foundAccount.getAccountid());
    }

    public Optional<AccountEntity> findAccountById(Long accountId) {
        return accountRepo.findById(accountId);
    }

    public Iterable<AccountEntity> findAllAccounts() {
        return accountRepo.findAll();
    }
}