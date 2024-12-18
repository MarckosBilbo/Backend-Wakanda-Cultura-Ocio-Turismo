package org.example.backendwakandaculturaocioturismo;

import org.example.backendwakandaculturaocioturismo.domain.*;
import org.example.backendwakandaculturaocioturismo.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendWakandaCulturaOcioTurismoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendWakandaCulturaOcioTurismoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(
            EventoRepository eventoRepository,
            LugarTuristicoRepository lugarTuristicoRepository,
            RestauranteRepository restauranteRepository,
            ActividadCulturalRepository actividadCulturalRepository) {
        return args -> {
            // --- Inicialización de Datos ---
            // Restaurantes
            Restaurante comidaTipica = new Restaurante();
            comidaTipica.setNombre("Sabores de Wakanda");
            comidaTipica.setUbicacion("Barrio Cultural");
            comidaTipica.setTipo("Comida Típica");
            comidaTipica.setHorario("12:00 - 22:00");
            comidaTipica.setMenu("Jollof Rice, Egusi Soup");
            restauranteRepository.save(comidaTipica);

            // Lugares Turísticos
            LugarTuristico museo = new LugarTuristico();
            museo.setNombre("Museo de Historia");
            museo.setUbicacion("Centro Histórico");
            museo.setDescripcion("Reliquias y artefactos históricos.");
            museo.setHistoria("Fundado en 1950");
            lugarTuristicoRepository.save(museo);

            // Eventos
            Evento festivalMusica = new Evento();
            festivalMusica.setNombre("Festival de Música");
            festivalMusica.setFecha(LocalDateTime.of(2024, 12, 20, 18, 0));
            festivalMusica.setHorario("18:00 - 23:00");
            festivalMusica.setDescripcion("Reunión de los mejores talentos.");
            eventoRepository.save(festivalMusica);

            // Actividades Culturales
            ActividadCultural cataComida = new ActividadCultural();
            cataComida.setNombre("Cata de Comida Wakandiana");
            cataComida.setDescripcion("Prueba de platos típicos.");
            cataComida.setHorario("15:00 - 17:00");
            cataComida.setDuracion("2 horas");
            cataComida.setPrecio(20.0);
            actividadCulturalRepository.save(cataComida);

            System.out.println("[INFO] Datos de ejemplo inicializados correctamente.");

            // --- Mostrar Datos Iniciales ---
            System.out.println("\n[INFO] Restaurantes:");
            restauranteRepository.findAll().forEach(r ->
                    System.out.println(r.getNombre() + " | " + r.getUbicacion() + " | " + r.getTipo()));

            System.out.println("\n[INFO] Lugares Turísticos:");
            lugarTuristicoRepository.findAll().forEach(l ->
                    System.out.println(l.getNombre() + " | " + l.getUbicacion() + " | " + l.getDescripcion()));

            // --- Mostrar Datos Dinámicos ---
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

            scheduler.scheduleAtFixedRate(() -> {
                List<Evento> eventos = eventoRepository.findAll();
                System.out.println("\n[INFO] Eventos Disponibles:");
                eventos.forEach(e -> System.out.println(e.getNombre() + " | Fecha: " + e.getFecha() + " | " + e.getDescripcion()));
            }, 0, 10, TimeUnit.SECONDS);

            scheduler.scheduleAtFixedRate(() -> {
                List<ActividadCultural> actividades = actividadCulturalRepository.findAll();
                System.out.println("\n[INFO] Actividades Culturales:");
                actividades.forEach(a -> System.out.println(a.getNombre() + " | " + a.getDescripcion() + " | Precio: " + a.getPrecio() + "€"));
            }, 5, 10, TimeUnit.SECONDS);
        };
    }
}
