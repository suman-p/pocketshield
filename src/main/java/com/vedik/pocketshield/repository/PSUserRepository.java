package com.vedik.pocketshield.repository;

import com.vedik.pocketshield.entity.PSUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PSUserRepository extends JpaRepository<PSUser, Integer> {
}
