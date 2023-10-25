package com.tekana.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tekana.ewallet.model.TransactionListResponse;
import com.tekana.ewallet.model.TransactionRequest;
import com.tekana.ewallet.model.TransactionResponse;
import com.tekana.ewallet.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
    private  TransactionService transactiontService;
	
    @PostMapping("/recordNewTransaction")
    private ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest transactionRequest){
    	return ResponseEntity.ok(transactiontService.createTransaction(transactionRequest));
    }
    
    @GetMapping("/all_transactions")
    public List<TransactionListResponse> getAllTransactions() {
    	return transactiontService.findAllTransactions();
    }

}
