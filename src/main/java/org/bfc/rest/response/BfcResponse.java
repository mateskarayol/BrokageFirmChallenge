package org.bfc.rest.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BfcResponse<T> {

    private T body;
    private List<T> bodyList;
    private String message;

    public BfcResponse(T body) {
        this.body = body;
        this.message = message;
    }

    public BfcResponse(List<T> bodyList) {
        this.bodyList = bodyList;
    }
}
