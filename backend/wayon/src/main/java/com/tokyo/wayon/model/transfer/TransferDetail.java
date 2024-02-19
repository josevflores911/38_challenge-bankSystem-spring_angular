package com.tokyo.wayon.model.transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransferDetail(Long id, UUID idSender, UUID idReceiver, double amount,double fee, LocalDateTime date, String text,boolean aproved) {
    public TransferDetail(Transfer transfer) {
        this(transfer.getId(),transfer.getSender().getId(),transfer.getReceiver().getId(),transfer.getAmount(),transfer.getFee(),transfer.getDesiredDate(),transfer.getText(),transfer.isAproved());
    }
}