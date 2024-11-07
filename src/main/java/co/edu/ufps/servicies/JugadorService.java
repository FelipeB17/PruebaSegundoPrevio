package co.edu.ufps.servicies;

import co.edu.ufps.entities.Jugador;
import co.edu.ufps.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugador(Long id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    public Jugador createJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador updateJugador(Long id, Jugador jugador) {
        jugador.setId(id);
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
