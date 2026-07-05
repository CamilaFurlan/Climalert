package ar.edu.utn.frba.ddsi.climalert.services;

public interface ClimaService {

    void consultarClima();

    //obtener el último clima,
    //verificar si:
    //temperatura > 35,
    //humedad > 60,
    //si se cumple, llamar a NotificacionesService.

}
