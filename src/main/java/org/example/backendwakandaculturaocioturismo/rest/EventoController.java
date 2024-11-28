package org.example.backendwakandaculturaocioturismo.rest;

import org.example.backendwakandaculturaocioturismo.model.EventoDTO;
import org.example.backendwakandaculturaocioturismo.services.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(final EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> getAllEventos() {
        return ResponseEntity.ok(eventoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> getEvento(@PathVariable final Long id) {
        return ResponseEntity.ok(eventoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createEvento(@RequestBody final EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.create(eventoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvento(@PathVariable final Long id, @RequestBody final EventoDTO eventoDTO) {
        eventoService.update(id, eventoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable final Long id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
