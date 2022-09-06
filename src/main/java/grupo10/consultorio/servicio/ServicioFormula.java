/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.servicio;

import grupo10.consultorio.modelos.Formula;
import java.util.List;

/**
 *
 * @author ltisoy
 */
public interface ServicioFormula {

    public Formula save(Formula formula);

    public void delete(Integer id);

    public Formula findById(Integer id);

    public List<Formula> findAll();
}
