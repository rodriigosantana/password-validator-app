package com.security.adapter.input.controller.mapper;

import com.security.adapter.input.controller.dto.PasswordRequestDto;
import com.security.usecase.validatordefault.ValidatorDefaultResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerPasswordMapperTest {

    private final ControllerPasswordMapper mapper = new ControllerPasswordMapper();

    @Test
    void whenRequestHasDtoThenConvertToUseCase() {
        var request = fakeBuilderDto()
                .password("")
                .build();
        var dto = mapper.toUseCase(request);
        assertThat(dto).isNotNull();
    }

    @Test
    void whenResponseHasUseCaseThenConvertToDto() {
        var request = fakeBuilderResponse()
                .passwordIsValid(true)
                .build();
        var dto = mapper.toResponseDto(request);
        assertThat(dto).isNotNull();
    }

    private PasswordRequestDto.PasswordRequestDtoBuilder fakeBuilderDto() {
        return PasswordRequestDto.builder();
    }

    private ValidatorDefaultResponse.ValidatorDefaultResponseBuilder fakeBuilderResponse() {
        return ValidatorDefaultResponse.builder();
    }

}
