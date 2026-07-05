package ar.edu.utn.frba.ddsi.climalert.repositories.inMemory;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryClimaRepository implements ClimaRepository {

    private final List<Clima> historial = new ArrayList<>();

    @Override
    public void guardar(Clima clima) {
        historial.add(clima);
    }

    @Override
    public Clima obtenerUltimo() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.getLast();
    }

    @Override
    public List<Clima> obtenerTodos() {
        return historial;
    }
}

