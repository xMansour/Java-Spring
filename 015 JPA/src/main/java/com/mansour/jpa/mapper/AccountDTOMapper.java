package com.mansour.jpa.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.mansour.jpa.dto.AccountDTO;
import com.mansour.jpa.model.Account;

@Component
public class AccountDTOMapper implements Function<Account, AccountDTO> {

    @Override
    public AccountDTO apply(Account account) {
        if (account != null)
            return new AccountDTO(account.getUserName());
        else
            return new AccountDTO("");
    }

}
