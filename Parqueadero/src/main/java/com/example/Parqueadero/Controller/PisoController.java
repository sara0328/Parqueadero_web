package com.example.Parqueadero.Controller;
import com.example.Parqueadero.Model.Piso;
import com.example.Parqueadero.Service.PisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/pisos")
public class PisoController {

    @Autowired
    private PisoService pisoService;

    @GetMapping("/")
    public ModelAndView viewHomePage() {
        ModelAndView personView = new ModelAndView("index");
        personView.addObject("allpisoslist", pisoService.obtenerPisos());
        return personView;
    }

    @GetMapping("/all")
    public List<Piso> obtenerPisos() {
        return pisoService.obtenerPisos();
    }

    @GetMapping("/{id}")
    public Piso obtenerPiso(@PathVariable Long id) {
        return pisoService.obtenerPiso(id);
    }

    @GetMapping("/crear")
    public ModelAndView crearPiso() {
        Piso piso = new Piso();
        ModelAndView pisoCreateView = new ModelAndView("crear");
        pisoCreateView.addObject("piso", piso);
        return pisoCreateView;
    }

    @PostMapping("/guardar")
    public RedirectView guardarPiso (@ModelAttribute("piso") Piso piso) {
        pisoService.crearPiso(piso);
        return new RedirectView("/api/pisos/");
    }

    @PutMapping("/{id}")
    public Piso actualizarPiso(@PathVariable Long id, @RequestBody Piso piso) {
        piso.setId(id);
        return pisoService.actualizarPiso(piso);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPiso(@PathVariable Long id) {
        pisoService.eliminarPiso(id);
    }

    @PutMapping("/{id}/espaciosDisponibles")
    public Piso calcularEspaciosDisponibles(@PathVariable Long id, @RequestParam int espaciosOcupados) {
        return pisoService.calcularEspaciosDisponibles(id, espaciosOcupados);
    }
    @PostMapping("/pisos")
    public Piso crearPiso(@RequestBody Piso piso) {
    return pisoService.crearPiso(piso.getCapacidadTotal(), piso.getTarifa());
    }
    
    @GetMapping("/{id}/espaciosDisponibles")
    public ResponseEntity<Integer> getEspaciosDisponibles(@PathVariable Long id) {
    Piso piso = pisoService.getPisoById(id);
    if (piso != null) {
        return ResponseEntity.ok(piso.getEspaciosDisponibles());
    } else {
        // Lanzar una excepción o retornar un código de error
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    }
}

