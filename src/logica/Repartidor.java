package logica;

import java.util.Random;

public class Repartidor extends Thread{

    private String id;
    private int numProductos;
    private Producto productoARepartir;
    private Intermediario inter;
    private static boolean entregados=false;
    
    public Repartidor (String id, Intermediario inter){
        
        this.id=id;
        this.numProductos=0;
        this.productoARepartir=null;
        this.inter=inter;

    }

    public void repartir(){

        productoARepartir=inter.darProducto();
        System.out.println("Producto: "+productoARepartir.getId()+" lo tiene el repartidor: "+ id);
        inter.setProducto();
        System.out.println("Entregando producto: "+productoARepartir.getId()+ " por el repartidor: "+this.id);
        Random rn= new Random();
        int aleatorio= rn.nextInt(10000-3000+1)+3000;
        try {
            sleep(aleatorio);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        productoARepartir.setEntregado();
        productoARepartir=null;
        numProductos++;
        System.out.println("El repartidor "+id+" ha entregado "+numProductos+" productos");

    }

    public static void setEntregado(){
        entregados= true;
    }


     public void run(){

        while(!entregados){
            repartir();
            
        }

     }

 
    
}
