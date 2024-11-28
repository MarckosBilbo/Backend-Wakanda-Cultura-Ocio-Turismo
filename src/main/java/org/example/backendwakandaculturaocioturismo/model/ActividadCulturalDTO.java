package org.example.backendwakandaculturaocioturismo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActividadCulturalDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String horario;
    private String duracion;
    private Double precio;
}

