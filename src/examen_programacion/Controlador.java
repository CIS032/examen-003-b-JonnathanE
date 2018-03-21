/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author JonnathanE
 */
public class Controlador {

    private final String URL = "jdbc:derby://localhost:1527/profesor";
    private final String USUARIO = "adminprofe";
    private final String CLAVE = "12345";
    private Connection conexion;
    private PreparedStatement seleccionarPersona;
    private PreparedStatement seleccionarPersonasPorApellido;
    private PreparedStatement insertarNuevaPersona;

    public Controlador() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }

    public void agregarProfesor(String cedula, String nombre, String apellido, String carrera, String tipo,
            int hora_clases, int hora_complementaria) {
        int r = 0;
        boolean satisfac = true;
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select *from profesor");
            String sqlInsert = String.format("INSERT INTO profesor VALUES('%s','%s','%s','%s', '%s', %d, %d)",
                    cedula,
                    nombre,
                    apellido,
                    carrera,
                    tipo,
                    hora_clases,
                    hora_complementaria
            );//insertando un nueva fila en la tabla
            r = sentencia.executeUpdate(sqlInsert);
            reg.close();
            sentencia.close();
            
        } catch (SQLException e) {
            System.out.println("Error AL ENVIAR CONSULTA: " + e);
            satisfac = false;
        }
        if(satisfac == true)
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO INGRESADOS SATISFACTORIAMENTE");
    }
    
    public void consultar(){
        String out = "";
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet registros = sentencia.executeQuery("select*from profesor where apellido like 'B%'");
            while (registros.next()) {
                String cedula = registros.getString("cedula");
                String nombre = registros.getString("nombre");
                String apellidos = registros.getString("apellido");
                String carrera = registros.getString("carrera");
                String tipo = registros.getString("tipo");
                int hora_clases = registros.getInt("hora_clases");
                int hora_complementaria = registros.getInt("hora_complementaria");
                
                out += cedula + " - " + nombre + " - " + apellidos + " - " + carrera + " - " + tipo + " - " + hora_clases
                        + " - " + hora_complementaria + "\n";

            }
            registros.close();
            sentencia.close();
            JOptionPane.showMessageDialog(null, out);

        } catch (SQLException ex) {
            System.out.println("Error al realizar busqueda por apellido " + ex);
        }

    }
    
    
    
    public static void main(String[] args) {
        Controlador c = new Controlador();
        c.agregarProfesor("1234567890", "Jonnathan", "Espinoza", "Sistemas", "TiempoParcial", 4, 8);
    }
}
