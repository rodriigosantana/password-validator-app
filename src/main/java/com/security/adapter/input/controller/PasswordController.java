package com.security.adapter.input.controller;

import com.security.adapter.input.controller.dto.PasswordRequestDto;
import com.security.adapter.input.controller.dto.PasswordResponseDto;
import com.security.adapter.input.controller.mapper.ControllerPasswordMapper;
import com.security.usecase.validatordefault.ValidatorDefault;
import com.security.usecase.validatordefault.ValidatorDefaultRequest;
import com.security.usecase.validatordefault.ValidatorDefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/validatePassword")
@Produces(MediaType.APPLICATION_JSON)
public class PasswordController {

    private final ValidatorDefaultRequest validatorDefaultRequest;
    private final ValidatorDefaultResponse validatorDefaultResponse;
    private final ControllerPasswordMapper mapper;
    private final ValidatorDefault validatorDefault;

    @Inject
    PasswordController(final ValidatorDefaultRequest validatorDefaultRequest
                       ,final ValidatorDefaultResponse validatorDefaultResponse
                       ,final ControllerPasswordMapper mapper
                       ,final ValidatorDefault validatorDefault){
        this.validatorDefaultRequest = validatorDefaultRequest;
        this.validatorDefaultResponse = validatorDefaultResponse;
        this.mapper = mapper;
        this.validatorDefault = validatorDefault;
    }

    @Operation(summary = "Validate Password",
            responses = {
                    @ApiResponse(description = "Response if the password is valid!",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = PasswordResponseDto.class))))
            })
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validatePassword(@Valid final PasswordRequestDto passwordRequest) {

        var request = mapper.toUseCase(passwordRequest);
        var response = mapper.toResponseDto(
                validatorDefault.execute(request));
        return Response.ok(response).build();

    }
}
