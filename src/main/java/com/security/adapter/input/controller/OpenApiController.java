package com.security.adapter.input.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

import java.io.InputStream;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/v1/openapi")
@Produces(MediaType.APPLICATION_JSON)
@OpenAPIDefinition(
        info = @Info(
                title = "Sample API",
                version = "1",
                description = "Sample API"
        )
)
public class OpenApiController {

    @GET
    @Operation(hidden = true)
    public InputStream openApi() {
        return OpenApiController.class.getResourceAsStream("openapi.json");
    }
}