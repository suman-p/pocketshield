package com.vedik.pocketshield.service;

import com.vedik.pocketshield.dto.PSRoleDto;

import java.util.List;

public interface IPSRoleService {
    void createRole(PSRoleDto psRoleDto);

    List<PSRoleDto> getRoles();

    PSRoleDto getRole(int role_id);

    void deleteRole(int role_id);

    void updateRole(PSRoleDto psRoleDto);
}
