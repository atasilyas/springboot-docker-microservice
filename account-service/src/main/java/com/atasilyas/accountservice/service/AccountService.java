package com.atasilyas.accountservice.service;

import com.atasilyas.accountservice.controller.request.PageRequest;
import com.atasilyas.accountservice.domain.Account;
import org.springframework.data.domain.Slice;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AccountService {

    Account get(@NotNull String id);

    Account save(@NotNull  Account account);

    Account update(@NotNull Account account);

    void delete(@NotNull String id);

    Account pagination();

    List<Account> findAll();

    Slice<Account> findByPageable(PageRequest pageRequest);
}
