package co.edu.ufps.Controller;

import co.edu.ufps.entities.Jugador;
import co.edu.ufps.servicies.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> getAllJugadores() {
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getJugador(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.getJugador(id));
    }

    @PostMapping
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.createJugador(jugador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.updateJugador(id, jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }
}