package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Seleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String grupo;
    
    @ManyToOne
    @JoinColumn(name = "continente_id")
    private Continente continente;
    
    @OneToMany(mappedBy = "seleccion")
    private List<Jugador> jugadores;
    
    @OneToMany(mappedBy = "seleccionLocal")
    private List<Partido> partidosLocal;
    
    @OneToMany(mappedBy = "seleccionVisitante")
    private List<Partido> partidosVisitante;
}