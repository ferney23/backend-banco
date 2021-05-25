package com.nuvu.backendtarjetas.rest.security.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.backendtarjetas.rest.security.entity.Roles;
import com.nuvu.backendtarjetas.rest.security.enums.RolNombre;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRolNombre(RolNombre rolNombre);
}
