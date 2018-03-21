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
public class ProfesorTiempoClompleto extends Profesor{
    private final int HORAS_SEMANALES = 40;

    public ProfesorTiempoClompleto(String cedula, String nombre, String apellido, int horasClase, String carrera) {
        super(cedula, nombre, apellido, horasClase, carrera);
    }

    @Override
    public int horasComlementarias() {
        return this.HORAS_SEMANALES - getHorasClase();
    }

    
    
}
