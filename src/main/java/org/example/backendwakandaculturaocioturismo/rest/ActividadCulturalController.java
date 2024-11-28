package org.example.backendwakandaculturaocioturismo.rest;

import org.example.backendwakandaculturaocioturismo.model.ActividadCulturalDTO;
import org.example.backendwakandaculturaocioturismo.services.ActividadCulturalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades-culturales")
public class ActividadCulturalController {

    private final ActividadCulturalService actividadCulturalService;

    public ActividadCulturalController(final ActividadCulturalService actividadCulturalService) {
        this.actividadCulturalService = actividadCulturalService;
    }

    @GetMapping
    public ResponseEntity<List<ActividadCulturalDTO>> getAllActividades() {
        return ResponseEntity.ok(actividadCulturalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadCulturalDTO> getActividad(@PathVariable final Long id) {
        return ResponseEntity.ok(actividadCulturalService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createActividad(@RequestBody final ActividadCulturalDTO actividadCulturalDTO) {
        return ResponseEntity.ok(actividadCulturalService.create(actividadCulturalDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateActividad(@PathVariable final Long id, @RequestBody final ActividadCulturalDTO actividadCulturalDTO) {
        actividadCulturalService.update(id, actividadCulturalDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable final Long id) {
        actividadCulturalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
