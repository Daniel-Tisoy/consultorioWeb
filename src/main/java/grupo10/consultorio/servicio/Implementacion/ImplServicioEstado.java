/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoEstado;
import grupo10.consultorio.modelos.Estado;
import grupo10.consultorio.servicio.ServicioEstado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioEstado implements ServicioEstado {
    
    @Autowired
    private DaoEstado daoEstado;
    
    @Override
    @Transactional(readOnly = false)
    public Estado save(Estado estado) {
        return daoEstado.save(estado);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoEstado.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estado findById(Integer id) {
        return daoEstado.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> findAll() {
        return (List<Estado>) daoEstado.findAll();
    }
}
