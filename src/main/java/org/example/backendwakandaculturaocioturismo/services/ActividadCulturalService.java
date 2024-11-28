package org.example.backendwakandaculturaocioturismo.services;


import org.example.backendwakandaculturaocioturismo.domain.ActividadCultural;
import org.example.backendwakandaculturaocioturismo.model.ActividadCulturalDTO;
import org.example.backendwakandaculturaocioturismo.repos.ActividadCulturalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadCulturalService {

    private final ActividadCulturalRepository actividadCulturalRepository;

    public ActividadCulturalService(final ActividadCulturalRepository actividadCulturalRepository) {
        this.actividadCulturalRepository = actividadCulturalRepository;
    }

    public List<ActividadCulturalDTO> findAll() {
        return actividadCulturalRepository.findAll().stream().map(actividad -> {
            ActividadCulturalDTO dto = new ActividadCulturalDTO();
            dto.setId(actividad.getId());
            dto.setNombre(actividad.getNombre());
            dto.setDescripcion(actividad.getDescripcion());
            dto.setHorario(actividad.getHorario());
            dto.setDuracion(actividad.getDuracion());
            dto.setPrecio(actividad.getPrecio());
            return dto;
        }).toList();
    }

    public ActividadCulturalDTO get(final Long id) {
        return actividadCulturalRepository.findById(id).map(actividad -> {
            ActividadCulturalDTO dto = new ActividadCulturalDTO();
            dto.setId(actividad.getId());
            dto.setNombre(actividad.getNombre());
            dto.setDescripcion(actividad.getDescripcion());
            dto.setHorario(actividad.getHorario());
            dto.setDuracion(actividad.getDuracion());
            dto.setPrecio(actividad.getPrecio());
            return dto;
        }).orElseThrow(() -> new RuntimeException("Actividad Cultural no encontrada"));
    }

    public Long create(final ActividadCulturalDTO actividadDTO) {
        ActividadCultural actividad = new ActividadCultural();
        actividad.setNombre(actividadDTO.getNombre());
        actividad.setDescripcion(actividadDTO.getDescripcion());
        actividad.setHorario(actividadDTO.getHorario());
        actividad.setDuracion(actividadDTO.getDuracion());
        actividad.setPrecio(actividadDTO.getPrecio());
        return actividadCulturalRepository.save(actividad).getId();
    }

    public void update(final Long id, final ActividadCulturalDTO actividadDTO) {
        ActividadCultural actividad = actividadCulturalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad Cultural no encontrada"));
        actividad.setNombre(actividadDTO.getNombre());
        actividad.setDescripcion(actividadDTO.getDescripcion());
        actividad.setHorario(actividadDTO.getHorario());
        actividad.setDuracion(actividadDTO.getDuracion());
        actividad.setPrecio(actividadDTO.getPrecio());
        actividadCulturalRepository.save(actividad);
    }

    public void delete(final Long id) {
        actividadCulturalRepository.deleteById(id);
    }
}
