/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.controladores;

import grupo10.consultorio.modelos.Medicamento;
import grupo10.consultorio.servicio.ServicioMedicamento;
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
@RequestMapping("/medicamento")
public class ControladorMedicamento {

    @Autowired
    private ServicioMedicamento servicioMedicamento;

    @PostMapping("/")
    public ResponseEntity<Medicamento> agregar(@RequestBody Medicamento medicamento) {
        Medicamento obj = servicioMedicamento.save(medicamento);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medicamento> eliminar(@PathVariable Integer id) {
        Medicamento obj = servicioMedicamento.findById(id);
        if (obj != null) {
            servicioMedicamento.delete(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Medicamento> editar(@RequestBody Medicamento medicamento) {
        Medicamento obj = servicioMedicamento.findById(medicamento.getIdMedicamento());

        if (obj != null) {
            obj.setNombre(medicamento.getNombre());
            obj.setIndicaciones(medicamento.getIndicaciones());
            servicioMedicamento.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Medicamento> consultarTodo() {
        return servicioMedicamento.findAll();
    }

    @GetMapping("/list/{id}/")
    public ResponseEntity<Medicamento> consultarPorId(@PathVariable Integer id) {
        Medicamento obj = servicioMedicamento.findById(id);
        if (obj != null) {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
