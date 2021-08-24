package com.security.adapter.input.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListApiErrorResponse {

    private List<ErrorResponse> errors;
    private String timestamp;

}
