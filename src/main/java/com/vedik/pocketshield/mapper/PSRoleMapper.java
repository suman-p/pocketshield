package com.vedik.pocketshield.mapper;

import com.vedik.pocketshield.dto.PSRoleDto;
import com.vedik.pocketshield.entity.PSRole;

public class PSRoleMapper {

    public static PSRoleDto mapToPSRoleDto(PSRole psRole, PSRoleDto psRoleDto){
        psRoleDto.setRoleName(psRole.getRoleName());
        psRoleDto.setId(psRole.getId());
        return psRoleDto;
    }

    public static PSRole mapToPSRole(PSRoleDto psRoleDto, PSRole psRole){
        psRole.setRoleName(psRoleDto.getRoleName());
        return psRole;
    }
}
