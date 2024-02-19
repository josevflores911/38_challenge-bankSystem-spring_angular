package com.tokyo.wayon.repositories;

import com.tokyo.wayon.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByAccountAndUserkey(BigInteger account, Integer key);
    User findByAccount(BigInteger account);
}
