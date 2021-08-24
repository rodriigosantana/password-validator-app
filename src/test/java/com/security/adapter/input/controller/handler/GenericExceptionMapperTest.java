package com.security.adapter.input.controller.handler;

import com.security.adapter.input.controller.dto.ApiErrorResponse;
import com.security.adapter.input.controller.mapper.ControllerPasswordMapper;
import com.security.domain.exception.PasswordException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericExceptionMapperTest {

    @Test
    void whenReturnErrorThenCreateResponse() {
        var mapper = new GenericExceptionMapper();
        var response = mapper.toResponse(new Exception("Error"));
        assertThat(response.getStatus()).isEqualTo(400);
        assertThat(response.getEntity()).isNotNull();
    }
}
