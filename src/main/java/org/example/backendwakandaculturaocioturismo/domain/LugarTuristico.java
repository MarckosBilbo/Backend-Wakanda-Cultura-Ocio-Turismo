package org.example.backendwakandaculturaocioturismo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lugares_turisticos")
@Getter
@Setter
public class LugarTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = true)
    private String historia; // Información histórica adicional (opcional)
}

