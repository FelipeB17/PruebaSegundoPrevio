package co.edu.ufps.servicies;

import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.repositories.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import co.edu.ufps.entities.Partido;
@Service
public class SeleccionService {

    @Autowired
    private SeleccionRepository seleccionRepository;

    public List<Seleccion> getAllSelecciones() {
        return seleccionRepository.findAll();
    }

    public Seleccion getSeleccion(Long id) {
        return seleccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Selección no encontrada"));
    }

    public Seleccion createSeleccion(Seleccion seleccion) {
        return seleccionRepository.save(seleccion);
    }

    public Seleccion updateSeleccion(Long id, Seleccion seleccion) {
        seleccion.setId(id);
        return seleccionRepository.save(seleccion);
    }

    public void deleteSeleccion(Long id) {
        seleccionRepository.deleteById(id);
    }

    public List<Map<String, Object>> getResultados(Long id) {
        Seleccion seleccion = getSeleccion(id);
        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Partido partido : seleccion.getPartidosLocal()) {
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("equipoLocal", partido.getSeleccionLocal().getNombre());
            resultado.put("equipoVisitante", partido.getSeleccionVisitante().getNombre());
            resultado.put("golesLocal", partido.getResultado().getGolesLocal());
            resultado.put("golesVisitante", partido.getResultado().getGolesVisitante());
            resultado.put("amarillasLocal", partido.getResultado().getAmarillasLocal());
            resultado.put("amarillasVisitante", partido.getResultado().getAmarillasVisitante());
            resultado.put("rojasLocal", partido.getResultado().getRojasLocal());
            resultado.put("rojasVisitante", partido.getResultado().getRojasVisitante());
            resultados.add(resultado);
        }

        for (Partido partido : seleccion.getPartidosVisitante()) {
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("equipoLocal", partido.getSeleccionLocal().getNombre());
            resultado.put("equipoVisitante", partido.getSeleccionVisitante().getNombre());
            resultado.put("golesLocal", partido.getResultado().getGolesLocal());
            resultado.put("golesVisitante", partido.getResultado().getGolesVisitante());
            resultado.put("amarillasLocal", partido.getResultado().getAmarillasLocal());
            resultado.put("amarillasVisitante", partido.getResultado().getAmarillasVisitante());
            resultado.put("rojasLocal", partido.getResultado().getRojasLocal());
            resultado.put("rojasVisitante", partido.getResultado().getRojasVisitante());
            resultados.add(resultado);
        }

        return resultados;
    }

    public List<Seleccion> getSeleccionesByGrupo(String grupo) {
        return seleccionRepository.findByGrupo(grupo);
    }
}
