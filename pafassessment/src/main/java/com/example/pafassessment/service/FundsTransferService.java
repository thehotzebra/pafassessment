package com.example.pafassessment.service;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.example.pafassessment.model.Userdata;

public class FundsTransferService {
    
@Transactional(rollbackFor={ Exception.class })
public void Transaction(Userdata user) throws Exception {

    String transactionId = UUID.randomUUID().toString().substring(0, 8);

    user.setTransactionId(transactionId);
    user.setAmount(null);

}

}
