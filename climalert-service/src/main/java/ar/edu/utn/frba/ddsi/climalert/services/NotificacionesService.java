package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;

public interface NotificacionesService {
    void enviarAlerta(Clima clima);

}