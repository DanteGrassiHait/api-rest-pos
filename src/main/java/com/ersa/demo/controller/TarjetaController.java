package com.ersa.demo.controller;

import com.ersa.demo.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping(value = "/getImporte/{marca}/{importe}")
    public ResponseEntity<Double> getTasaOperacion(@PathVariable String marca, @PathVariable Double importe){
        return new ResponseEntity<>(tarjetaService.getTasaOperacion(importe, 100.0, marca), HttpStatus.OK);
    }
}
