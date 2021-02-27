package com.atasilyas.accountservice.controller;

import com.atasilyas.accountservice.domain.Account;
import com.atasilyas.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id ,@RequestBody Account account) {
        return ResponseEntity.ok(accountService.update(id ,account));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }

}
