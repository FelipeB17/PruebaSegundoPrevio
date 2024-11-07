package co.edu.ufps.repositories;

import co.edu.ufps.entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
