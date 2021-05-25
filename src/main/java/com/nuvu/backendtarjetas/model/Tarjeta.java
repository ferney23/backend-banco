package com.nuvu.backendtarjetas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import com.nuvu.backendtarjetas.rest.security.entity.Usuario;


@Table
@Entity
public class Tarjeta implements Serializable {
    @Id
   // @Size(min = 14, max = 14)
    //@Column(name = "Numero", nullable = false, length = 14 )
    private Long numeroTarjeta;
    //@Size(min = 3, max = 3)
    @Column(name = "Codigo", nullable = false, length = 30 )
    private Long cvn;

   // @Size(min = 4, max = 4)
    @Column(name = "Año", nullable = false, length = 40 )
    private Long añoVencimiento;

    //@Size(min = 1, max = 2)
    @Column(name = "Mes", nullable = false, length = 20 )
    private Long mesVencimiento;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Tarjeta(){

    }

    public Tarjeta(Long numeroTarjeta, Long cvn, Long añoVencimiento, Long mesVencimiento, Usuario usuario) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvn = cvn;
        this.añoVencimiento = añoVencimiento;
        this.mesVencimiento = mesVencimiento;
        this.usuario = usuario;
    }

    public Long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Long getCvn() {
        return cvn;
    }

    public void setCvn(Long cvn) {
        this.cvn = cvn;
    }

    public Long getAñoVencimiento() {
        return añoVencimiento;
    }

    public void setAñoVencimiento(Long añoVencimiento) {
        this.añoVencimiento = añoVencimiento;
    }

    public Long getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(Long mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public Usuario getPerson() {

        return usuario;
    }

    public void setPerson(Usuario person) {

        this.usuario = person;
    }


    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta=" + numeroTarjeta +
                ", cvn=" + cvn +
                ", añoVencimiento=" + añoVencimiento +
                ", mesVencimiento=" + mesVencimiento +
                '}';
    }
}
