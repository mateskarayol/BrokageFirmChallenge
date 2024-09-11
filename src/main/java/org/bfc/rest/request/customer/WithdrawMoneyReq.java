package org.bfc.rest.request.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bfc.rest.request.BfcRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawMoneyReq extends BfcRequest {

    @NotNull(message = "Customer Id cannot be null.")
    Long customerId;

    @NotNull(message = "Withdraw amount cannot be null.")
    Long withdrawAmount;

}
