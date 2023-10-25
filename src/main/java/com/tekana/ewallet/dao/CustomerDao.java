package com.tekana.ewallet.dao;

import java.util.List;

import com.tekana.ewallet.model.CustomerRequest;
import com.tekana.ewallet.model.CustomerResponse;

public interface CustomerDao {
	
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    Object getCustomerById(Long customerId);
	List<CustomerResponse> findAllCustomers();

}
