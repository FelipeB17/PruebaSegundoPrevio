package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime fecha;
    private String estadio;
    
    @ManyToOne
    @JoinColumn(name = "seleccion_local_id")
    private Seleccion seleccionLocal;
    
    @ManyToOne
    @JoinColumn(name = "seleccion_visitante_id")
    private Seleccion seleccionVisitante;
    
    @OneToOne(mappedBy = "partido", cascade = CascadeType.ALL)
    private Resultado resultado;
}
