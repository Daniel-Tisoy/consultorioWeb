/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoDiagnostico;
import grupo10.consultorio.modelos.Diagnostico;
import grupo10.consultorio.servicio.ServicioDiagnostico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioDiagnostico implements ServicioDiagnostico {

    @Autowired
    private DaoDiagnostico daoDiagnostico;

    @Override
    @Transactional(readOnly = false)
    public Diagnostico save(Diagnostico diagnostico) {
        return daoDiagnostico.save(diagnostico);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoDiagnostico.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Diagnostico findById(Integer id) {
        return daoDiagnostico.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Diagnostico> findAll() {
        return (List<Diagnostico>) daoDiagnostico.findAll();
    }

}
