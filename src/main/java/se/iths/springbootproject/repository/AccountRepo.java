package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springbootproject.entity.AccountEntity;

public interface AccountRepo extends CrudRepository<AccountEntity, Long> {
    AccountEntity findByAccountname (String accountname);
}
