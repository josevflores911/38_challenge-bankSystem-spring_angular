package com.tokyo.wayon.model.user;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public record UserDetail(UUID id, String name, BigInteger account, BigDecimal amount) {
    public UserDetail(User user) {
        this(user.getId(), user.getName(), user.getAccount(), user.getAmount());
    }
}