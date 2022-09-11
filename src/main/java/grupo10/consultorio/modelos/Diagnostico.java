/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo10.consultorio.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ltisoy
 */
@Entity
@Table(name = "diagnostico")
//@JsonIgnoreProperties(value = {"paciente"},allowGetters = true)
public class Diagnostico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico")
    private int idDiagnostico;
    @ManyToOne
    @JoinColumn(name = "id_cita")
    private Cita cita;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Usuario medico;
    @Column(name = "descripcion")
    private String titulo;
    @Column(name = "observacion")
    private String observacion;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "formula",
        joinColumns = @JoinColumn(name = "id_diagnostico"),
        inverseJoinColumns = @JoinColumn(name = "id_medicamento"))
    private List<Medicamento> medicamentos;

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

}
