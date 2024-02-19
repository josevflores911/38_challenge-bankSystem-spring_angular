package com.tokyo.wayon.services;

import com.tokyo.wayon.model.transfer.Transfer;
import com.tokyo.wayon.model.transfer.TransferData;
import com.tokyo.wayon.model.transfer.TransferDetail;
import com.tokyo.wayon.model.user.User;
import com.tokyo.wayon.repositories.TransferFeeCalculator;
import com.tokyo.wayon.repositories.TransferRepository;
import com.tokyo.wayon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransferService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private TransferFeeCalculator feeCalculator;

    public TransferDetail scheduleTransfer(TransferData data) throws Exception {

        User userSender,userReceiver;
        if(data.idSender()!=null && userRepository.existsById(data.idSender())){
            userSender = userRepository.findById(data.idSender()).get();
        }else{
            throw new Exception("sender id not found");
        };

        if (data.idSender()!=null && userRepository.existsById(data.idSender())) {
             userReceiver = userRepository.findByAccount(data.accountReceiver());
        }else{
            throw new Exception("receiver id not found");
        };

        var fee = feeCalculator.calculateTransferFee(data.amountSend(),
                calculateDateDifference(data.todayDate(),data.scheduledDate()) );

        var transfer = new Transfer(userSender,userReceiver,data,fee );

        //update user sender to decrease value

        //create transaction
        transferRepository.save(transfer);

        return new TransferDetail(transfer);
    }

    public void cancelTransfer(Long id) throws Exception {

        if (!transferRepository.existsById(id)) {
            throw new Exception("Id not found!");
        }


        var transfer = transferRepository.getReferenceById(id);
        transferRepository.delete(transfer);
    }


    public List<TransferDetail> showAllTransfer(UUID id) {
        return transferRepository.findAllBySenderId(id).stream().map(TransferDetail::new).collect(Collectors.toList());
    }

    private int calculateDateDifference(LocalDateTime startDate, LocalDateTime endDate) {
        // Calculate the difference in days
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

}
