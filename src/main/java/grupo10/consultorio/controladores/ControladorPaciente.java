/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Paciente;
import grupo10.consultorio.servicio.ServicioPaciente;
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
@RequestMapping(value = "/paciente")
public class ControladorPaciente {

    @Autowired
    private ServicioPaciente servicioPaciente;

    @PostMapping("/")
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente paciente) {
        Paciente obj = servicioPaciente.save(paciente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable Integer id) {
        Paciente obj = servicioPaciente.findById(id);
        if (obj != null) {
            servicioPaciente.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Paciente> editar(@RequestBody Paciente paciente) {
        Paciente obj = servicioPaciente.findById(paciente.getDocumento());
        if (obj != null) {
            obj.setApellido(paciente.getApellido());
            obj.setEps(paciente.getEps());
            obj.setFechaNacimiento(paciente.getFechaNacimiento());
            obj.setHistoria(paciente.getHistoria());
            obj.setNombre(paciente.getNombre());
            obj.setSexo(paciente.getSexo());
            servicioPaciente.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Paciente> consultarTodo() {
        return servicioPaciente.findAll();
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Paciente> consultarPorId(@PathVariable Integer id){
        Paciente obj = servicioPaciente.findById(id);
        if (obj != null){
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
