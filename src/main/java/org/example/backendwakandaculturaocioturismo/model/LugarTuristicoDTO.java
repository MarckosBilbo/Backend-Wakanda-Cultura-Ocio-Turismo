package org.example.backendwakandaculturaocioturismo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LugarTuristicoDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String historia;
}
