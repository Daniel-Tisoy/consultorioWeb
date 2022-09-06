/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Diagnostico;
import grupo10.consultorio.servicio.ServicioDiagnostico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ltisoy
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/diagnostico")
public class ControladorDiagnostico {

    @Autowired
    private ServicioDiagnostico servicioDiagnostico;

    @PostMapping("/")
    public ResponseEntity<Diagnostico> agregar(@RequestBody Diagnostico diagnostico) {
        Diagnostico obj = servicioDiagnostico.save(diagnostico);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Diagnostico> eliminar(@PathVariable Integer id) {
        Diagnostico obj = servicioDiagnostico.findById(id);
        if (obj != null) {
            servicioDiagnostico.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Diagnostico> editar(@RequestBody Diagnostico diagnostico) {
        Diagnostico obj = servicioDiagnostico.findById(diagnostico.getIdDiagnostico());

        if (obj != null) {
            obj.setCita(diagnostico.getCita());
            obj.setMedico(diagnostico.getMedico());
            obj.setObservacion(diagnostico.getObservacion());
            obj.setPaciente(diagnostico.getPaciente());
            obj.setTitulo(diagnostico.getTitulo());
            servicioDiagnostico.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public List<Diagnostico> consultarTodo() {
        return servicioDiagnostico.findAll();
    }

    @GetMapping("/list/{id}/")
    public ResponseEntity<Diagnostico> consultarPorId(@PathVariable Integer id) {
        Diagnostico obj = servicioDiagnostico.findById(id);
        if (obj != null) {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
