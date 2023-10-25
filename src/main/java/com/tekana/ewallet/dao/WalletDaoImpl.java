package com.tekana.ewallet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tekana.ewallet.model.Customer;
import com.tekana.ewallet.model.Wallet;
import com.tekana.ewallet.model.WalletRequest;
import com.tekana.ewallet.model.WalletResponse;
import com.tekana.ewallet.model.Wallet_Customer_Response;

public class WalletDaoImpl implements WalletDao{
	
	private final SessionFactory sessionFactory;
	public WalletDaoImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

    @Transactional
    public WalletResponse createWallet(WalletRequest walletRequest) {

    	Wallet walletObj=new Wallet();
    	walletObj.setWalletType(walletRequest.getWalletType());
    	walletObj.setBalance(walletRequest.getBalance());
    	Customer custObj= (Customer)sessionFactory.getCurrentSession().createQuery("from Customer where id='"+walletRequest.getCustomerId()+"'").uniqueResult();   	    	
    	WalletResponse resObj=new WalletResponse();
    	if(custObj !=null) {        
    	walletObj.setCustomerObj(custObj);
    	Long walletAccountNo=(Long) sessionFactory.getCurrentSession().save(walletObj);    	
    	resObj.setMessage("Wallet created successfully");
    	resObj.setWalletAccountNo(walletAccountNo);
    	resObj.setBalance(walletRequest.getBalance());
    	
    	}else {
    		
    		resObj.setMessage("Please, customer with ID='"+walletRequest.getCustomerId()+"' does not exist !");

    	}
    	
    	return resObj;
    	
    }
    
    @Transactional
	public List<Wallet_Customer_Response> findAllWallets(){
		
		List<Wallet_Customer_Response> allWalletResponse=new ArrayList<Wallet_Customer_Response>();;;
    	List<Wallet> allWallet= (List<Wallet>)sessionFactory.getCurrentSession().createQuery("from Wallet").list();
    	
    	if(allWallet != null) {
    		
    		for (Wallet walletObj : allWallet) {
    			Wallet_Customer_Response responseObj = new Wallet_Customer_Response();
    			responseObj.setWalletAccountNo(walletObj.getWalletAccountNo().toString());
    			responseObj.setCustomerNames(walletObj.getCustomerObj().getNames());
    			responseObj.setWalletType(walletObj.getWalletType());
    			responseObj.setBalance(walletObj.getBalance());
    			
    			allWalletResponse.add(responseObj);
    		}
    		
    	}
    	
		return allWalletResponse;
	}

}
