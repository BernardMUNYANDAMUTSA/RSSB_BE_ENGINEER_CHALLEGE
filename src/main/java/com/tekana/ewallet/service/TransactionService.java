package com.tekana.ewallet.service;

import java.util.List;

import com.tekana.ewallet.model.TransactionListResponse;
import com.tekana.ewallet.model.TransactionRequest;
import com.tekana.ewallet.model.TransactionResponse;

public interface TransactionService {	
	TransactionResponse createTransaction(TransactionRequest transactionRequest);
	List<TransactionListResponse> findAllTransactions();
}
