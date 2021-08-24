package com.security.domain;

import lombok.*;

@Builder
@ToString
@Getter
@EqualsAndHashCode
public class PasswordEntity {

    private final String password;
    private final boolean isValid;

}
