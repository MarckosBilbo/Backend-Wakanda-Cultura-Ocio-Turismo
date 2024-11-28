package org.example.backendwakandaculturaocioturismo.services;


import org.example.backendwakandaculturaocioturismo.domain.Restaurante;
import org.example.backendwakandaculturaocioturismo.model.RestauranteDTO;
import org.example.backendwakandaculturaocioturismo.repos.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public RestauranteService(final RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<RestauranteDTO> findAll() {
        return restauranteRepository.findAll().stream().map(restaurante -> {
            RestauranteDTO dto = new RestauranteDTO();
            dto.setId(restaurante.getId());
            dto.setNombre(restaurante.getNombre());
            dto.setUbicacion(restaurante.getUbicacion());
            dto.setTipo(restaurante.getTipo());
            dto.setHorario(restaurante.getHorario());
            dto.setMenu(restaurante.getMenu());
            return dto;
        }).toList();
    }

    public RestauranteDTO get(final Long id) {
        return restauranteRepository.findById(id).map(restaurante -> {
            RestauranteDTO dto = new RestauranteDTO();
            dto.setId(restaurante.getId());
            dto.setNombre(restaurante.getNombre());
            dto.setUbicacion(restaurante.getUbicacion());
            dto.setTipo(restaurante.getTipo());
            dto.setHorario(restaurante.getHorario());
            dto.setMenu(restaurante.getMenu());
            return dto;
        }).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
    }

    public Long create(final RestauranteDTO restauranteDTO) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setUbicacion(restauranteDTO.getUbicacion());
        restaurante.setTipo(restauranteDTO.getTipo());
        restaurante.setHorario(restauranteDTO.getHorario());
        restaurante.setMenu(restauranteDTO.getMenu());
        return restauranteRepository.save(restaurante).getId();
    }

    public void update(final Long id, final RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setUbicacion(restauranteDTO.getUbicacion());
        restaurante.setTipo(restauranteDTO.getTipo());
        restaurante.setHorario(restauranteDTO.getHorario());
        restaurante.setMenu(restauranteDTO.getMenu());
        restauranteRepository.save(restaurante);
    }

    public void delete(final Long id) {
        restauranteRepository.deleteById(id);
    }
}

