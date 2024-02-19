package com.tokyo.wayon.services.fee;

import com.tokyo.wayon.repositories.TransferFeeCalculator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Getter
@NoArgsConstructor
public class RangeFeeCalculator implements TransferFeeCalculator {
    private int dayBound;
    private double transferAmount;
    RangeFeeCalculator(int dayBound, double transferAmount){
        this.dayBound=dayBound;
        this.transferAmount=transferAmount;
    }

    @Override
    public double calculateTransferFee(double transferAmount, int daysBound) throws Exception {
        if(dayBound == 0){
            return (transferAmount*0.025)-3;

        } else if ((dayBound>=1)&&(dayBound<10)) {
            return(transferAmount)-12;

        } else if ((dayBound>=11)&&(dayBound<20)) {
            return(transferAmount*0.082);

        } else if ((dayBound>=21)&&(dayBound<30)) {
            return(transferAmount*0.069);

        } else if ((dayBound>=31)&&(dayBound<40)) {
            return(transferAmount*0.047);

        } else if ((dayBound>=41)&&(dayBound<50)) {
            return(transferAmount*0.017);

        }else{
            throw new Exception("fee exception");
        }
    }
}
