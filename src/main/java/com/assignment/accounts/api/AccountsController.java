package com.assignment.accounts.api;

import com.assignment.accounts.model.AccountCreateDto;
import com.assignment.accounts.model.AccountDto;
import com.assignment.accounts.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class AccountsController implements AccountsApi {

  private final IAccountService accountService;

  @Override
  public ResponseEntity<AccountDto> addAccount(AccountCreateDto accountCreateDto) {

    AccountValidator.validate(accountCreateDto);

    return new ResponseEntity<>(
        AccountMapper.toDto(accountService.addAccount(AccountMapper.fromDto(accountCreateDto))),
        HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteAccount(Integer id) {
    accountService.deleteAccount(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AccountDto> editAccount(Integer id, AccountCreateDto accountCreateDto) {

    AccountValidator.validate(accountCreateDto);

    return ResponseEntity.ok(
        AccountMapper.toDto(
            accountService.editAccount(id, AccountMapper.fromDto(accountCreateDto))));
  }

  @Override
  public ResponseEntity<AccountDto> getAccounts() {
    return AccountsApi.super.getAccounts();
  }
}
