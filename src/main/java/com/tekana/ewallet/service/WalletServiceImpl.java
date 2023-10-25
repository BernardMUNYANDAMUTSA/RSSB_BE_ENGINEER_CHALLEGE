package com.tekana.ewallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekana.ewallet.dao.WalletDao;
import com.tekana.ewallet.model.WalletRequest;
import com.tekana.ewallet.model.WalletResponse;
import com.tekana.ewallet.model.Wallet_Customer_Response;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletDao walletDao;
	
    @Override
    public WalletResponse createWallet(WalletRequest walletRequest) {    	
    	return walletDao.createWallet(walletRequest);
    	
    }
    @Override
	public List<Wallet_Customer_Response> findAllWallets(){
			
		return walletDao.findAllWallets();
	}

}
