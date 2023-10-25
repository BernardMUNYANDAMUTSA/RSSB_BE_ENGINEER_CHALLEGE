package com.tekana.ewallet.service;

import com.tekana.ewallet.model.WalletResponse;
import com.tekana.ewallet.model.Wallet_Customer_Response;

import java.util.List;

import com.tekana.ewallet.model.WalletRequest;

public interface WalletService {
	WalletResponse createWallet(WalletRequest walletRequest);
	List<Wallet_Customer_Response> findAllWallets();
}
