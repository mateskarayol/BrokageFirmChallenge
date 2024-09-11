package org.bfc.rest.order;

import jakarta.validation.Valid;
import java.util.List;
import org.bfc.domain.OrderDTO;
import org.bfc.rest.request.order.CreateOrderReq;
import org.bfc.rest.response.BfcResponse;
import org.bfc.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/api/v1/order/listOrders")
    public ResponseEntity listOrders() {
        List<OrderDTO> orderDTOList = orderService.listOrders();
        return new ResponseEntity<>(new BfcResponse(orderDTOList), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order/createOrder")
    public ResponseEntity createOrder(@RequestBody @Valid CreateOrderReq request) {
        OrderDTO orderDTO = orderService.createOrder(request);
        return new ResponseEntity<>(new BfcResponse(orderDTO), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order/deleteOrder")
    public ResponseEntity deleteOrder(@RequestParam Long orderId) {
        OrderDTO orderDTO = orderService.deleteOrder(orderId);
        return new ResponseEntity<>(new BfcResponse(orderDTO), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order/matchOrders")
    public ResponseEntity matchOrders(@RequestParam Long buyOrderId, @RequestParam Long sellOrderId) {
        List<OrderDTO> orderDTOList = orderService.matchOrders(buyOrderId, sellOrderId);
        return new ResponseEntity<>(new BfcResponse(orderDTOList), HttpStatus.OK);
    }
}
