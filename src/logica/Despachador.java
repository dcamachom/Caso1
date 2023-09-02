package logica;

public class Despachador extends Thread{

    private int numProductores;
    private int numRepartidores;
    private int[] productosPorProductor;
    private Producto productoADespachar;
    private Bodega bodega;

    public Despachador (int N, int M, Bodega BODEGA, int[] productosPorProductor){
        
        this.numProductores= N;
        this.numRepartidores= M;
        this.productoADespachar=null;
        this.bodega=BODEGA;
        this.productosPorProductor=productosPorProductor;
        
    }

    public void run(){
       
    }

    public void tomarProducto(){
        
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
