package co.edu.ufps.Controller;

import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.servicies.SeleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/selecciones")
public class SeleccionController {

    @Autowired
    private SeleccionService seleccionService;

    @GetMapping
    public ResponseEntity<List<Seleccion>> getAllSelecciones() {
        return ResponseEntity.ok(seleccionService.getAllSelecciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seleccion> getSeleccion(@PathVariable Long id) {
        return ResponseEntity.ok(seleccionService.getSeleccion(id));
    }

    @PostMapping
    public ResponseEntity<Seleccion> createSeleccion(@RequestBody Seleccion seleccion) {
        return ResponseEntity.ok(seleccionService.createSeleccion(seleccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seleccion> updateSeleccion(@PathVariable Long id, @RequestBody Seleccion seleccion) {
        return ResponseEntity.ok(seleccionService.updateSeleccion(id, seleccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeleccion(@PathVariable Long id) {
        seleccionService.deleteSeleccion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<Map<String, Object>>> getResultados(@PathVariable Long id) {
        return ResponseEntity.ok(seleccionService.getResultados(id));
    }

    @GetMapping("/grupo/{grupo}")
    public ResponseEntity<List<Seleccion>> getSeleccionesByGrupo(@PathVariable String grupo) {
        return ResponseEntity.ok(seleccionService.getSeleccionesByGrupo(grupo));
    }
}
