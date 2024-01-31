package at.ihet.store.electronic.service.catalog.product.shared;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log;

    @Autowired
    GlobalExceptionHandler(Logger log) {
        this.log = log;
    }

    @ExceptionHandler(Throwable.class)
    ResponseEntity<?> internalError(Throwable throwable, WebRequest request) throws Throwable {
        rethrowWhenHandledByFramework(throwable);
        logError(throwable, request);
        return ResponseEntity.internalServerError()
                .contentType(MediaType.TEXT_PLAIN)
                .body("Unable to handle the request");
    }

    void rethrowWhenHandledByFramework(Throwable throwable) throws Throwable {
        if (throwable instanceof ResponseStatusException) {
            throw throwable;
        }
    }

    void logError(Throwable throwable, WebRequest request) {
        log.error("Path: '" + ((ServletWebRequest) request).getRequest().getRequestURI() + "' throw an exception.", throwable);
    }
}
