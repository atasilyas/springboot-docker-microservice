package com.atasilyas.accountservice.service.impl;

import com.atasilyas.accountservice.domain.Account;
import com.atasilyas.accountservice.repository.AccountRepository;
import com.atasilyas.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Kayıt Bulunamadı."));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(String id , Account account) {
        Account oldAccount = accountRepository.findById(id)
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
}
