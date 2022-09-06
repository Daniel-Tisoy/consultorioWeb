/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Rol;
import grupo10.consultorio.servicio.ServicioRol;
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
@RequestMapping("/rol")
public class ControladorRol {

    @Autowired
    private ServicioRol servicioRol;

    @PostMapping("/")
    public ResponseEntity<Rol> agregar(@RequestBody Rol rol) {
        Rol obj = servicioRol.save(rol);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rol> eliminar(@PathVariable String id) {
        Rol obj = servicioRol.findById(id);
        if (obj != null) {
            servicioRol.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Rol> editar(@RequestBody Rol rol) {
        Rol obj = servicioRol.findById(rol.getIdRol());

        if (obj != null) {
            obj.setRol(rol.getRol());
            servicioRol.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Rol> consultarTodo() {
        return servicioRol.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Rol> consultarPorId(@PathVariable String id) {
        Rol obj = servicioRol.findById(id);
        if (obj != null) {
            System.out.println("objeto enviado");
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
