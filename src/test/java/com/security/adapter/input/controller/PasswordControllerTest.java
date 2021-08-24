package com.security.adapter.input.controller;

import com.security.adapter.input.controller.dto.PasswordRequestDto;
import com.security.adapter.input.controller.mapper.ControllerPasswordMapper;
import com.security.domain.exception.PasswordException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PasswordControllerTest {

//    public static final PasswordRequestDto REQUEST_DTO_OK = PasswordRequestDto.builder()
//            .password("esyo@3$S%")
//            .build();
//
//    @InjectMocks
//    private PasswordController controller;
//
//    @Spy
//    private final ControllerPasswordMapper mapper = new ControllerPasswordMapper();
//
//    @Test
//    void processValidate200() throws PasswordException {
//        var response = controller.validatePassword(REQUEST_DTO_OK);
//        assertThat(response.getStatus()).isEqualTo(200);
//        verify(mapper, never()).toResponseDto(any());
//        verify(mapper, never()).toUseCase(any());
//    }

}
