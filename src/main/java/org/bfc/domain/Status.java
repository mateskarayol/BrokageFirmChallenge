package org.bfc.domain;

public enum Status {

    SUCCESS(1),
    FAIL(2);

    private final Integer id;

    private Status(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
