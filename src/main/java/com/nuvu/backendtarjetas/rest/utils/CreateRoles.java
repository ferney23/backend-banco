package com.nuvu.backendtarjetas.rest.utils;

import com.nuvu.backendtarjetas.rest.security.entity.Roles;
import com.nuvu.backendtarjetas.rest.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nuvu.backendtarjetas.rest.security.service.RolService;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */



 @Component
 public class CreateRoles implements CommandLineRunner {

 //basetot@localhost

 @Autowired
 RolService rolService;

 @Override
 public void run(String... args) throws Exception {
 Roles rolAdmin = new Roles(RolNombre.ROLE_ADMIN);
 Roles rolUser = new Roles(RolNombre.ROLE_USER);
 rolService.save(rolAdmin);
 rolService.save(rolUser);

 }

 }

