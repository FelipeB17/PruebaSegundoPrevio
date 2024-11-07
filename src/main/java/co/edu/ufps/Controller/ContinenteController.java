package co.edu.ufps.Controller;

import co.edu.ufps.entities.Continente;
import co.edu.ufps.servicies.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continentes")
public class ContinenteController {

 @Autowired
 private ContinenteService continenteService;

 @GetMapping
 public ResponseEntity<List<Continente>> getAllContinentes() {
     return ResponseEntity.ok(continenteService.getAllContinentes());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Continente> getContinente(@PathVariable Long id) {
     return ResponseEntity.ok(continenteService.getContinente(id));
 }

 @PostMapping
 public ResponseEntity<Continente> createContinente(@RequestBody Continente continente) {
     return ResponseEntity.ok(continenteService.createContinente(continente));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Continente> updateContinente(@PathVariable Long id, @RequestBody Continente continente) {
     return ResponseEntity.ok(continenteService.updateContinente(id, continente));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteContinente(@PathVariable Long id) {
     continenteService.deleteContinente(id);
     return ResponseEntity.noContent().build();
 }
}