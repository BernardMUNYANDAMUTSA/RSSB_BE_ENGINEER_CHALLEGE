package com.tekana.ewallet.model;

import java.util.Date;

public class Transaction {
	
    private Long transactiontId;
    private Wallet senderWalletAccountNo;
    private Wallet receiverWalletAccountNo;
    private Double transferredAmount;
    private Date transactionDate;
    
    
	public Long getTransactiontId() {
		return transactiontId;
	}
	public void setTransactiontId(Long transactiontId) {
		this.transactiontId = transactiontId;
	}
	public Wallet getSenderWalletAccountNo() {
		return senderWalletAccountNo;
	}
	public void setSenderWalletAccountNo(Wallet senderWalletAccountNo) {
		this.senderWalletAccountNo = senderWalletAccountNo;
	}
	public Wallet getReceiverWalletAccountNo() {
		return receiverWalletAccountNo;
	}
	public void setReceiverWalletAccountNo(Wallet receiverWalletAccountNo) {
		this.receiverWalletAccountNo = receiverWalletAccountNo;
	}
	public Double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(Double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
    
	

}
