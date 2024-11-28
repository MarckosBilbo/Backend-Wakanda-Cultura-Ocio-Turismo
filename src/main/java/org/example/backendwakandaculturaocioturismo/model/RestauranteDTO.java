package org.example.backendwakandaculturaocioturismo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private String horario;
    private String menu;
}
