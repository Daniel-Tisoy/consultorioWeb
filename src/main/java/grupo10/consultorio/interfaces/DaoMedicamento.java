/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo10.consultorio.interfaces;

import grupo10.consultorio.modelos.Medicamento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ltisoy
 */
public interface DaoMedicamento extends CrudRepository<Medicamento, Integer> {
    
}
