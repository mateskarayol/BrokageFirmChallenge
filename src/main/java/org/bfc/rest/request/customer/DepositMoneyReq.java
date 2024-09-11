package org.bfc.rest.request.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bfc.rest.request.BfcRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositMoneyReq extends BfcRequest {

    @NotNull(message = "Customer Id cannot be null.")
    Long customerId;

    @NotNull(message = "Deposit amount cannot be null.")
    Long depositAmount;

}
