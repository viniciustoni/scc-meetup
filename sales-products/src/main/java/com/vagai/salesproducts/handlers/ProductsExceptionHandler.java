package com.vagai.salesproducts.handlers;

import com.vagai.salesproducts.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ProductsExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSomeEntityNotFoundException(final HttpServletRequest request, final Throwable exception) {
        final Map<String, Object> error = new HashMap<>();
        error.put("timestamp", ZonedDateTime.now(ZoneId.of("UTC")).toOffsetDateTime().toString());
        error.put("status", NOT_FOUND.value());
        error.put("error", NOT_FOUND.getReasonPhrase());
        error.put("message", exception.getMessage());
        error.put("path", request.getRequestURI());

        return new ResponseEntity<>(error, NOT_FOUND);
    }

}
