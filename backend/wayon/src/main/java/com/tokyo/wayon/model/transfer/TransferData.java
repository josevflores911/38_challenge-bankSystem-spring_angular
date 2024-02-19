package com.tokyo.wayon.model.transfer;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransferData(
        @NotNull
        UUID idSender,
        @NotNull
        BigInteger accountReceiver,
        @NotNull
        double amountSend,
        @NotNull
        @Future
        LocalDateTime scheduledDate,
        LocalDateTime todayDate,
        String optionalText
        ) {
}
