package com.vedik.pocketshield.dto;

import com.vedik.pocketshield.entity.PSRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PSUserDto {

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Size(min = 8, message = "Password must be atleast 8 characters")
    @Pattern(regexp = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain atleast " +
            "one special character, one Uppercase letter")
    private String password;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    private String phoneNumber;

    @NotEmpty(message = "Role cannot be empty")
    private PSRole role;
}
