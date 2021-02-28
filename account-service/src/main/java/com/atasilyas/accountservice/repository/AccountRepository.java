package com.atasilyas.accountservice.repository;

import com.atasilyas.accountservice.domain.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
}
