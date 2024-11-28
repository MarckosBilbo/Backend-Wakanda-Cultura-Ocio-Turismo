package org.example.backendwakandaculturaocioturismo.repos;


import org.example.backendwakandaculturaocioturismo.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
