/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoMedicamento;
import grupo10.consultorio.modelos.Medicamento;
import grupo10.consultorio.servicio.ServicioMedicamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioMedicamento implements ServicioMedicamento {

    @Autowired
    private DaoMedicamento daoMedicamento;

    @Override
    @Transactional(readOnly = false)
    public Medicamento save(Medicamento medicamento) {
        return daoMedicamento.save(medicamento);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoMedicamento.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Medicamento findById(Integer id) {
        return daoMedicamento.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicamento> findAll() {
        return (List<Medicamento>) daoMedicamento.findAll();
    }

}
