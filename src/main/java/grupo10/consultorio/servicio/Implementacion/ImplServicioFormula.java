/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoFormula;
import grupo10.consultorio.modelos.Formula;
import grupo10.consultorio.servicio.ServicioFormula;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioFormula implements ServicioFormula {

    @Autowired
    private DaoFormula daoFormula;

    @Override
    @Transactional(readOnly = false)
    public Formula save(Formula formula) {
        return daoFormula.save(formula);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoFormula.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Formula findById(Integer id) {
        return daoFormula.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Formula> findAll() {
        return (List<Formula>) daoFormula.findAll();
    }

}
