package com.tekana.ewallet.model;

public class Wallet {
	
    private Long walletAccountNo;
    private String walletType; /* 'saving' | 'personal' | 'loan' */
    private Double balance;
    private Customer customerObj;
    
	public Long getWalletAccountNo() {
		return walletAccountNo;
	}
	public void setWalletAccountNo(Long walletAccountNo) {
		this.walletAccountNo = walletAccountNo;
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
	public Customer getCustomerObj() {
		return customerObj;
	}
	public void setCustomerObj(Customer customerObj) {
		this.customerObj = customerObj;
	}

    
    
   
}
