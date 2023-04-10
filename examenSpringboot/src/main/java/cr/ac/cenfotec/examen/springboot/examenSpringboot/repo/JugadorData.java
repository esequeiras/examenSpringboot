package cr.ac.cenfotec.examen.springboot.examenSpringboot.repo;

import cr.ac.cenfotec.examen.springboot.examenSpringboot.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorData extends JpaRepository<Jugador,Long>{
}
