package co.edu.ufps.servicies;

import co.edu.ufps.entities.Continente;
import co.edu.ufps.repositories.ContinenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteService {

    @Autowired
    private ContinenteRepository continenteRepository;

    public List<Continente> getAllContinentes() {
        return continenteRepository.findAll();
    }

    public Continente getContinente(Long id) {
        return continenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Continente no encontrado"));
    }

    public Continente createContinente(Continente continente) {
        return continenteRepository.save(continente);
    }

    public Continente updateContinente(Long id, Continente continente) {
        continente.setId(id);
        return continenteRepository.save(continente);
    }

    public void deleteContinente(Long id) {
        continenteRepository.deleteById(id);
    }
}