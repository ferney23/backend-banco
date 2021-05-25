package com.nuvu.backendtarjetas.rest;

import com.nuvu.backendtarjetas.rest.security.entity.UsuarioPrincipal;
import com.nuvu.backendtarjetas.rest.security.entity.Usuario;
import com.nuvu.backendtarjetas.dtos.TarjetaDto;
import com.nuvu.backendtarjetas.model.Tarjeta;
import com.nuvu.backendtarjetas.repositories.TarjetaRepository;
import com.nuvu.backendtarjetas.rest.security.repository.UsuarioRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tarjetas")
@CrossOrigin(origins = "*")
//@PreAuthorize("permitAll()")
@PreAuthorize("hasRole ('ROLE_USER')")
public class TarjetaRest {
    private final static Logger logger = LoggerFactory.getLogger(TarjetaRest.class);
    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole ('ROLE_USER')")
    public ResponseEntity<List<Tarjeta>> tarjetaResponseEntity(Authentication authentication) {
        List<Tarjeta> tarjetaList = tarjetaRepository.findAll();
        return ResponseEntity.ok(tarjetaList);
    }


    @RequestMapping(value = "{tarjetaId}") //
    public ResponseEntity<Tarjeta> getTarjetaByIdPersona(@PathVariable("tarjetaId") Long id, Authentication authentication) {

        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        usuarioPrincipal.getUsuario();
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findById(id);
        return ResponseEntity.ok(optionalTarjeta.get());

    }


    @PostMapping
    @PreAuthorize("hasRole ('ROLE_USER')")
    public ResponseEntity<Tarjeta> createTarjeta(@RequestBody TarjetaDto tarjetaDto, Authentication authentication) {

        System.out.println(authentication.getName());
        Optional<Usuario> optionalUsuario = usuarioRepository.findByNombreUsuario(authentication.getName());
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findById(tarjetaDto.getNumeroTarjeta());
        if (optionalTarjeta.isPresent()){
            return ResponseEntity.noContent().build();
        }else {
            Tarjeta tarjeta = new Tarjeta(
                    tarjetaDto.getNumeroTarjeta(),
                    tarjetaDto.getCvn(), tarjetaDto.getAñoVencimiento(),
                    tarjetaDto.getMesVencimiento(), optionalUsuario.get());
            System.out.println("Creando Tarjeta");
            Tarjeta tarjetaNueva = tarjetaRepository.save(tarjeta);

            return ResponseEntity.ok(tarjetaNueva);
        }

    }

    @PutMapping
    @PreAuthorize("hasRole ('ROLE_USER')")
    public ResponseEntity<Tarjeta> updateTarjetaResponseEntity(@RequestBody TarjetaDto tarjetaDto, Authentication authentication) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByNombreUsuario(authentication.getName());
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findById(tarjetaDto.getNumeroTarjeta());
        if (optionalTarjeta.isPresent()) {
            Tarjeta tarjeta = new Tarjeta(
                    tarjetaDto.getNumeroTarjeta(),
                    tarjetaDto.getCvn(), tarjetaDto.getAñoVencimiento(),
                    tarjetaDto.getMesVencimiento(), optionalUsuario.get());
            Tarjeta tarjetaUpdate = tarjetaRepository.save(tarjeta);
            System.out.println("Tarjeta Modificada");
            return ResponseEntity.ok(tarjetaUpdate);
        } else {
            System.out.println("Tarjeta no Modificado");
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping(value = "{tarjetaId}")
    @PreAuthorize("hasRole ('ROLE_USER')")
    public ResponseEntity<Void> deleteLugar(@PathVariable("tarjetaId") Long id, Authentication authentication) {
        tarjetaRepository.deleteById(id);
        System.out.println("Eliminando Tarjeta");
        return ResponseEntity.ok(null);
    }


}
