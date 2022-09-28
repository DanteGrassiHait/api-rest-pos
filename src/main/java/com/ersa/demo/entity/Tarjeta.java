package com.ersa.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tarjeta")
public class Tarjeta {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tarjeta")
    private String numero;

    @NotNull
    @Column(name = "marca")
    private String marca;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Column(name = "fecha_vencimiento")
    private Calendar fechaVto;


}
