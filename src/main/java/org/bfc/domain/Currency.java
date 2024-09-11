package org.bfc.domain;

public enum Currency {

    TL(1);
    private final Integer id;

    private Currency(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
