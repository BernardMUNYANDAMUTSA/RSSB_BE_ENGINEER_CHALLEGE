package com.tekana.ewallet.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tekana.ewallet.config.MD5PasswordEncryption;
import com.tekana.ewallet.model.Customer;
import com.tekana.ewallet.model.Transaction;
import com.tekana.ewallet.model.TransactionListResponse;
import com.tekana.ewallet.model.TransactionRequest;
import com.tekana.ewallet.model.TransactionResponse;
import com.tekana.ewallet.model.Wallet;

public class TransactionDaoImpl implements TransactionDao{
	
	private final SessionFactory sessionFactory;
	public TransactionDaoImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

    @Override
	@Transactional
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
   	
    	Wallet senderAccountNoObj= (Wallet)sessionFactory.getCurrentSession().createQuery("from Wallet where walletAccountNo='"+transactionRequest.getSenderWalletAccountNo() +"'").uniqueResult();   	 
    	
    	TransactionResponse resObj=new TransactionResponse();
    	Wallet receiverAccountNoObj=new Wallet();
    	if (!transactionRequest.getSenderWalletAccountNo().equals(transactionRequest.getReceiverWalletAccountNo())) {
    		
    	if(senderAccountNoObj !=null) {
    		
        	String encryptedPassword = MD5PasswordEncryption.encryptPassword(transactionRequest.getSenderPassword());
        	Customer senderCustObj=(Customer)sessionFactory.getCurrentSession().createQuery("from Customer where id='"+senderAccountNoObj.getCustomerObj().getId()+"'").uniqueResult();
        	
        	if(senderCustObj.getPassword().equals(encryptedPassword)) {
        
    		if (senderAccountNoObj.getBalance() >= transactionRequest.getTransferredAmount()) {
    	   		 
    			receiverAccountNoObj= (Wallet)sessionFactory.getCurrentSession().createQuery("from Wallet where walletAccountNo='"+transactionRequest.getReceiverWalletAccountNo() +"'").uniqueResult();   	 
        		
    	   		 if(receiverAccountNoObj != null) { 
        			
    	   		   	Transaction transactionObj=new Transaction();
    	   	    	transactionObj.setTransferredAmount(transactionRequest.getTransferredAmount());
    	   	    	transactionObj.setSenderWalletAccountNo(senderAccountNoObj);
    	   	    	transactionObj.setReceiverWalletAccountNo(receiverAccountNoObj);
    	   	    	transactionObj.setTransactionDate(new Date());
    	   	    	Long transactionNo=(Long) sessionFactory.getCurrentSession().save(transactionObj);    	   	    	
    	   	    	resObj.setMessages("Amount transferred successfully from AccountNo='"+transactionRequest.getSenderWalletAccountNo()+"' to AccountNo='"+transactionRequest.getReceiverWalletAccountNo()+"' ");
    	   	    	resObj.setTransactiontId(transactionNo);
    	   	    	resObj.setNewBalance(senderAccountNoObj.getBalance()-transactionRequest.getTransferredAmount());
    	   	    	resObj.setTransactionDate(transactionObj.getTransactionDate());
    	   	    	
    	   	    	/* Updating balance for sender */
    	   	    	senderAccountNoObj.setBalance(senderAccountNoObj.getBalance()-transactionRequest.getTransferredAmount());
    	   	    	sessionFactory.getCurrentSession().update(senderAccountNoObj); 
    	   	    	/* Updating balance for receiver */
    	   	    	receiverAccountNoObj.setBalance(receiverAccountNoObj.getBalance()+transactionRequest.getTransferredAmount());
    	   	    	sessionFactory.getCurrentSession().update(receiverAccountNoObj); 
    	   	    	
    	   	    	
    	   			 
        		}else {
        		
            		resObj.setMessages("Receiver Account_No not found !");
        			return resObj;
        		}
			
    		}else {
				resObj.setMessages("Enter transfer amount is greater than the available balance, try again with other amount !");
				return resObj;
			}
 
    	}else {
    		
			resObj.setMessages("Incorect Password, try again !");
			return resObj;
    	}
    		
    	}else {
    		
    		resObj.setMessages("Sender Account_No not found !");

    	}
    	
    	}else {
    	
    		resObj.setMessages("Sender Account_No and Receiver account_No should be different !");
    		
    	}
		return resObj;
    	
    	
    }
    
    
    @Transactional
	public List<TransactionListResponse> findAllTransactions(){
		
		List<TransactionListResponse> allTransactionResponse=new ArrayList<TransactionListResponse>();;;
    	List<Transaction> allTransaction= (List<Transaction>)sessionFactory.getCurrentSession().createQuery("from Transaction").list();
    	
    	if(allTransaction != null) {
    		
    		for (Transaction transactionObj : allTransaction) {
    			TransactionListResponse responseObj = new TransactionListResponse();
    			
    			responseObj.setTransactionNo(transactionObj.getTransactiontId());
    			responseObj.setSenderWalletAccountNo(transactionObj.getSenderWalletAccountNo().getWalletAccountNo());
    			responseObj.setSenderCustomerNames(transactionObj.getSenderWalletAccountNo().getCustomerObj().getNames());
    			responseObj.setReceiverWalletAccountNo(transactionObj.getReceiverWalletAccountNo().getWalletAccountNo());
    			responseObj.setReceiverCustomerNames(transactionObj.getReceiverWalletAccountNo().getCustomerObj().getNames());
    			responseObj.setTransferredAmount(transactionObj.getTransferredAmount());

    	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    	        
    			responseObj.setTransactionDate(dateFormat.format(transactionObj.getTransactionDate())); /* Date is formated in yyyy-MM-dd HH:mm:ss */
    			allTransactionResponse.add(responseObj);
    		}
    		
    	}
    	
		return allTransactionResponse;
	}

}
