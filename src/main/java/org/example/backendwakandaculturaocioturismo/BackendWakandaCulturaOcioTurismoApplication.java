package org.example.backendwakandaculturaocioturismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.example.backendwakandaculturaocioturismo.domain.*;
        import org.example.backendwakandaculturaocioturismo.repos.*;
        import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

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
            // Inicializar datos de ejemplo

            // Eventos
            Evento festivalMusica = new Evento();
            festivalMusica.setNombre("Festival de Música de Wakanda");
            festivalMusica.setFecha(LocalDateTime.of(2024, 12, 20, 18, 0));
            festivalMusica.setHorario("18:00 - 23:00");
            festivalMusica.setDescripcion("Un festival que reúne los mejores talentos musicales de Wakanda.");
            eventoRepository.save(festivalMusica);

            Evento carnaval = new Evento();
            carnaval.setNombre("Carnaval Wakandiano");
            carnaval.setFecha(LocalDateTime.of(2024, 2, 15, 10, 0));
            carnaval.setHorario("10:00 - 20:00");
            carnaval.setDescripcion("El carnaval más colorido de Wakanda con desfiles y música.");
            eventoRepository.save(carnaval);

            // Lugares turísticos
            LugarTuristico museo = new LugarTuristico();
            museo.setNombre("Museo de Historia de Wakanda");
            museo.setUbicacion("Centro Histórico");
            museo.setDescripcion("El museo más grande de Wakanda con reliquias y artefactos históricos.");
            museo.setHistoria("Fundado en 1950, alberga más de 10,000 piezas históricas.");
            lugarTuristicoRepository.save(museo);

            LugarTuristico estatua = new LugarTuristico();
            estatua.setNombre("Estatua del Rey T'Chaka");
            estatua.setUbicacion("Plaza Central");
            estatua.setDescripcion("Un monumento en honor al antiguo rey de Wakanda.");
            estatua.setHistoria("Construida en 1995 para conmemorar su legado.");
            lugarTuristicoRepository.save(estatua);

            // Restaurantes
            Restaurante comidaTipica = new Restaurante();
            comidaTipica.setNombre("Sabores de Wakanda");
            comidaTipica.setUbicacion("Barrio Cultural");
            comidaTipica.setTipo("Comida Típica");
            comidaTipica.setHorario("12:00 - 22:00");
            comidaTipica.setMenu("Menú: Jollof Rice, Egusi Soup, Wakandan Beer.");
            restauranteRepository.save(comidaTipica);

            Restaurante streetFood = new Restaurante();
            streetFood.setNombre("Wakanda Street Eats");
            streetFood.setUbicacion("Zona Norte");
            streetFood.setTipo("Street Food");
            streetFood.setHorario("10:00 - 23:00");
            streetFood.setMenu("Menú: BBQ Wakandiano, tacos exóticos, bebidas frescas.");
            restauranteRepository.save(streetFood);

            // Actividades culturales
            ActividadCultural cataComida = new ActividadCultural();
            cataComida.setNombre("Cata de Comida Wakandiana");
            cataComida.setDescripcion("Prueba los mejores platos tradicionales de Wakanda.");
            cataComida.setHorario("15:00 - 17:00");
            cataComida.setDuracion("2 horas");
            cataComida.setPrecio(25.0);
            actividadCulturalRepository.save(cataComida);

            ActividadCultural paseoCiudad = new ActividadCultural();
            paseoCiudad.setNombre("Paseo por la Ciudad");
            paseoCiudad.setDescripcion("Un recorrido guiado por los principales puntos históricos de Wakanda.");
            paseoCiudad.setHorario("09:00 - 11:00");
            paseoCiudad.setDuracion("2 horas");
            paseoCiudad.setPrecio(15.0);
            actividadCulturalRepository.save(paseoCiudad);

            // Mensaje de inicialización
            System.out.println("Datos de ejemplo inicializados en la base de datos.");
        };
    }
}
