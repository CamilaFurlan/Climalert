package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
public class Clima {
    private Integer id;
    private Double temperatura;
    private Integer humedad;
    private String condicion;
    private String fechaActualizacion;
    private LocalDateTime fechaConsulta;

}
