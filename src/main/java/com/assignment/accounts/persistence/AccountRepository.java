package com.assignment.accounts.persistence;

import com.assignment.accounts.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
