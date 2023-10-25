package com.tekana.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tekana.ewallet.model.CustomerRequest;
import com.tekana.ewallet.model.CustomerResponse;
import com.tekana.ewallet.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
    private  CustomerService customerService;

    @PostMapping("/recordNewCustomer")
    private ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @GetMapping("/getCustomerById/{customerId}")
    private ResponseEntity<Object> getCustomerById(@PathVariable("customerId") long customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    } 
    
    @GetMapping("/all_Customers")
    public List<CustomerResponse> getAllCustomers() {
    	return customerService.findAllCustomers();
    }
    
}
