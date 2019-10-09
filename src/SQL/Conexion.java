/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nikolas
 */
public class Conexion {
    public Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/analisis";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "admin");
            System.out.println("Conexión establecida como root");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+ e);
            System.err.println(e.getMessage());
        }
        return con;
    }
}
