package com.tekana.ewallet.service;

import java.util.List;
import com.tekana.ewallet.model.CustomerRequest;
import com.tekana.ewallet.model.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    Object getCustomerById(Long customerId);
	List<CustomerResponse> findAllCustomers();
}
