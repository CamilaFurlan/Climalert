package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.ClimaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Override
    public void consultarClima(){
        String url = apiUrl + "?key=" + apiKey + "&q=" + location;
    }
}
