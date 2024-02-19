package com.tokyo.wayon.services.fee;

import com.tokyo.wayon.repositories.TransferFeeCalculator;

import java.math.BigDecimal;

public class NoFeeCalculator implements TransferFeeCalculator {
    @Override
    public double calculateTransferFee(double transferAmount, int daysBound) throws Exception {
        return 0;
    }
}
