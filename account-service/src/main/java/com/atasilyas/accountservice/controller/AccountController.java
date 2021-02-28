package com.atasilyas.accountservice.controller;

import com.atasilyas.accountservice.constants.ApiEndpoints;
import com.atasilyas.accountservice.controller.request.PageRequest;
import com.atasilyas.accountservice.domain.Account;
import com.atasilyas.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.ACCOUNT_API, produces = {ApiEndpoints.RESPONSE_CONTENTTYPE})
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> save(@RequestBody @NotNull Account account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.update(account));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") @NotNull String id) {
        accountService.delete(id);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @PostMapping(value = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Slice<Account>> getAll(@RequestBody PageRequest pageRequest) {
        return ResponseEntity.ok(accountService.findByPageable(pageRequest));
    }

}
