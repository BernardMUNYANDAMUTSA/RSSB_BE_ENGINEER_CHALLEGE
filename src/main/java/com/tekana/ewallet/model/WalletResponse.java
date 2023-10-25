package com.tekana.ewallet.model;

public class WalletResponse {
	
    private String message;
	private Long walletAccountNo;
    private Double balance;
	public Long getWalletAccountNo() {
		return walletAccountNo;
	}
	public void setWalletAccountNo(Long walletAccountNo) {
		this.walletAccountNo = walletAccountNo;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
