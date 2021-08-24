package com.security.adapter.input.controller.mapper;

import com.security.adapter.input.controller.dto.PasswordRequestDto;
import com.security.adapter.input.controller.dto.PasswordResponseDto;
import com.security.domain.PasswordEntity;
import com.security.usecase.validatordefault.ValidatorDefaultRequest;
import com.security.usecase.validatordefault.ValidatorDefaultResponse;
import lombok.AllArgsConstructor;

//import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
//@ApplicationScoped
@AllArgsConstructor
public class ControllerPasswordMapper {

    public ValidatorDefaultRequest toUseCase(final PasswordRequestDto request) {
        return ValidatorDefaultRequest.builder()
                .password(request.getPassword())
                .build();
    }

    public PasswordResponseDto toResponseDto(final ValidatorDefaultResponse response) {
        return PasswordResponseDto.builder()
                .passwordIsValid(response.isPasswordIsValid())
                .build();
    }
}
