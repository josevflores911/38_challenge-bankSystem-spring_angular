package com.tokyo.wayon.controller;


import com.tokyo.wayon.model.transfer.TransferData;
import com.tokyo.wayon.model.transfer.TransferDetail;
import com.tokyo.wayon.model.user.UserDetail;
import com.tokyo.wayon.services.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    @Transactional
    @Operation(summary = "register a new tranfer")
    public ResponseEntity<TransferDetail> createTransfer(@RequestBody @Valid TransferData data) throws Exception {
            System.out.println(data.toString());

            var response = transferService.scheduleTransfer(data);

            return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Get the entire list of transfers")
    public ResponseEntity<List<TransferDetail>> showUserTransactionsList(@PathVariable String id) {
            var newid =UUID.fromString(id);
            var transferList = transferService.showAllTransfer(newid);
            return ResponseEntity.ok(transferList);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "cancel schedule transfer")
    public ResponseEntity<Object> removeTransferById(@PathVariable Long id) throws Exception {
        transferService.cancelTransfer(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get transaction by Id")
    public ResponseEntity<TransferDetail> getTransactionById(@PathVariable Long id) {

//        var user = userRepository.getReferenceById(id);
//        return ResponseEntity.ok(new UserDetail(user));
        return null;
    }

}
