package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int golesLocal;
    private int golesVisitante;
    private int amarillasLocal;
    private int amarillasVisitante;
    private int rojasLocal;
    private int rojasVisitante;
    
    @OneToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;
}
