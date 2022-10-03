package com.indocyber.store.app.utils.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper<T> {

    private int code;

    private String message;

    private List<T> data;

    public ResponseWrapper(HttpStatus status, String message, List<T> data) {
        this.code = status.value();
        this.message = message;
        this.data = data;
    }
}
