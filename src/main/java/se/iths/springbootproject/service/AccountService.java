package se.iths.springbootproject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.entity.RoleEntity;
import se.iths.springbootproject.repository.AccountRepo;
import se.iths.springbootproject.repository.RoleRepo;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AccountService(AccountRepo accountRepo, RoleRepo roleRepo) {
        this.accountRepo = accountRepo;
        this.roleRepo = roleRepo;
    }

    public AccountEntity createAccount(AccountEntity accountEntity) {
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        RoleEntity roleToAdd = roleRepo.findByRole("ROLE_USER");
        accountEntity.addRole(roleToAdd);
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

    public AccountEntity findAccountByName(String accountName) {
        return accountRepo.findByAccountname(accountName);
    }
}