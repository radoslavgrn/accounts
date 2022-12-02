package com.assignment.accounts.services;

import com.assignment.accounts.model.Account;

public interface IAccountService {

  Account addAccount(Account account);

  void deleteAccount(Integer id);

  Account editAccount(Integer id, Account account);
}
