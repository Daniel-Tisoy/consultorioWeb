/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Medicamento;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioMedicamento {

    public Medicamento save(Medicamento medicamento);

    public void delete(Integer id);

    public Medicamento findById(Integer id);

    public List<Medicamento> findAll();

}
