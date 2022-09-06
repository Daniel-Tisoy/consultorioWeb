/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Estado;
import grupo10.consultorio.servicio.ServicioEstado;
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
@RequestMapping(value = "/estado")
public class ControladorEstado {

    @Autowired
    private ServicioEstado servicioEstado;

    @PostMapping("/")
    public ResponseEntity<Estado> agregar(@RequestBody Estado estado) {
        Estado obj = servicioEstado.save(estado);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estado> eliminar(@PathVariable Integer id) {
        Estado obj = servicioEstado.findById(id);
        if (obj != null) {
            servicioEstado.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Estado> editar(@RequestBody Estado estado) {
        Estado obj = servicioEstado.findById(estado.getIdEstado());

        if (obj != null) {
            obj.setNombre(estado.getNombre());
            servicioEstado.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Estado> consultarTodo() {
        return servicioEstado.findAll();
    }

    @GetMapping("/list/{id}/")
    public ResponseEntity<Estado> consultarPorId(@PathVariable Integer id) {
        Estado obj = servicioEstado.findById(id);
        if (obj != null) {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
