/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoPaciente;
import grupo10.consultorio.modelos.Paciente;
import grupo10.consultorio.servicio.ServicioPaciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioPaciente implements ServicioPaciente {

    @Autowired
    private DaoPaciente daoPaciente;

    @Override
    @Transactional(readOnly = false)
    public Paciente save(Paciente paciente) {
        return daoPaciente.save(paciente);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoPaciente.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findById(Integer id) {
        return daoPaciente.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return (List<Paciente>) daoPaciente.findAll();
    }

}
