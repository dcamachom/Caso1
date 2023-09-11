package logica;

import java.util.Random;

public class Repartidor extends Thread{

    private String id;
    private int numProductos;
    private Producto productoARepartir;
    private Intermediario inter;
    
    
    public Repartidor (String id, Intermediario inter){
        
        this.id=id;
        this.numProductos=0;
        this.productoARepartir=null;
        this.inter=inter;

    }

    public void repartir(){

        productoARepartir=inter.darProducto();
        if(productoARepartir!=null){
            inter.setProducto();
            System.out.println("Entregando producto: "+productoARepartir.getId()+ " por el repartidor: "+this.id);
            Random rn= new Random();
            int aleatorio= rn.nextInt(10000-3000+1)+3000;
            try {
                sleep(aleatorio);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.numProductos++;
            System.out.println("El repartidor "+id+" entrego el producto:  "+ productoARepartir.getId() +  " ha entregado "+numProductos+" productos y se demoro: " + aleatorio+" ms");
            productoARepartir.setEntregado();
            productoARepartir=null;
        }
        
    }




     public void run(){

        while(!inter.getEntregado()){
            repartir();
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

        System.out.println("El repartidor: " + this.id+" termino");

     }

 
    
}
