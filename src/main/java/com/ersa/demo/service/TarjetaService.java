package com.ersa.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TarjetaService {

    private final static Logger log = LoggerFactory.getLogger(TarjetaService.class);

    public Double getTasaOperacion(Double importe, Double importeLimte, String marca){
        return validaDatos(importe, importeLimte)
                ? obtenerTasaOperacion(marca)
                : 0D;
    }

    /**
     * Verifica si el importe ingresado es menor al limite estipulado y si la fecha de vencimiento
     * es menor a la fecha actual
     * @param importe
     * @param importeLimite
     * @return True si y solo si el importe es menor al limite y la fecha de vencimiento es menor al dia actual
     */
    public boolean validaDatos(Double importe, Double importeLimite){
        return operacionValida(importe, importeLimite);
    }

    /**
     * Verifica si el importre ingresado es menor al limite estipulado
     * @param importe
     * @param importeLimite
     * @return True si y solo si el importe es menor al limite
     */
    public boolean operacionValida(Double importe, Double importeLimite){
        if(importe < importeLimite){
            return true;
        }
        return false;
    }

    /**
     * Obtiene la tasa de una operacion para una tarjeta dada
     * @param marca
     * @return
     */
    private Double obtenerTasaOperacion(String marca){
        Calendar time = Calendar.getInstance();
        Double tasa = 0D;
        switch (marca){
            case "VISA":
                tasa = getTasaVisa(time.get(Calendar.YEAR), time.get(Calendar.MONTH));
                break;
            case "NARA":
                tasa = getTasaNara(time.get(Calendar.DAY_OF_MONTH) + 1);
                break;
            case "AMEX":
                tasa = getTasaAmex(time.get(Calendar.MONTH) + 1);
                break;
        }
        return getPorcentajes(tasa);
    }

    /**
     * Metodo usado para los limites minimos y maximos permitidos por las tarjetas
     * @param tasa
     * @return
     */
    private Double getPorcentajes(Double tasa){
        if(tasa < 0.3){
            tasa =  0.3;
        } else if(tasa > 5.0){
            tasa = 5.0;
        }
        return tasa;
    }

    private Double getTasaVisa(Integer anio, Integer mes){
        Double tasa = 0D;
        try {
            tasa = Double.valueOf(Integer.valueOf(anio.toString().substring(2)) / (mes + 1));
        } catch (NumberFormatException error){
            log.error("NumberFormatException: " + error.getMessage());
        } catch(NullPointerException error){
            log.error("NullPointerException: " + error.getMessage());
        } catch (Exception error){
            log.error("Exception: " + error.getMessage());
        }
        return tasa;
    }

    private Double getTasaNara(Integer diaMes){
        Double tasa = 0D;
        try {
            tasa = Double.valueOf(diaMes * 0.5);
        } catch (NumberFormatException error){
            log.error("NumberFormatException: " + error.getMessage());
        } catch(NullPointerException error){
            log.error("NullPointerException: " + error.getMessage());
        } catch (Exception error){
            log.error("Exception: " + error.getMessage());
        }
        return tasa;
    }

    private Double getTasaAmex(Integer mes){
        Double tasa = 0D;
        try {
            tasa = Double.valueOf(mes * 0.1);
        } catch (NumberFormatException error){
            log.error("NumberFormatException: " + error.getMessage());
        } catch(NullPointerException error){
            log.error("NullPointerException: " + error.getMessage());
        } catch (Exception error){
            log.error("Exception: " + error.getMessage());
        }
        return tasa;
    }
}
