package com.atasilyas.accountservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Version;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = {"id", "version"})
@ToString
@Table(value = "account")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column(value = "uname")
    private String username;

    @Column(value = "email")
    private String email;

    @Column(value = "pwd")
    private String password;

    @Version
    private String version;

    @Column(value = "created_date")
    private Date createdDate;

    @Column(value = "is_active")
    private Boolean isActive;


}
