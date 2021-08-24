package com.security.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PasswordEntityTest {

    @Test
    void shouldReturnEmptyPasswordWhenObjectWasCreatedWithoutThat() {
        var builder = PasswordEntity.builder()
                .password("");

        assertThat(builder.build().getPassword())
                .isEqualTo("");
    }

    @Test
    void shouldReturnNullPasswordWhenObjectWasCreatedWithoutThat() {
        var builder = PasswordEntity.builder();

        assertThat(builder.build().getPassword())
                .isNull();
    }
}
