package com.nuvu.backendtarjetas.rest.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.backendtarjetas.rest.security.entity.Roles;
import com.nuvu.backendtarjetas.rest.security.enums.RolNombre;
import com.nuvu.backendtarjetas.rest.security.repository.RolRepository;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Roles> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Roles rol){
        rolRepository.save(rol);
    }
}
