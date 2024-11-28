package org.example.backendwakandaculturaocioturismo.services;

import org.example.backendwakandaculturaocioturismo.domain.LugarTuristico;
import org.example.backendwakandaculturaocioturismo.model.LugarTuristicoDTO;
import org.example.backendwakandaculturaocioturismo.repos.LugarTuristicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarTuristicoService {

    private final LugarTuristicoRepository lugarTuristicoRepository;

    public LugarTuristicoService(final LugarTuristicoRepository lugarTuristicoRepository) {
        this.lugarTuristicoRepository = lugarTuristicoRepository;
    }

    public List<LugarTuristicoDTO> findAll() {
        return lugarTuristicoRepository.findAll().stream().map(lugar -> {
            LugarTuristicoDTO dto = new LugarTuristicoDTO();
            dto.setId(lugar.getId());
            dto.setNombre(lugar.getNombre());
            dto.setUbicacion(lugar.getUbicacion());
            dto.setDescripcion(lugar.getDescripcion());
            dto.setHistoria(lugar.getHistoria());
            return dto;
        }).toList();
    }

    public LugarTuristicoDTO get(final Long id) {
        return lugarTuristicoRepository.findById(id).map(lugar -> {
            LugarTuristicoDTO dto = new LugarTuristicoDTO();
            dto.setId(lugar.getId());
            dto.setNombre(lugar.getNombre());
            dto.setUbicacion(lugar.getUbicacion());
            dto.setDescripcion(lugar.getDescripcion());
            dto.setHistoria(lugar.getHistoria());
            return dto;
        }).orElseThrow(() -> new RuntimeException("Lugar Turístico no encontrado"));
    }

    public Long create(final LugarTuristicoDTO lugarDTO) {
        LugarTuristico lugar = new LugarTuristico();
        lugar.setNombre(lugarDTO.getNombre());
        lugar.setUbicacion(lugarDTO.getUbicacion());
        lugar.setDescripcion(lugarDTO.getDescripcion());
        lugar.setHistoria(lugarDTO.getHistoria());
        return lugarTuristicoRepository.save(lugar).getId();
    }

    public void update(final Long id, final LugarTuristicoDTO lugarDTO) {
        LugarTuristico lugar = lugarTuristicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lugar Turístico no encontrado"));
        lugar.setNombre(lugarDTO.getNombre());
        lugar.setUbicacion(lugarDTO.getUbicacion());
        lugar.setDescripcion(lugarDTO.getDescripcion());
        lugar.setHistoria(lugarDTO.getHistoria());
        lugarTuristicoRepository.save(lugar);
    }

    public void delete(final Long id) {
        lugarTuristicoRepository.deleteById(id);
    }
}
