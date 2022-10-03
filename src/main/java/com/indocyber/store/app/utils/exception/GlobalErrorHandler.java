package com.indocyber.store.app.utils.exception;

import com.indocyber.store.app.utils.model.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.persistence.NoResultException;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<ResponseWrapper<?>> noResultException(NoResultException ex) {
        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK, ex.getMessage(), null));
    }

    @ExceptionHandler(NullParameterException.class)
    public ResponseEntity<ResponseWrapper<?>> noArgsException(NullParameterException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(HttpStatus.BAD_REQUEST, ex.getMessage(), null));
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<ResponseWrapper<?>> duplicateException(DuplicateDataException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(HttpStatus.BAD_REQUEST, ex.getMessage(), null));
    }

    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<ResponseWrapper<?>> operationFailedException(OperationFailedException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null));
    }
}
