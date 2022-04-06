package com.bestpractices.springdoc.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class User {
    @Schema(description = "Username of user")
    private String username;
    @Schema(description = "Firstname of user")
    private String firstname;
    @Schema(description = "Lastname of user")
    private String lastname;
}
