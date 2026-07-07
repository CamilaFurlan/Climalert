package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.AlertaService;
import ar.edu.utn.frba.ddsi.climalert.services.NotificacionesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AlertaServiceImpl implements AlertaService {

    private final ClimaRepository climaRepository;
    private final NotificacionesService notificacionesService;

    public AlertaServiceImpl(ClimaRepository climaRepository,
                             NotificacionesService notificacionesService) {
        this.climaRepository = climaRepository;
        this.notificacionesService = notificacionesService;
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void verificarAlerta() {
        Clima clima = climaRepository.obtenerUltimo();

        if (clima == null) {
            return;
        }

        if (clima.hayAlerta()) {

            System.out.println("Alerta climática detectada. Enviando correo...");
            notificacionesService.enviarAlerta(clima);
        }

    }

}