package org.bfc.service.customer;

import org.bfc.entity.Customer;

public interface CustomerService {

    Long depositAmount(Long customerId, Long amount);
    Long withdrawAmount(Long customerId, Long amount);

    Customer getCustomerByCustomerId(Long customerId);
}
