package org.bfc.service.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bfc.domain.OrderDTO;
import org.bfc.domain.OrderStatus;
import org.bfc.domain.Side;
import org.bfc.entity.Asset;
import org.bfc.entity.Customer;
import org.bfc.entity.Order;
import org.bfc.exception.OrderCreationException;
import org.bfc.repository.AssetRepository;
import org.bfc.repository.CustomerRepository;
import org.bfc.repository.OrderRepository;
import org.bfc.rest.request.order.CreateOrderReq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AssetRepository assetRepository;

    @Override
    public OrderDTO createOrder(CreateOrderReq request) {

        Order order = new Order();

        OrderDTO orderDTO = null;

        Customer customer = customerRepository.findById(request.getCustomerId()).get();

        if (customer.getDepositAmount() > request.getPrice()) {
            Asset asset = assetRepository.findById(request.getAssetId()).get();
            if (asset.getUsableSize() > request.getSize()) {
                order.setCustomer(customer);

                order.setStatus(OrderStatus.PENDING);
                order.setSide(request.getOrderSide());
                order.setSize(request.getSize());
                order.setPrice(request.getPrice());
                order.setAsset(asset);
                order.setCreateDate(LocalDate.now());

                order = orderRepository.save(order);

                customer.setDepositAmount(customer.getDepositAmount() - order.getPrice());
                customerRepository.save(customer);

                asset.setUsableSize(asset.getUsableSize() - order.getSize());
                assetRepository.save(asset);

                orderDTO = modelMapper.map(order, OrderDTO.class);
            } else {
                throw new OrderCreationException("Order size must be lower than asset's usable size.");
            }
        } else {
            throw new OrderCreationException("Customer deposit amount must be greater than order price.");
        }

        return orderDTO;
    }

    @Override
    public List<OrderDTO> listOrders() {
        Iterable<Order> orderIterable = orderRepository.findAll();
        Iterator<Order> it = orderIterable.iterator();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        while (it.hasNext()) {
            orderDTOList.add(modelMapper.map(it.next(), OrderDTO.class));
        }

        return orderDTOList;
    }

    @Override
    public OrderDTO deleteOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).get();

        if (OrderStatus.PENDING.equals(order.getStatus())) {
            order.setStatus(OrderStatus.CANCELLED);
            order = orderRepository.save(order);
        }

        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> matchOrders(Long buyOrderId, Long sellOrderId) {

        Order buyOrder = orderRepository.findById(buyOrderId).get();
        Order sellOrder = orderRepository.findById(sellOrderId).get();

        if (OrderStatus.PENDING.equals(buyOrder.getStatus()) && OrderStatus.PENDING.equals(sellOrder.getStatus())) {
            if (Side.BUY.equals(buyOrder.getSide()) && Side.SELL.equals(sellOrder.getSide())) {
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    if (buyOrder.getSize() > sellOrder.getSize()) {
                        buyOrder.setSize(buyOrder.getSize() - sellOrder.getSize());
                        sellOrder.setStatus(OrderStatus.MATCHED);
                    } else if (buyOrder.getSize() < sellOrder.getSize()) {
                        sellOrder.setSize(sellOrder.getSize() - buyOrder.getSize());
                        buyOrder.setStatus(OrderStatus.MATCHED);
                    } else {
                        buyOrder.setStatus(OrderStatus.MATCHED);
                        sellOrder.setStatus(OrderStatus.MATCHED);

                        buyOrder.setSize(0);
                        sellOrder.setSize(0);
                    }
                }
            }
        }

        buyOrder = orderRepository.save(buyOrder);
        sellOrder = orderRepository.save(sellOrder);

        List<OrderDTO> orderDTOList = new ArrayList<>();

        orderDTOList.add(modelMapper.map(buyOrder, OrderDTO.class));
        orderDTOList.add(modelMapper.map(sellOrder, OrderDTO.class));
        return orderDTOList;
    }
}
