package org.example.backendwakandaculturaocioturismo.rest;

import org.example.backendwakandaculturaocioturismo.model.RestauranteDTO;
import org.example.backendwakandaculturaocioturismo.services.RestauranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(final RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> getAllRestaurantes() {
        return ResponseEntity.ok(restauranteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> getRestaurante(@PathVariable final Long id) {
        return ResponseEntity.ok(restauranteService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createRestaurante(@RequestBody final RestauranteDTO restauranteDTO) {
        return ResponseEntity.ok(restauranteService.create(restauranteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurante(@PathVariable final Long id, @RequestBody final RestauranteDTO restauranteDTO) {
        restauranteService.update(id, restauranteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable final Long id) {
        restauranteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
