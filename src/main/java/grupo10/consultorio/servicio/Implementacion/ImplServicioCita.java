/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoCita;
import grupo10.consultorio.modelos.Cita;
import grupo10.consultorio.servicio.ServicioCita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioCita implements ServicioCita {

    @Autowired
    private DaoCita daoCita;

    @Override
    @Transactional(readOnly = false)
    public Cita save(Cita cita) {
        return daoCita.save(cita);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoCita.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cita findById(Integer id) {
        return daoCita.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) daoCita.findAll();
    }

}
