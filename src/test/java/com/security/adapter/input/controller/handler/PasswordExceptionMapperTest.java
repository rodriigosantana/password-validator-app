package com.security.adapter.input.controller.handler;

import com.security.adapter.input.controller.dto.ApiErrorResponse;
import com.security.domain.exception.PasswordException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordExceptionMapperTest {

    @Test
    void whenReturnErrorThenCreateResponse() {
        var mapper = new PasswordExceptionMapper();
        var response = mapper.toResponse(new PasswordException("Error"));
        assertThat(response.getStatus()).isEqualTo(400);
        assertThat(response.getEntity()).isNotNull();
    }
}
