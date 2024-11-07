package co.edu.ufps.repositories;

import co.edu.ufps.entities.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeleccionRepository extends JpaRepository<Seleccion, Long> {
    List<Seleccion> findByGrupo(String grupo);
}
