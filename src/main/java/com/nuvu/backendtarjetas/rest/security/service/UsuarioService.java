package com.nuvu.backendtarjetas.rest.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.backendtarjetas.rest.security.entity.Usuario;
import com.nuvu.backendtarjetas.rest.security.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){

        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){

        usuarioRepository.save(usuario);
    }
    public List<Usuario> usuarioList(){
       return  usuarioRepository.findAll();
    }

}
