package org.example.backendwakandaculturaocioturismo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurantes")
@Getter
@Setter
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private String tipo; // Ejemplo: "Comida típica", "Street food"

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private String menu;

    public Restaurante(String saboresDeWakanda, String barrioCultural, String comidaTípica, String s, String s1) {
    }

    public Restaurante() {

    }
}
