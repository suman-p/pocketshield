package com.vedik.pocketshield.controller;

import com.vedik.pocketshield.constants.ApplicationConstants;
import com.vedik.pocketshield.dto.PSRoleDto;
import com.vedik.pocketshield.dto.ResponseDto;
import com.vedik.pocketshield.service.IPSRoleService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/roles", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class PSRoleController {

    private static final Logger logger = LoggerFactory.getLogger(PSRoleController.class);

    @Autowired
    private IPSRoleService ipsRoleService;

    @PostMapping
    public ResponseEntity<ResponseDto> createRole(@Valid @RequestBody PSRoleDto psRoleDto){
        ipsRoleService.createRole(psRoleDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ApplicationConstants.STATUS_201, "Role created successfully"));
    }

    @PutMapping("/{role_id}")
    public ResponseEntity<ResponseDto> updateRole(@Valid @RequestBody PSRoleDto psRoleDto, @RequestParam int role_id){
        ipsRoleService.updateRole(psRoleDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ApplicationConstants.STATUS_201, "Role created successfully"));
    }

    @GetMapping
    public ResponseEntity<List<PSRoleDto>> getRoles(){
        List<PSRoleDto> roleDtos = ipsRoleService.getRoles();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleDtos);
    }

    @GetMapping("/{role_id}")
    public ResponseEntity<PSRoleDto> getRole(@PathVariable(name = "role_id") int role_id){
        PSRoleDto roleDto = ipsRoleService.getRole(role_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleDto);
    }

    @DeleteMapping("/{role_id}")
    public ResponseEntity<String> deleteRole(@PathVariable(name="role_id") int role_id){
        PSRoleDto roleDto = ipsRoleService.getRole(role_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Role deleted Successfully");
    }
}
