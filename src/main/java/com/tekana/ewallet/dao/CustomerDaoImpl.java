package com.tekana.ewallet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tekana.ewallet.config.MD5PasswordEncryption;
import com.tekana.ewallet.model.Customer;
import com.tekana.ewallet.model.CustomerRequest;
import com.tekana.ewallet.model.CustomerResponse;
import com.tekana.ewallet.model.ErrorResponse;

public class CustomerDaoImpl implements CustomerDao{
	
	private final SessionFactory sessionFactory;
	public CustomerDaoImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    private CustomerResponse getCustomerResponseObj(Customer customerObj) {
    	
    	CustomerResponse customerResObj=new CustomerResponse();
    	if(customerObj !=null) {
    	customerResObj.setMessage("New customer recorded successfully !");
    	customerResObj.setCustomer_id(customerObj.getId()); 
    	customerResObj.setNames(customerObj.getNames());
    	customerResObj.setEmail(customerObj.getEmail());
    	customerResObj.setEncryptedPassword(customerObj.getPassword());
    	}else {
    		customerResObj.setMessage("Error occured, Entered email already exit, try again with another email !");
    	}
    	return customerResObj;
    }
    @Override
	@Transactional
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
    	
    	/* check if the email is already exist*/
    	Customer custObj=(Customer)sessionFactory.getCurrentSession().createQuery("from Customer where email='"+customerRequest.getEmail()+"'").uniqueResult();       
    	if(custObj != null) {
   		
    		return getCustomerResponseObj(null);
    	}
    	Customer customerObj=new Customer();
    	customerObj.setNames(customerRequest.getNames());
    	customerObj.setEmail(customerRequest.getEmail());
    	String encryptedPassword = MD5PasswordEncryption.encryptPassword(customerRequest.getPassword());
    	customerObj.setPassword(encryptedPassword);
    	Long customerId=(Long) sessionFactory.getCurrentSession().save(customerObj);        	
    	customerObj.setId(customerId);  /* Getting created customer id into customer object */
    	
        return getCustomerResponseObj(customerObj);
    }


    @Override
	@Transactional
    public Object getCustomerById(Long customerId) {
   	
    	Customer custObj=(Customer)sessionFactory.getCurrentSession().createQuery("from Customer where id='"+customerId+"'").uniqueResult();       
    	if (custObj!=null) {
    		return custObj;
    	}else {
    		ErrorResponse errObj=new ErrorResponse();
    		errObj.setErrorMsg("Please, customer with ID='"+customerId+"' not found !");
    		return errObj;
    	}
    	
    } 
    
    @Transactional
	public List<CustomerResponse> findAllCustomers(){
		
		List<CustomerResponse> allCustomersResponse=new ArrayList<CustomerResponse>();;;
    	List<Customer> allCustomers= (List<Customer>)sessionFactory.getCurrentSession().createQuery("from Customer").list();
    	
    	if(allCustomers != null) {
    		
    		for (Customer customerObj : allCustomers) {
    			CustomerResponse responseObj = new CustomerResponse();
    			
    			responseObj.setCustomer_id(customerObj.getId());
    			responseObj.setNames(customerObj.getNames());
    			responseObj.setEmail(customerObj.getEmail());
    			responseObj.setEncryptedPassword(customerObj.getPassword());
    			allCustomersResponse.add(responseObj);
    		}
    		
    	}
    	
		return allCustomersResponse;
	}
    

}
