package org.example.backendwakandaculturaocioturismo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventoDTO {
    private Long id;
    private String nombre;
    private LocalDateTime fecha;
    private String horario;
    private String descripcion;
}
