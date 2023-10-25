package com.tekana.ewallet.model;

import java.util.Date;

public class TransactionResponse {
	
    private String messages;
	private Long transactiontId;
    private Double newBalance;
    private Date transactionDate;
    
	public Long getTransactiontId() {
		return transactiontId;
	}
	public void setTransactiontId(Long transactiontId) {
		this.transactiontId = transactiontId;
	}
	public Double getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(Double newBalance) {
		this.newBalance = newBalance;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
    
    

}
