package co.edu.ufps.Controller;

import co.edu.ufps.entities.Partido;
import co.edu.ufps.servicies.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public ResponseEntity<List<Partido>> getAllPartidos() {
        return ResponseEntity.ok(partidoService.getAllPartidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartido(@PathVariable Long id) {
        return ResponseEntity.ok(partidoService.getPartido(id));
    }

    @PostMapping
    public ResponseEntity<Partido> createPartido(@RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.createPartido(partido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.updatePartido(id, partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);
        return ResponseEntity.noContent().build();
    }
}
