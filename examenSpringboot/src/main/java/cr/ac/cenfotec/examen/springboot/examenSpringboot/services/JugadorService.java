package cr.ac.cenfotec.examen.springboot.examenSpringboot.services;

import cr.ac.cenfotec.examen.springboot.examenSpringboot.domain.Jugador;
import cr.ac.cenfotec.examen.springboot.examenSpringboot.repo.JugadorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    JugadorData jugadorRepo;
    public void guardarJugador(Jugador nuevo){
        jugadorRepo.save(nuevo);

    }

    public List<Jugador> listar() {
        return jugadorRepo.findAll();
    }
    public Optional<Jugador> getId(long id){
        return jugadorRepo.findById(id);

    }
}
