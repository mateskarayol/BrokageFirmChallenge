package org.bfc.rest.customer;

import jakarta.validation.Valid;
import org.bfc.rest.request.customer.DepositMoneyReq;
import org.bfc.rest.request.customer.WithdrawMoneyReq;
import org.bfc.rest.response.BfcResponse;
import org.bfc.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/api/v1/customer/depositMoney")
    public ResponseEntity depositMoney(@RequestBody @Valid DepositMoneyReq request) {
        Long updatedValue = customerService.depositAmount(request.getCustomerId(), request.getDepositAmount());
        return new ResponseEntity<>(new BfcResponse(updatedValue), HttpStatus.OK);
    }

    @PostMapping("/api/v1/customer/withdrawMoney")
    public ResponseEntity withdrawMoney(@RequestBody @Valid WithdrawMoneyReq request) {
        Long updatedValue = customerService.withdrawAmount(request.getCustomerId(), request.getWithdrawAmount());
        return new ResponseEntity<>(new BfcResponse(updatedValue), HttpStatus.OK);
    }
}
