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
        for(int i=0; i<numProductores; i++){
            while(productosPorProductor[i]>0){
                despachar();
                
                productosPorProductor[i]= productosPorProductor[i]-1;
            }
        }

       
    }

    public void tomarProducto(){
        
    }

    public void esperaActiva(){

        int suma = 5+5;
        System.out.println("Despachador en espera activa, no hay nada en la bodega por lo que sumo 5 + 5  = " + suma);

    }

    public synchronized void despachar(){

        while (bodega.getNumOcupacion()==0){
            esperaActiva();            
        }

        productoADespachar = bodega.retirar();

        //entregar a repartidor 

    }
    
}
