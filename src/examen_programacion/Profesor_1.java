/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_programacion;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author JonnathanE
 */
@Entity
@Table(name = "PROFESOR", catalog = "", schema = "ADMINPROFE")
@NamedQueries({
    @NamedQuery(name = "Profesor_1.findAll", query = "SELECT p FROM Profesor_1 p")
    , @NamedQuery(name = "Profesor_1.findByCedula", query = "SELECT p FROM Profesor_1 p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Profesor_1.findByNombre", query = "SELECT p FROM Profesor_1 p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor_1.findByApellido", query = "SELECT p FROM Profesor_1 p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesor_1.findByCarrera", query = "SELECT p FROM Profesor_1 p WHERE p.carrera = :carrera")
    , @NamedQuery(name = "Profesor_1.findByTipo", query = "SELECT p FROM Profesor_1 p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Profesor_1.findByHoraClases", query = "SELECT p FROM Profesor_1 p WHERE p.horaClases = :horaClases")
    , @NamedQuery(name = "Profesor_1.findByHoraComplementaria", query = "SELECT p FROM Profesor_1 p WHERE p.horaComplementaria = :horaComplementaria")})
public class Profesor_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "HORA_CLASES")
    private Integer horaClases;
    @Column(name = "HORA_COMPLEMENTARIA")
    private Integer horaComplementaria;

    public Profesor_1() {
    }

    public Profesor_1(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        String oldCedula = this.cedula;
        this.cedula = cedula;
        changeSupport.firePropertyChange("cedula", oldCedula, cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        String oldCarrera = this.carrera;
        this.carrera = carrera;
        changeSupport.firePropertyChange("carrera", oldCarrera, carrera);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Integer getHoraClases() {
        return horaClases;
    }

    public void setHoraClases(Integer horaClases) {
        Integer oldHoraClases = this.horaClases;
        this.horaClases = horaClases;
        changeSupport.firePropertyChange("horaClases", oldHoraClases, horaClases);
    }

    public Integer getHoraComplementaria() {
        return horaComplementaria;
    }

    public void setHoraComplementaria(Integer horaComplementaria) {
        Integer oldHoraComplementaria = this.horaComplementaria;
        this.horaComplementaria = horaComplementaria;
        changeSupport.firePropertyChange("horaComplementaria", oldHoraComplementaria, horaComplementaria);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor_1)) {
            return false;
        }
        Profesor_1 other = (Profesor_1) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen_programacion.Profesor_1[ cedula=" + cedula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
