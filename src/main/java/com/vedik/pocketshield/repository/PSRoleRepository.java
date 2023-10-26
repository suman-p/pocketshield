package com.vedik.pocketshield.repository;

import com.vedik.pocketshield.entity.PSRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PSRoleRepository extends JpaRepository<PSRole, Integer> {
    Optional<PSRole> findByRoleName(String roleName);
}
