package ar.edu.utn.frba.ddsi.climalert.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClimaActualDTO {
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("temp_c")
    private Double tempC;
    private Integer humidity;
    private CondicionDTO condition;
}
