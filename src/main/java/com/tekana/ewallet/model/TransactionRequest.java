package com.tekana.ewallet.model;

public class TransactionRequest {

    private Long senderWalletAccountNo;
    private String senderPassword;
    private Long receiverWalletAccountNo;
    private Double transferredAmount;
    
	public Long getSenderWalletAccountNo() {
		return senderWalletAccountNo;
	}
	public void setSenderWalletAccountNo(Long senderWalletAccountNo) {
		this.senderWalletAccountNo = senderWalletAccountNo;
	}
	public String getSenderPassword() {
		return senderPassword;
	}
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	public Long getReceiverWalletAccountNo() {
		return receiverWalletAccountNo;
	}
	public void setReceiverWalletAccountNo(Long receiverWalletAccountNo) {
		this.receiverWalletAccountNo = receiverWalletAccountNo;
	}
	public Double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(Double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
    
    
}
