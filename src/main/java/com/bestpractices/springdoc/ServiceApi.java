package com.bestpractices.springdoc;

import com.bestpractices.springdoc.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "user", description = "User tag")
public interface ServiceApi {

    @Operation(summary = "CreateUser", description = "Create a new user")
    @Parameter(name = "username", in = ParameterIn.QUERY, required = true, schema = @Schema(type = "string"))
    @Parameter(name = "firstname", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    @Parameter(name = "lastname", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    @PostMapping("/create")
    User createUser(User user);

    @Operation(summary = "GetUser", description = "Get user details by username")
    @Parameter(name = "username", in = ParameterIn.HEADER, required = true, schema = @Schema(type = "string"))
    @GetMapping("/{username}")
    User getUser(String username);

    @Operation(summary = "UpdateUser", description = "Update an existing user by username")
    @Parameter(name = "username", in = ParameterIn.HEADER, required = true, schema = @Schema(type = "string"))
    @Parameter(name = "username", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    @Parameter(name = "firstname", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    @Parameter(name = "lastname", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    @PutMapping("/update/{username}")
    User updateUser(User user);

    @Operation(summary = "DeleteUser", description = "Delete an existing user by username")
    @Parameter(name = "username", in = ParameterIn.HEADER, required = true, schema = @Schema(type = "string"))
    @DeleteMapping("/delete/{username}")
    Boolean deleteUser(String username);

}
