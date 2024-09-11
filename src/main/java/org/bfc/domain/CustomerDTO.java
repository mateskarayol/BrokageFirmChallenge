package org.bfc.domain;


import java.util.Set;

public class CustomerDTO {

    private Long customerId;

    private Long depositAmount;

    private Currency currency;

    private Set<OrderDTO> orders;

}
