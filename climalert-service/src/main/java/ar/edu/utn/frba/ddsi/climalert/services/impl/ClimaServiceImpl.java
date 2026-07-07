package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaActualDTO;
import ar.edu.utn.frba.ddsi.climalert.dto.WeatherApiResponse;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.ClimaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final RestTemplate restTemplate;
    private final ClimaRepository climaRepository;

    public ClimaServiceImpl(RestTemplate restTemplate,
                            ClimaRepository climaRepository) {
        this.restTemplate = restTemplate;
        this.climaRepository = climaRepository;
    }

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.location}")
    private String location;

    @Scheduled(fixedRate = 300000)
    @Override
    public void consultarClima() {

        String url = apiUrl + "?key=" + apiKey + "&q=" + location;

        WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);

        if (response == null || response.getCurrent() == null) {
            throw new IllegalStateException("No se pudo obtener información del clima.");
        }
        ClimaActualDTO climaActual = response.getCurrent();

        Clima clima = new Clima(
                null,
                climaActual.getTemperatura(),
                climaActual.getHumedad(),
                climaActual.getCondicion().getText(),
                climaActual.getUltimaActualizacion(),
                LocalDateTime.now()
        );

        climaRepository.guardar(clima);

    }
}
