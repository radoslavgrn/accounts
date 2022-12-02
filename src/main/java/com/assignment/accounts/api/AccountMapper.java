package com.assignment.accounts.api;

import com.assignment.accounts.model.Account;
import com.assignment.accounts.model.AccountCreateDto;
import com.assignment.accounts.model.AccountDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

  public Account fromDto(AccountCreateDto dto)
  {
    Account model = new Account();
    model.setEmail(dto.getEmail());
    model.setFirstName(dto.getFirstName());
    model.setLastName(dto.getLastName());
    model.setDateOfBirth(dto.getDateOfBirth());

    return model;
  }

  public AccountDto toDto(Account model)
  {
    AccountDto dto = new AccountDto();
    dto.setId(Long.valueOf(model.getId()));
    dto.setEmail(model.getEmail());
    dto.setLastName(model.getLastName());
    dto.setDateOfBirth(dto.getDateOfBirth());

    return dto;
  }

}
