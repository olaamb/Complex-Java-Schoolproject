package se.iths.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springbootproject.entity.AccountEntity;

@Repository
public interface AccountRepo extends CrudRepository<AccountEntity, Long> {
    AccountEntity findByAccountname (String accountname);
}

