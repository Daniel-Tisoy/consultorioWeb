/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoRol;
import grupo10.consultorio.modelos.Rol;
import grupo10.consultorio.servicio.ServicioRol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioRol implements ServicioRol {

    @Autowired
    private DaoRol daoRol;

    @Override
    @Transactional(readOnly = false)
    public Rol save(Rol rol) {
        return daoRol.save(rol);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String id) {
        daoRol.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(String id) {
        return daoRol.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return (List<Rol>) daoRol.findAll();
    }

}
