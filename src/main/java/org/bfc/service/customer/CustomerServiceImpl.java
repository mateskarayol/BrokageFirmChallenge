package org.bfc.service.customer;

import org.bfc.entity.Customer;
import org.bfc.exception.CustomerServiceException;
import org.bfc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Long depositAmount(Long customerId, Long amount) {
        Customer cust = customerRepository.findById(customerId).get();
        cust.setDepositAmount(cust.getDepositAmount() + amount);
        cust = customerRepository.save(cust);
        return cust.getDepositAmount();
    }

    @Override
    public Long withdrawAmount(Long customerId, Long amount) {
        Customer cust = customerRepository.findById(customerId).get();

        if(amount > cust.getDepositAmount()){
            throw new CustomerServiceException("Customer deposit is not available to withdraw this amount.");
        }

        cust.setDepositAmount(cust.getDepositAmount() - amount);
        cust = customerRepository.save(cust);
        return cust.getDepositAmount();
    }

    @Override
    public Customer getCustomerByCustomerId(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
}
