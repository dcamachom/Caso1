package logica;

public class Despachador extends Thread{

    private int numProductos;
    private int numRepartidores;
    private Producto productoADespachar;
    private Bodega bodega;

    public Despachador (int numProductos, int numRepartidores, Bodega bodega){
        
        this.numProductos= numProductos;
        this.numRepartidores= numRepartidores;
        this.productoADespachar=null;
        this.bodega=bodega;
        
    }

    public void esperaActiva(){

        System.out.println("Despachador en espera activa");

    }

    public synchronized void despachar(){

        while (bodega.getNumOcupacion()<=0){

            esperaActiva();            

        }

        productoADespachar=bodega.despacharProducto();
        notify();
        //entregar a repartidor 

    }
    
}
