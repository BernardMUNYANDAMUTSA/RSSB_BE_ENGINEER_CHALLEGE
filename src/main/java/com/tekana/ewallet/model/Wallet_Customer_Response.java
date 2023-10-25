package com.tekana.ewallet.model;

public class Wallet_Customer_Response {
	
	private String walletAccountNo;
	private String customerNames;
    private String walletType;
	private Double balance;
	
	public String getWalletAccountNo() {
		return walletAccountNo;
	}
	public void setWalletAccountNo(String walletAccountNo) {
		this.walletAccountNo = walletAccountNo;
	}

	public String getCustomerNames() {
		return customerNames;
	}
	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
	}
	public String getWalletType() {
		return walletType;
	}
	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}
