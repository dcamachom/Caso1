package logica;

public class Despachador extends Thread{

    private int numProductores;
    private int numRepartidores;
    private int[] productosPorProductor;
    private Producto productoADespachar;
    private Bodega bodega;
    private Intermediario inter;

    public Despachador (int N, int M, Bodega BODEGA, int[] productosPorProductor, Intermediario inter){
        
        this.numProductores= N;
        this.numRepartidores= M;
        this.productoADespachar=null;
        this.bodega=BODEGA;
        this.productosPorProductor=productosPorProductor;
        this.inter=inter;
        
    }



    public void run(){
        for(int i=0; i<numProductores; i++){
            while(productosPorProductor[i]>0){
                despachar();
                
                productosPorProductor[i]= productosPorProductor[i]-1;
            }
        }

       
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
        inter.recibirProducto(productoADespachar);
        
        //espera hasta que sea entregado
        System.out.println("Despachador en espera a que el producto lo tenga un repartidor");
        inter.esperaProductoEntregado();
    }
    
}
