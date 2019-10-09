/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mrp2.Producto;

/**
 *
 * @author Nikolas
 */
public class ProductoC {
    private Connection con;

    public ProductoC(Connection con) {
        this.con = con;
    }
    
        public ArrayList<Producto> getListaP() {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM producto as p inner join duracion as d ON p.idproducto=d.idproducto";

            PreparedStatement pst = con.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            Producto prod = null;

            while (rs.next()) {
                prod = new Producto(rs.getInt("idproducto"),rs.getBoolean("linea1"),rs.getBoolean("linea2"),rs.getBoolean("linea3"));
                prod.setDuracion1(rs.getInt("duracion1"));
                prod.setDuracion2(rs.getInt("duracion2"));
                prod.setDuracion3(rs.getInt("duracion3"));
                prod.setCantidad(rs.getInt("cantidadproducir"));
                lista.add(prod);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
        
        
        public int getStock(String idp){
            int cantidad = 0;
            try {
            String consulta = "SELECT cantidad FROM producto where idproducto = "+idp+"";

            PreparedStatement pst = con.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            Producto prod = null;

            while (rs.next()) {
               
                cantidad=(rs.getInt("cantidad"));
               
                
            }

        } catch (SQLException e) {
            
            
            System.out.println(e);
        }

        return cantidad;
        
        
        }
        
        public void OrdenProduccion(String cant, String id){
            int cantidad = 0;
            try {
            String consulta = "UPDATE producto SET cantidadproducir ="+cant+" where idproducto="+id+" ";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.executeUpdate();
            Producto prod = null;

        } catch (SQLException e) {
            
            
            System.out.println(e);
        }

  
    

        
        }
        public void UpdateS(String cant, String id){
            int cantidad = 0;
            try {
            String consulta = "UPDATE producto SET cantidad ="+cant+" where idproducto="+id+" ";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.executeUpdate();
            Producto prod = null;

        } catch (SQLException e) {
            
            
            System.out.println(e);
        }
    
    
        }
}
