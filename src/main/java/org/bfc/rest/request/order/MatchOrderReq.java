package org.bfc.rest.request.order;

import java.time.LocalDate;
import lombok.Getter;
import org.bfc.domain.OrderStatus;
import org.bfc.domain.Side;
import org.bfc.rest.request.BfcRequest;

@Getter
public class MatchOrderReq extends BfcRequest {

    Long buyOrderId;
    Long sellOrderId;

}
