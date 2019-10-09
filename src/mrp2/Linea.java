/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public class Linea {
    int capacidad;
    Producto[] hola;
  
  

    public Linea(int capacidad) {
        this.hola = new Producto[capacidad];
        this.capacidad = capacidad;
    }

    Linea() {
      
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Producto[] getHola() {
        return hola;
    }

    public void setHola(Producto[] hola) {
        this.hola = hola;
    }

  
    
    
    
    
}
