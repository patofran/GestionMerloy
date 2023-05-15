
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
        String DBpass = "daniel110704";
        Statement stmt;
        ArrayList<DatosPagos> pagos;
        ResultSet consulta;

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conBD = DriverManager.getConnection(servidor + basedatos, DBuser, DBpass);
            } catch (SQLException error) {
                System.out.println("Error al conectar a BD: " + error.getMessage());
            } catch (Exception e){

            }

        pagos = new ArrayList<>();
        
        try {
            stmt = conBD.createStatement();
            consulta = stmt.executeQuery("SELECT * FROM cliente ");

                //cargo todos los datos de la base de datos para trabajar de manera mas comoda con los datos.
            while (consulta.next()) {
                pagos.add(new DatosPagos(consulta.getInt("codigo_cliente"), consulta.getString("forma_pago"), consulta.getString("id_transaccion"), consulta.getString("fecha_pago"), consulta.getFloat("total")));
            }
        } catch (Exception e) {
            
        }
        for (Iterator<DatosPagos> iterator = pagos.iterator(); iterator.hasNext();) {
            DatosPagos next = iterator.next();
            System.out.println(" " + next.toString());
        }
    }
}
