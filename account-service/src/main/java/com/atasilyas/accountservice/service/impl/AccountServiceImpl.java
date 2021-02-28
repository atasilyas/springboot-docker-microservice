package com.atasilyas.accountservice.service.impl;

import com.atasilyas.accountservice.controller.request.PageRequest;
import com.atasilyas.accountservice.domain.Account;
import com.atasilyas.accountservice.repository.AccountRepository;
import com.atasilyas.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private static final String SORT_FIELD = "username";
    private static final String DEFAULT_CURSOR_MARK = "-1";


    @Override
    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Kayıt Bulunamadı."));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        Account oldAccount = accountRepository.findById(account.getId())
                .orElseThrow(() -> new RuntimeException("Kayıt Bulunamadı."));
        oldAccount.setEmail(account.getEmail());
        oldAccount.setIsActive(account.getIsActive());
        oldAccount.setPassword(account.getPassword());
        oldAccount.setUsername(account.getUsername());
        return accountRepository.save(oldAccount);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Account pagination() {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Slice<Account> findByPageable(PageRequest pageRequest) {
        Pageable pageable = CassandraPageRequest.of(pageRequest.getPage(), pageRequest.getSize());
        return accountRepository.findAll(pageable);
    }
}
