/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Cita;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioCita {

    public Cita save(Cita cita);

    public void delete(Integer id);

    public Cita findById(Integer id);

    public List<Cita> findAll();
}
