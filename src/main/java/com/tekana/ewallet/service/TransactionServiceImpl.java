package com.tekana.ewallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekana.ewallet.dao.TransactionDao;
import com.tekana.ewallet.model.TransactionListResponse;
import com.tekana.ewallet.model.TransactionRequest;
import com.tekana.ewallet.model.TransactionResponse;

@Service
public class TransactionServiceImpl  implements TransactionService{
	
	@Autowired
	private TransactionDao transactionDao;
	
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) { 	
    return transactionDao.createTransaction(transactionRequest);
    }
    
    
	public List<TransactionListResponse> findAllTransactions(){		
		return transactionDao.findAllTransactions();
	}

}
