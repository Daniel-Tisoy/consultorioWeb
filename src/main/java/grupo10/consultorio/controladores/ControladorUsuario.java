/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Usuario;
import grupo10.consultorio.servicio.ServicioUsuario;
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
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @PostMapping("/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Usuario obj = servicioUsuario.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id) {
        Usuario obj = servicioUsuario.findById(id);
        if (obj != null) {
            servicioUsuario.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
        Usuario obj = servicioUsuario.findById(usuario.getIdUsuario());

        if (obj != null) {
            obj.setNombre(usuario.getNombre());
            obj.setApellido(usuario.getApellido());
            obj.setContrasenia(usuario.getContrasenia());
            obj.setCorreo(usuario.getCorreo());
            obj.setIdRol(usuario.getIdRol());
            servicioUsuario.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Usuario> consultarTodo() {
        return servicioUsuario.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Integer id) {
        Usuario obj = servicioUsuario.findById(id);
        if (obj != null) {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
