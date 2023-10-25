package com.tekana.ewallet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tekana.ewallet.model.WalletRequest;
import com.tekana.ewallet.model.WalletResponse;
import com.tekana.ewallet.model.Wallet_Customer_Response;
import com.tekana.ewallet.service.WalletService;


@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
    private  WalletService walletService;
	
    @PostMapping("/recordNewWallet")
    private ResponseEntity<WalletResponse> createWallet(@RequestBody WalletRequest walletRequest){
    	return ResponseEntity.ok(walletService.createWallet(walletRequest));
    }
    
    @GetMapping("/all_Wallets")
    public List<Wallet_Customer_Response> getAllWallets() {
    	return walletService.findAllWallets();
    }

}
