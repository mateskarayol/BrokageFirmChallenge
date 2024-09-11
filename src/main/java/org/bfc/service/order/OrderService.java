package org.bfc.service.order;

import java.util.List;
import org.bfc.domain.OrderDTO;
import org.bfc.entity.Order;
import org.bfc.rest.request.order.CreateOrderReq;

public interface OrderService {

    OrderDTO createOrder(CreateOrderReq request);

    List<OrderDTO> listOrders();

    OrderDTO deleteOrder(Long orderId);

    List<OrderDTO> matchOrders(Long buyOrderId, Long sellOrderId);
}
