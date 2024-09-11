package org.bfc.domain;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long orderId;

    private Long customerId;

    private Long assetId;

    private Integer size;

    private Long price;

    private Side side;

    private OrderStatus status;

    LocalDate createDate;

}
