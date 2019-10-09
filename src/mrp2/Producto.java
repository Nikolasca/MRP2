/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

/**
 *
 * @author nikol
 */
public class Producto {
    int id;
    boolean l1;
    boolean l2;
    boolean l3;
    int cantidad;
    int tipo;
    int duracion1;
    int duracion2;
    int duracion3;

    public Producto(int tipo, boolean et1, boolean et2, boolean et3) {
        
        this.tipo=tipo;
        this.l1 = et1;
        this.l2 = et2;
        this.l3 = et3;
    }



    Producto() {
        this.id = (int)(Math.random() * 100) + 1;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public boolean getL1() {
        return l1;
    }

    public void setL1(boolean l1) {
        this.l1 = l1;
    }

    public boolean getL2() {
        return l2;
    }

    public void setL2(boolean l2) {
        this.l2 = l2;
    }

    public boolean getL3() {
        return l3;
    }

    public void setL3(boolean l3) {
        this.l3 = l3;
    }

    public int getDuracion1() {
        return duracion1;
    }

    public void setDuracion1(int duracion1) {
        this.duracion1 = duracion1;
    }

    public int getDuracion2() {
        return duracion2;
    }

    public void setDuracion2(int duracion2) {
        this.duracion2 = duracion2;
    }

    public int getDuracion3() {
        return duracion3;
    }

    public void setDuracion3(int duracion3) {
        this.duracion3 = duracion3;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

  
}
