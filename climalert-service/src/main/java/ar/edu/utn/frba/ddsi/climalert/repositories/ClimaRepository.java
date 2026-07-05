package ar.edu.utn.frba.ddsi.climalert.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;

import java.util.List;

public interface ClimaRepository {

    void guardar(Clima clima);
    Clima obtenerUltimo();
    List<Clima> obtenerTodos();
}
