package com.nuvu.backendtarjetas.repositories;

import com.nuvu.backendtarjetas.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
    //List<Tarjeta> findByPersonId(Long id);
    //@Query("SELECT ma FROM Tarjeta ma where ma.id=:id and ma.person.id=:idPerson")
    //Tarjeta findPersonAndId(@Param("id") Long id,@Param("idPerson") Long idPerson);


}
