package cr.ac.cenfotec.examen.springboot.examenSpringboot.controllers;


import cr.ac.cenfotec.examen.springboot.examenSpringboot.domain.Jugador;
import org.springframework.stereotype.Controller;
import cr.ac.cenfotec.examen.springboot.examenSpringboot.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @RequestMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @RequestMapping("/guardar")
    public String guardarPage(Model model) {
        model.addAttribute(new Jugador());
        return "guardar";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarAction(Jugador jugador, BindingResult result, Model model) {
        jugadorService.guardarJugador(jugador);
        return "index";
    }
    @RequestMapping(value = "/modificarJugador/{id}", method = RequestMethod.POST)
    public String modificarAction(Model model,Jugador jugador,@PathVariable long id) {
        Optional<Jugador> jugadorMod = jugadorService.getId(id);
        Jugador uptate=jugadorMod.get();
        uptate.setEstado(jugador.isEstado());
        jugadorService.guardarJugador(uptate);
        return "index";
    }
    @RequestMapping("/datosJugador/{id}")
    public String recuperarDatosJugador(Model model, @PathVariable long id) {

        Optional<Jugador> jugador = jugadorService.getId(id);
        model.addAttribute("datos", jugador.get());
        model.addAttribute(jugador.get());
        return "mostrarDatos";
    }
    @RequestMapping("/listar")
    public String listarPage(Model model) {
        model.addAttribute("jugadores", jugadorService.listar());
        return "listar";
    }


    @RequestMapping("/listarSegunEstado/{estado}")
    public String listarSegunEstado(Model model, @PathVariable boolean estado) {

        List<Jugador> jugadores=jugadorService.listar();
        List<Jugador> jugadoresEstado = new ArrayList<>();
        for (Jugador jug: jugadores) {
            if (jug.isEstado()==estado){
                System.out.println(jug.getNombreCompleto());
                jugadoresEstado.add(jug);
            }
        }
        model.addAttribute("jugadores", jugadoresEstado);
        return "listar";
    }
}
