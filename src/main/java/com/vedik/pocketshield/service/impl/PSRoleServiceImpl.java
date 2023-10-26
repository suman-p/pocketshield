package com.vedik.pocketshield.service.impl;

import com.vedik.pocketshield.dto.PSRoleDto;
import com.vedik.pocketshield.entity.PSRole;
import com.vedik.pocketshield.exception.ResourceNotFoundException;
import com.vedik.pocketshield.exception.RoleAlreadyExistsException;
import com.vedik.pocketshield.mapper.PSRoleMapper;
import com.vedik.pocketshield.repository.PSRoleRepository;
import com.vedik.pocketshield.service.IPSRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PSRoleServiceImpl implements IPSRoleService {

    private PSRoleRepository psRoleRepository;

    @Override
    @Transactional
    public void createRole(PSRoleDto psRoleDto) {
        Optional<PSRole> psRoleSaved = psRoleRepository.findByRoleName(psRoleDto.getRoleName());
        if(psRoleSaved.isPresent()){
            throw new RoleAlreadyExistsException("Role with name '" + psRoleDto.getRoleName() + "' already exists");
        }
        PSRole psRole = PSRoleMapper.mapToPSRole(psRoleDto, new PSRole());
        psRoleRepository.save(psRole);
    }

    @Override
    public List<PSRoleDto> getRoles() {
        List<PSRoleDto> psRoleDtoList = psRoleRepository.findAll().stream()
                .map(role -> PSRoleMapper.mapToPSRoleDto(role, new PSRoleDto()))
                .collect(Collectors.toList());
        return psRoleDtoList;
    }

    @Override
    public PSRoleDto getRole(int role_id) {
        Optional<PSRole> role = psRoleRepository.findById(role_id);
        if(!role.isPresent()){
            throw new ResourceNotFoundException("Role", "Id", String.valueOf(role_id));
        }
        return PSRoleMapper.mapToPSRoleDto(role.get(), new PSRoleDto());
    }

    @Override
    public void deleteRole(int role_id) {
        Optional<PSRole> role = psRoleRepository.findById(role_id);
        if(!role.isPresent()){
            throw new ResourceNotFoundException("Role", "Id", String.valueOf(role_id));
        }
        psRoleRepository.deleteById(role_id);
    }

    @Override
    public void updateRole(PSRoleDto psRoleDto) {
        Optional<PSRole> role = psRoleRepository.findByRoleName(psRoleDto.getRoleName());
        if(!role.isPresent()){
            throw new ResourceNotFoundException("Role", "Name", psRoleDto.getRoleName());
        }
        PSRoleMapper.mapToPSRole(psRoleDto, role.get());
        psRoleRepository.save(role.get());
    }
}
