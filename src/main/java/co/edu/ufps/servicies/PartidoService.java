package co.edu.ufps.servicies;

import co.edu.ufps.entities.Partido;
import co.edu.ufps.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Partido getPartido(Long id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    public Partido createPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido updatePartido(Long id, Partido partido) {
        partido.setId(id);
        return partidoRepository.save(partido);
    }

    public void deletePartido(Long id) {
        partidoRepository.deleteById(id);
    }
}
