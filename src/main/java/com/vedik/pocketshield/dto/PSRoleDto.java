package com.vedik.pocketshield.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PSRoleDto {

    private int id;

    @NotEmpty(message = "Role Name cannot be Empty")
    private String roleName;
}
