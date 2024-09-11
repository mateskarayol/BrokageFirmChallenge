package org.bfc.domain;

public enum RecordStatus {

    ACTIVE(1),
    DELETED(2);

    private final Integer id;

    private RecordStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
