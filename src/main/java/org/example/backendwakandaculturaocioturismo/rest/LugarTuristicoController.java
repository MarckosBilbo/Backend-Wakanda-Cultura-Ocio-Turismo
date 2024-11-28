package org.example.backendwakandaculturaocioturismo.rest;

import org.example.backendwakandaculturaocioturismo.model.LugarTuristicoDTO;
import org.example.backendwakandaculturaocioturismo.services.LugarTuristicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lugares-turisticos")
public class LugarTuristicoController {

    private final LugarTuristicoService lugarTuristicoService;

    public LugarTuristicoController(final LugarTuristicoService lugarTuristicoService) {
        this.lugarTuristicoService = lugarTuristicoService;
    }

    @GetMapping
    public ResponseEntity<List<LugarTuristicoDTO>> getAllLugares() {
        return ResponseEntity.ok(lugarTuristicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LugarTuristicoDTO> getLugar(@PathVariable final Long id) {
        return ResponseEntity.ok(lugarTuristicoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createLugar(@RequestBody final LugarTuristicoDTO lugarTuristicoDTO) {
        return ResponseEntity.ok(lugarTuristicoService.create(lugarTuristicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLugar(@PathVariable final Long id, @RequestBody final LugarTuristicoDTO lugarTuristicoDTO) {
        lugarTuristicoService.update(id, lugarTuristicoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLugar(@PathVariable final Long id) {
        lugarTuristicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
