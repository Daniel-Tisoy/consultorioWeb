/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Usuario;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioUsuario {

    public Usuario save(Usuario usuario);

    public void delete(Integer id);

    public Usuario findById(Integer id);

    public List<Usuario> findAll();
}
