package co.edu.ufps.repositories;

import co.edu.ufps.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
