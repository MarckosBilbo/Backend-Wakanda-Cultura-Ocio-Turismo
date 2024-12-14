package org.example.backendwakandaculturaocioturismo.repos.usuario;


import org.example.backendwakandaculturaocioturismo.domain.usuario.Credenciales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {


}