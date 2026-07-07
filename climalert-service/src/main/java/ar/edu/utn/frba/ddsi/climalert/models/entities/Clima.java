package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clima {
    private Integer id;
    private Double temperatura;
    private Integer humedad;
    private String condicion;
    private String fechaActualizacion;
    private LocalDateTime fechaConsulta;

    public boolean hayAlerta() {
        return temperatura > 35 && humedad > 60;
    }

}
