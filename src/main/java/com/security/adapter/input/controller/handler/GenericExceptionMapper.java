package com.security.adapter.input.controller.handler;

import com.security.adapter.input.controller.dto.ApiErrorResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(ApiErrorResponse.builder().message(e.getMessage())
                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)).build())
                .build();
    }

}








//
//import com.security.adapter.input.controller.dto.ApiErrorResponse;
//import com.security.domain.exception.PasswordExceptionEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import javax.validation.ConstraintViolationException;
//import java.time.OffsetDateTime;
//import java.time.format.DateTimeFormatter;
//
//@ControllerAdvice
//public class RestControllerErrorHandler {
//
//    @ExceptionHandler(value = {PasswordExceptionEntity.class, ConstraintViolationException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    protected ApiErrorResponse passwordInvalid(final Exception rtex) {
//        //log
//
//        return ApiErrorResponse.builder()
//                .message(rtex.getLocalizedMessage())
//                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
//                .build();
//    }
//
//    @ExceptionHandler(value = {Exception.class, MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected ApiErrorResponse notExpectedException(final Exception ex,
//                                                    final WebRequest request){
//        //log
//
//        return ApiErrorResponse.builder()
//                .message(ex.getLocalizedMessage())
//                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
//                .build();
//    }
//
//}
