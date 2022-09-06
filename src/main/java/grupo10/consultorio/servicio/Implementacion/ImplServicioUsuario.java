/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.servicio.Implementacion;

import grupo10.consultorio.interfaces.DaoUsuario;
import grupo10.consultorio.modelos.Usuario;
import grupo10.consultorio.servicio.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltisoy
 */
@Service
public class ImplServicioUsuario implements ServicioUsuario {

    @Autowired
    private DaoUsuario daoUsuario;

    @Override
    @Transactional(readOnly = false)
    public Usuario save(Usuario usuario) {
        return daoUsuario.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoUsuario.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {
        return daoUsuario.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) daoUsuario.findAll();
    }

}
