package se.iths.springbootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootproject.entity.AccountEntity;
import se.iths.springbootproject.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity accountEntity){
            AccountEntity createdAccount = accountService.createAccount(accountEntity);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAcccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<AccountEntity>> findAccountById(@PathVariable Long id) {
        Optional<AccountEntity> foundAccount = accountService.findAccountById(id);
        return new ResponseEntity<>(foundAccount, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<Iterable<AccountEntity>> findAllAccounts() {
        Iterable<AccountEntity> allAccounts = accountService.findAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

}
