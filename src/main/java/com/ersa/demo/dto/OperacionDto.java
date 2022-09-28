package com.ersa.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OperacionDto {

    private String marca;
    private Double importe;
    private Double tasaOperacion;

}
