package com.tekana.ewallet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekana.ewallet.dao.CustomerDao;
import com.tekana.ewallet.model.CustomerRequest;
import com.tekana.ewallet.model.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
    	
        return customerDao.createCustomer(customerRequest);
    }


    @Override
    public Object getCustomerById(Long customerId) {
   	
    	return customerDao.getCustomerById(customerId);
    } 
    
    @Override
	public List<CustomerResponse> findAllCustomers(){
		
		return customerDao.findAllCustomers();
	}
    
}
