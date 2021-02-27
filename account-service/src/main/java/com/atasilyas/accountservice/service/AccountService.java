package com.atasilyas.accountservice.service;

import com.atasilyas.accountservice.domain.Account;

import javax.validation.constraints.NotNull;

public interface AccountService {

    Account get(@NotNull String id);

    Account save(@NotNull  Account account);

    Account update(@NotNull String id , @NotNull Account account);

    void delete(@NotNull String id);

    Account pagination();
}
