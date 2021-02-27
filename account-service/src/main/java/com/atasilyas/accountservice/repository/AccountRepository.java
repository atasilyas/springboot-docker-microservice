package com.atasilyas.accountservice.repository;

import com.atasilyas.accountservice.domain.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
}
