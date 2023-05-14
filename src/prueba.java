
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patof
 */
public class prueba {
    public static void main(String[] args) {
        Connection conBD = null;
        Statement stm = null;
        String servidor = "jdbc:mysql://localhost:3306/";
        String basedatos = "jardineria";
        String DBuser = "root";
        String DBpass = "1234";
        Statement stmt;
        ResultSet resultados;
        ArrayList<Clientes> listaClientes;

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conBD = DriverManager.getConnection(servidor + basedatos, DBuser, DBpass);
            } catch (SQLException error) {
                System.out.println("Error al conectar a BD: " + error.getMessage());
            } catch (Exception e){

            }

        listaClientes = new ArrayList<>();
        
        try {
            stmt = conBD.createStatement();
            resultados = stmt.executeQuery("SELECT * FROM cliente ");

                //cargo todos los datos de la base de datos para trabajar de manera mas comoda con los datos.
            while (resultados.next()) {
                listaClientes.add(new Clientes(resultados.getInt("codigo_cliente"), resultados.getString("nombre_cliente"), resultados.getString("nombre_contacto"), resultados.getString("apellido_contacto"), resultados.getString("telefono"), resultados.getString("fax"), resultados.getString("linea_direccion1"), resultados.getString("linea_direccion2"), resultados.getString("ciudad"), resultados.getString("region"), resultados.getString("pais"), resultados.getString("codigo_postal"), resultados.getInt("codigo_empleado_rep_ventas"), resultados.getDouble("limite_credito")));
            }
        } catch (Exception e) {
            
        }
        for (Iterator<Clientes> iterator = listaClientes.iterator(); iterator.hasNext();) {
            Clientes next = iterator.next();
            System.out.println(" " + next.toString());
        }
    }
}
