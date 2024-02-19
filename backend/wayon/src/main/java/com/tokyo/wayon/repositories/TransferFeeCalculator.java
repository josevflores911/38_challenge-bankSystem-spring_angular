package com.tokyo.wayon.repositories;

import com.tokyo.wayon.services.fee.RangeFeeCalculator;

import java.math.BigDecimal;

public interface TransferFeeCalculator {
    double calculateTransferFee(double transferAmount, int daysBound) throws Exception;
}
