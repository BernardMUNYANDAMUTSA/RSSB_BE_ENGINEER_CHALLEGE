package com.tekana.ewallet.dao;

import java.util.List;

import com.tekana.ewallet.model.WalletRequest;
import com.tekana.ewallet.model.WalletResponse;
import com.tekana.ewallet.model.Wallet_Customer_Response;

public interface WalletDao {
	
	WalletResponse createWallet(WalletRequest walletRequest);
	List<Wallet_Customer_Response> findAllWallets();

}
