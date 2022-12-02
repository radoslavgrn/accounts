package com.assignment.accounts.services;

import com.assignment.accounts.exceptions.NotFoundException;
import com.assignment.accounts.model.Account;
import com.assignment.accounts.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AccountService implements IAccountService {

  private final AccountRepository accountRepository;

  @Override
  public Account addAccount(Account account) {
    return accountRepository.save(account);
  }

  @Override
  public void deleteAccount(Integer id) {
    Account existing = accountRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

    accountRepository.deleteById(existing.getId());
  }

  @Override
  public Account editAccount(Integer id, Account account) {

    Account existing = accountRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    account.setId(existing.getId());

    return accountRepository.save(account);
  }
}
