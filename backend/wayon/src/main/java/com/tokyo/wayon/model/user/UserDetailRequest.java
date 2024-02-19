package com.tokyo.wayon.model.user;

import java.math.BigInteger;

public record UserDetailRequest(BigInteger account, Integer userkey) {
}
