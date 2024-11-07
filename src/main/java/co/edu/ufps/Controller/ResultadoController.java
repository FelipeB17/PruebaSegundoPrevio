package co.edu.ufps.Controller;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.servicies.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<Resultado>> getAllResultados() {
        return ResponseEntity.ok(resultadoService.getAllResultados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> getResultado(@PathVariable Long id) {
        return ResponseEntity.ok(resultadoService.getResultado(id));
    }

    @PostMapping
    public ResponseEntity<Resultado> createResultado(@RequestBody Resultado resultado) {
        return ResponseEntity.ok(resultadoService.createResultado(resultado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable Long id, @RequestBody Resultado resultado) {
        return ResponseEntity.ok(resultadoService.updateResultado(id, resultado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        resultadoService.deleteResultado(id);
        return ResponseEntity.noContent().build();
    }
}
