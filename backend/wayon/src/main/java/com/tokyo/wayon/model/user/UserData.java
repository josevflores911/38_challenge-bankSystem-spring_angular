package com.tokyo.wayon.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;


public record UserData(
        @NotBlank
        String name,
        @NotBlank
        @Size(min = 12, max = 12)
        BigInteger account,
        BigDecimal amount,
        @NotBlank
        @Size(min = 4, max = 4)
        int userkey


//        @NotBlank
//        @Email
//        String email,
//        @NotBlank
//        @Size(min = 0, max = 15)
//        String telefono,
//        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
//        @NotNull
//        @Valid
//        DatosDireccion direccion)
)

         {
}