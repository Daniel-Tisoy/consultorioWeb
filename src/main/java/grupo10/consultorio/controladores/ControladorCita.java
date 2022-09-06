/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Cita;
import grupo10.consultorio.servicio.ServicioCita;
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
@RequestMapping(value = "/cita")
public class ControladorCita {

    @Autowired
    private ServicioCita servicioCita;

    @PostMapping("/")
    public ResponseEntity<Cita> agregar(@RequestBody Cita cita) {
        Cita obj = servicioCita.save(cita);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cita> eliminar(@PathVariable Integer id) {
        Cita obj = servicioCita.findById(id);
        if (obj != null) {
            servicioCita.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Cita> editar(@RequestBody Cita cita) {
        Cita obj = servicioCita.findById(cita.getIdCita());

        if (obj != null) {
            obj.setEstado(cita.getEstado());
            obj.setFecha(cita.getFecha());
            obj.setIdpaciente(cita.getIdpaciente());
            obj.setLugar(cita.getLugar());
            servicioCita.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Cita> consultarTodo() {
        return servicioCita.findAll();
    }

    @GetMapping("/list/{id}/")
    public ResponseEntity<Cita> consultarPorId(@PathVariable Integer id) {
        Cita obj = servicioCita.findById(id);
        if (obj != null) {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
