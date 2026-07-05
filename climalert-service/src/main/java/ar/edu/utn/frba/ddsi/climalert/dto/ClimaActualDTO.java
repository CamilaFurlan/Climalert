package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaActualDTO {
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("temp_c")
    private Double tempC;
    private Integer humidity;
    private String condition;
}
