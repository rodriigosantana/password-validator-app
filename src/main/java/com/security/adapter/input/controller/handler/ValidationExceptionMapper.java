package com.security.adapter.input.controller.handler;

import com.security.adapter.input.controller.dto.ErrorResponse;
import com.security.adapter.input.controller.dto.ListApiErrorResponse;
import com.security.domain.exception.PasswordException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException e) {
        List<ErrorResponse> list = new ArrayList<ErrorResponse>();
        for (ConstraintViolation cv : e.getConstraintViolations()) {
            list.add(ErrorResponse.builder()
                    .path(cv.getPropertyPath().toString())
                    .message(cv.getMessage())
                    .build());
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(ListApiErrorResponse.builder().errors(list)
                        .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)).build())
                .build();
    }

}
