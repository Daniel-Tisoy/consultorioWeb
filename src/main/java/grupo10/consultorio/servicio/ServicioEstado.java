/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Estado;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioEstado {

    public Estado save(Estado estado);

    public void delete(Integer id);

    public Estado findById(Integer id);

    public List<Estado> findAll();
}
