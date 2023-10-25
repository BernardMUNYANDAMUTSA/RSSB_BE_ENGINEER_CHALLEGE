package com.tekana.ewallet.model;

public class TransactionListResponse {

	private Long transactionNo;	
    private Long senderWalletAccountNo;
	private String senderCustomerNames;
    private Long receiverWalletAccountNo;
	private String receiverCustomerNames;
    private Double transferredAmount;
    private String transactionDate; /* String datatype to be able formatting date in this format: yyyy-MM-dd HH:mm:ss */
    
	public Long getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Long getSenderWalletAccountNo() {
		return senderWalletAccountNo;
	}
	public void setSenderWalletAccountNo(Long senderWalletAccountNo) {
		this.senderWalletAccountNo = senderWalletAccountNo;
	}
	public String getSenderCustomerNames() {
		return senderCustomerNames;
	}
	public void setSenderCustomerNames(String senderCustomerNames) {
		this.senderCustomerNames = senderCustomerNames;
	}
	public Long getReceiverWalletAccountNo() {
		return receiverWalletAccountNo;
	}
	public void setReceiverWalletAccountNo(Long receiverWalletAccountNo) {
		this.receiverWalletAccountNo = receiverWalletAccountNo;
	}
	public String getReceiverCustomerNames() {
		return receiverCustomerNames;
	}
	public void setReceiverCustomerNames(String receiverCustomerNames) {
		this.receiverCustomerNames = receiverCustomerNames;
	}
	public Double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(Double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

    
}
