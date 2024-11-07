package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private int edad;
    private String posicion;
    
    @ManyToOne
    @JoinColumn(name = "seleccion_id")
    private Seleccion seleccion;
}
