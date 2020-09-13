package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.helpTables.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    Optional<User> findAllByEmail(String email);
}
