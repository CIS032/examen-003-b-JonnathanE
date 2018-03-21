/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_programacion;

/**
 *
 * @author JonnathanE
 */
public class ProfesorTiempoParcial extends Profesor{
    private int horasSemanales;

    public ProfesorTiempoParcial(int horasSemanales, String cedula, String nombre, String apellido, int horasClase, String carrera) {
        super(cedula, nombre, apellido, horasClase, carrera);
        this.horasSemanales = horasSemanales;
    }

    @Override
    public int horasComlementarias() {
        return this.horasSemanales - getHorasClase();
    }
    
    
}
