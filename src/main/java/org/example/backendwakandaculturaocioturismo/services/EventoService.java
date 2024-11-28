package org.example.backendwakandaculturaocioturismo.services;

import org.example.backendwakandaculturaocioturismo.domain.Evento;
import org.example.backendwakandaculturaocioturismo.model.EventoDTO;
import org.example.backendwakandaculturaocioturismo.repos.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(final EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<EventoDTO> findAll() {
        return eventoRepository.findAll().stream().map(evento -> {
            EventoDTO dto = new EventoDTO();
            dto.setId(evento.getId());
            dto.setNombre(evento.getNombre());
            dto.setFecha(evento.getFecha());
            dto.setHorario(evento.getHorario());
            dto.setDescripcion(evento.getDescripcion());
            return dto;
        }).toList();
    }

    public EventoDTO get(final Long id) {
        return eventoRepository.findById(id).map(evento -> {
            EventoDTO dto = new EventoDTO();
            dto.setId(evento.getId());
            dto.setNombre(evento.getNombre());
            dto.setFecha(evento.getFecha());
            dto.setHorario(evento.getHorario());
            dto.setDescripcion(evento.getDescripcion());
            return dto;
        }).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }

    public Long create(final EventoDTO eventoDTO) {
        Evento evento = new Evento();
        evento.setNombre(eventoDTO.getNombre());
        evento.setFecha(eventoDTO.getFecha());
        evento.setHorario(eventoDTO.getHorario());
        evento.setDescripcion(eventoDTO.getDescripcion());
        return eventoRepository.save(evento).getId();
    }

    public void update(final Long id, final EventoDTO eventoDTO) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        evento.setNombre(eventoDTO.getNombre());
        evento.setFecha(eventoDTO.getFecha());
        evento.setHorario(eventoDTO.getHorario());
        evento.setDescripcion(eventoDTO.getDescripcion());
        eventoRepository.save(evento);
    }

    public void delete(final Long id) {
        eventoRepository.deleteById(id);
    }
}
