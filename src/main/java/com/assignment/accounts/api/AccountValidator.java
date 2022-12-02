package com.assignment.accounts.api;

import com.assignment.accounts.exceptions.ErrorException;
import com.assignment.accounts.model.AccountCreateDto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@UtilityClass
public class AccountValidator {

  public void validate(AccountCreateDto accountCreate) {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(accountCreate.getEmail());
    boolean isValidMail = matcher.matches();

    if (!isValidMail) {
      throw new ErrorException("Email is not valid");
    }

    if (!StringUtils.hasText(accountCreate.getFirstName())) {
      throw new ErrorException("First name is mandatory");
    }

    if (!StringUtils.hasText(accountCreate.getLastName())) {
      throw new ErrorException("Last name is mandatory");
    }

    if (ObjectUtils.isEmpty(accountCreate.getDateOfBirth())) {
      throw new ErrorException("Date of birth is mandatory");
    }
  }

}
