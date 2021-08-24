package com.security.usecase;

import com.security.domain.exception.PasswordException;
import com.security.usecase.validatordefault.ValidatorDefaultImpl;
import com.security.usecase.validatordefault.ValidatorDefaultRequest;
import com.security.usecase.validatordefault.ValidatorDefaultResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidatorDefaultImplTest {

    @InjectMocks
    private ValidatorDefaultImpl validatorDefaultImpl;

    @Test
    void whenExecuteUseCaseWithSuccess() {
        var request = fakeBuilderRequestDefault()
                .password("tes#%2XC7")
                .build();
        var response = validatorDefaultImpl.execute(request);
        assertThat(response).isEqualTo(ValidatorDefaultResponse.builder().passwordIsValid(true).build());
    }

    @Test
    void whenExecuteUseCaseWithFailure() {
        var request = fakeBuilderRequestDefault()
                .password("tes#%2XCe")
                .build();
        assertThatThrownBy(() -> validatorDefaultImpl.execute(request))
                .hasMessageStartingWith("The password");
    }

    private ValidatorDefaultRequest.ValidatorDefaultRequestBuilder fakeBuilderRequestDefault() {
        return ValidatorDefaultRequest.builder();
    }
}
