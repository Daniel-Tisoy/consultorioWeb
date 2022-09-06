/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Rol;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioRol {

    public Rol save(Rol rol);

    public void delete(String id);

    public Rol findById(String id);

    public List<Rol> findAll();
}
