package com.nuvu.backendtarjetas.rest.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nuvu.backendtarjetas.rest.security.entity.Usuario;
import com.nuvu.backendtarjetas.rest.security.entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        UsuarioPrincipal usuarioPrincipal = new UsuarioPrincipal();
        return usuarioPrincipal.build(usuario);
    }
}
