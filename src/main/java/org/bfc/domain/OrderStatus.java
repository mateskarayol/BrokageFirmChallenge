package org.bfc.domain;

public enum OrderStatus {

    PENDING(1), MATCHED(2), CANCELLED(3);

    private final int id;

    private OrderStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
