/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Diagnostico;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioDiagnostico {

    public Diagnostico save(Diagnostico diagnostico);

    public void delete(Integer id);

    public Diagnostico findById(Integer id);

    public List<Diagnostico> findAll();
}
