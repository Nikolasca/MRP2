/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

import SQL.Conexion;
import SQL.ProductoC;
import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public class MRP2 {

    /**
     * @param args the command line arguments
     */
int linea3 = 0;
        
            public MRP2(String cant1, String cant2, String cant3) {
              
  

        Conexion con = new Conexion();
        ProductoC proc = new ProductoC(con.conectar());
        
        
        int p1 = Integer.parseInt(cant1)-proc.getStock(""+1);
        int p2 = Integer.parseInt(cant2)-proc.getStock(""+2);
        int p3 = Integer.parseInt(cant3)-proc.getStock(""+3);
        //System.out.print("OOOOOOOOO"+p1);
        
        proc.OrdenProduccion(""+p1, ""+1);
        proc.OrdenProduccion(""+p2, ""+2);
        proc.OrdenProduccion(""+p3, ""+3);
        
        proc.UpdateS(""+p1, ""+1);
        proc.UpdateS(""+p2, ""+2);
        proc.UpdateS(""+p3, ""+3);
        
        
        
        
        
         ArrayList<Producto> productos = proc.getListaP();
         
      
        

        ArrayList<Producto> producto1 = new ArrayList<Producto>();
        ArrayList<Producto> producto2 = new ArrayList<Producto>();
        ArrayList<Producto> producto3 = new ArrayList<Producto>();
           int cantidadp1 = productos.get(0).cantidad;
        
           for(int i=0;i<cantidadp1;i++){
               Producto  productotipo1 = new Producto();
               productotipo1.setDuracion1(productos.get(0).duracion1);
                productotipo1.setDuracion2(productos.get(0).duracion2);
                 productotipo1.setDuracion3(productos.get(0).duracion3);
                 productotipo1.setL1(true);
                  productotipo1.setL2(true);
                   productotipo1.setL3(true);
                   productotipo1.setTipo(1);
                   productotipo1.setId(100+i);
                   producto1.add(productotipo1);
           
           }
            int cantidadp2 = productos.get(1).cantidad;
             
           
               for(int i=0;i<cantidadp2;i++){
               Producto  productotipo2 = new Producto();
                productotipo2.setDuracion1(productos.get(1).duracion1);
                productotipo2.setDuracion2(productos.get(1).duracion2);
                 productotipo2.setDuracion3(productos.get(1).duracion3);
                 productotipo2.setL1(true);
                  productotipo2.setL2(true);
                   productotipo2.setL3(false);
                     productotipo2.setId(200+i);
                   productotipo2.setTipo(2);
                   producto2.add(productotipo2);
           
           }
                 int cantidadp3 = productos.get(2).cantidad;
             
           
               for(int i=0;i<cantidadp3;i++){
               Producto  productotipo2 = new Producto();
                productotipo2.setDuracion1(productos.get(2).duracion1);
                productotipo2.setDuracion2(productos.get(2).duracion2);
                 productotipo2.setDuracion3(productos.get(2).duracion3);
                 productotipo2.setL1(true);
                  productotipo2.setL2(false);
                   productotipo2.setL3(true);
                   productotipo2.setId(300+i);
                   productotipo2.setTipo(3);
                   producto3.add(productotipo2);
           
           }
               
    System.out.print(cantidadp1);
             System.out.println(cantidadp2);
            // System.out.println(cantidadp3);
           
           
     
        //System.out.print(p4.id +"SEXOOOOOOOOOOO");

        int cantidadt1 = 0;
        int cantidadt2 = 0;
        int cantidadt3 = 0;

        int Total1 = (producto1.get(0).getDuracion1() * producto1.size());
        int Total2 = (producto1.get(0).getDuracion2() * producto1.size());
        int Total3 = (producto1.get(0).getDuracion3() * producto1.size());

        int Total4 = (producto2.get(0).getDuracion1() * producto2.size());
        int Total5 = (producto2.get(0).getDuracion2() * producto2.size());
        int Total6 = (producto2.get(0).getDuracion3() * producto2.size());

        int Total7 = (producto2.get(0).getDuracion1() * producto3.size());
        int Total8 = (producto2.get(0).getDuracion2() * producto3.size());
        int Total9 = (producto2.get(0).getDuracion3() * producto3.size());

        int Totalt = Total1 + Total2 + Total3 + Total4 + Total5 + Total6 + Total7 + Total8 + Total9;

        Linea l1 = new Linea(Totalt);
        Linea l2 = new Linea(Totalt);
        Linea l3 = new Linea(Totalt);
 
        if (producto1.size() > producto2.size() && producto1.size() > producto3.size()) {

            if (producto1.get(0).getL1() == true) {

                System.out.println("Pitin " + Total1);
                for (int j = 0; j < Total1; j++) {
                    l1.setCapacidad(Totalt);
                    System.out.println("HOLA" + j);

                    l1.hola[j] = producto1.get(j);

                }

            }
            if (producto1.get(0).getL2() == true) {

                for (int j = Total1; j < Total1 + Total2; j++) {

                    System.out.println("TOTAL" + (Total1));
                    // System.out.println((Total1+1));
                    System.out.print("Choko2 segundo ciclo" + j);
                    l2.setCapacidad(Totalt);
                    l2.hola[j] = producto1.get(j - Total1);

                }

            }
            if (producto1.get(0).getL3() == true) {
                for (int i = 0; i < producto1.size(); i++) {
                    cantidadt3 = cantidadt2 + producto1.get(i).duracion3;
                    for (int j = Total1 + Total2; j < Total1 + Total2 + Total3; j++) {
                        l3.setCapacidad(Totalt);
                        l3.hola[j] = producto1.get(j-(Total1 + Total2));

                    }

                }

            }
            if (producto2.size() > producto3.size() && producto2.get(0).l1 == true) {
                for (int i = Total1; i < Total1 + Total4; i++) {
                    l1.hola[i] = producto2.get(i - Total1);

                }
                if (producto2.size() > producto3.size() && producto2.get(0).l2 == true) {
                    for (int i = Total1 + Total2; i < Total1 + Total2 + Total5; i++) {
                        l2.hola[i] = producto2.get(i - (Total1 + Total2));
                    }

                }

            }
            if (producto3.get(0).getL1() == true) {

                for (int i = Total1 + Total4; i < Total1 + Total4 + Total7; i++) {
                    System.out.println("Choko care monda");
                    l1.hola[i] = producto3.get(i - (Total1 + Total4));

                }
                if (producto3.get(0).getL3() == true) {
                    for (int i = Total1 + Total2 + Total3; i < Total1 + Total2 + Total3 + Total9; i++) {
                        l3.hola[i] = producto3.get(i - (Total1 + Total2 + Total3));
                        // System.out.println(l3.hola.length);
                    }

                }

            }

        }

        for (int i = 0; i < l1.hola.length; i++) {
            if (l1.hola[i] != null) {
                System.out.println("L1Pos" + i + "ID" + l1.hola[i].getId());
            }
        }
        for (int i = 0; i < l2.hola.length; i++) {
            if (l2.hola[i] != null) {
                System.out.println("L2Pos" + i + "ID2" + l2.hola[i].getId());
            }
        }
        for (int i = 0; i < l3.hola.length; i++) {
            if (l3.hola[i] != null) {
                System.out.println("L3Pos" + i + "ID3" + l3.hola[i].getId());
            }
        }
        for (int i = l3.hola.length-1; i>0;i--){
            if(l3.hola[i]!=null){
                this.linea3 = i;
                break;
            
            }
        
        
        }
        
        String ruta = "/Users/nikol/Desktop/salida.xls";
        Excel nuevo = new Excel();
        nuevo.CrearExcel(l1, l2, l3, ruta);

    }

    public int getLinea3() {
        return linea3;
    }

  
       

}

