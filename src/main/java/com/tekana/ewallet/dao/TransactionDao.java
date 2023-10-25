package com.tekana.ewallet.dao;

import java.util.List;

import com.tekana.ewallet.model.TransactionListResponse;
import com.tekana.ewallet.model.TransactionRequest;
import com.tekana.ewallet.model.TransactionResponse;

public interface TransactionDao {

	TransactionResponse createTransaction(TransactionRequest transactionRequest);
	List<TransactionListResponse> findAllTransactions();
	
}
