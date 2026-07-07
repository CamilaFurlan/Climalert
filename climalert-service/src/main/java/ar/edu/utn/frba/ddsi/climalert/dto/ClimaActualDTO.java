package ar.edu.utn.frba.ddsi.climalert.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClimaActualDTO {
    @JsonProperty("last_updated")
    private String ultimaActualizacion;
    @JsonProperty("temp_c")
    private Double temperatura;
    @JsonProperty("humidity")
    private Integer humedad;
    @JsonProperty("condition")
    private CondicionDTO condicion;
}
