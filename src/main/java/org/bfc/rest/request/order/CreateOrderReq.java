package org.bfc.rest.request.order;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bfc.domain.OrderStatus;
import org.bfc.domain.Side;
import org.bfc.rest.request.BfcRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderReq extends BfcRequest {

    @NotNull(message = "Customer Id cannot be null.")
    Long customerId;

    @NotNull(message = "Asset Id cannot be null.")
    Long assetId;

    @NotNull(message = "Side cannot be null.")
    Side orderSide;

    @NotNull(message = "Order size cannot be null.")
    Integer size;

    @NotNull(message = "Price cannot be null.")
    Long price;
}



