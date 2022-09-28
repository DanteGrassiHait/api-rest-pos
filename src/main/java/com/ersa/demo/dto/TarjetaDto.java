package com.ersa.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TarjetaDto {

    private String marca;
    private String numero;
    private String nombre;
    private String apellido;
    private Calendar fechaVto;

}
