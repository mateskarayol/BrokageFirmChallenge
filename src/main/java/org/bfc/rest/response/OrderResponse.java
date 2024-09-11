package org.bfc.rest.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bfc.entity.Order;

@Getter
@Setter
public class OrderResponse {

    Integer orderId;

    List<Order> orderList;

}
