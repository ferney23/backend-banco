package com.nuvu.backendtarjetas.dtos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TarjetaDto implements Serializable {

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



    public TarjetaDto(){

    }

    public TarjetaDto(Long numeroTarjeta, Long cvn, Long añoVencimiento, Long mesVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvn = cvn;
        this.añoVencimiento = añoVencimiento;
        this.mesVencimiento = mesVencimiento;

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




}
