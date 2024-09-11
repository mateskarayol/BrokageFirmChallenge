package org.bfc.domain;

public enum Side {

    BUY(1), SELL(2);

    private final Integer id;

    private Side(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
