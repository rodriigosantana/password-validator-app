package com.security.adapter.input.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRequestDto {

    @NotBlank(message = "Password can't be null.")
    private String password;
}
