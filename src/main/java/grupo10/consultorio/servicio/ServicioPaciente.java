/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Paciente;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioPaciente {

    public Paciente save(Paciente paciente);

    public void delete(Integer id);

    public Paciente findById(Integer id);

    public List<Paciente> findAll();

}
