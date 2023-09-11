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

        inter.setEntregado();
        System.out.println("Ya no hay productos para el despachador");

    }

    public void esperaActiva(){
       try {
        sleep(5000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    }

    public void despachar(){

        if(bodega.getNumOcupacion()==0){
        System.out.println("Despachador en espera activa, no hay nada en la bodega por lo que sumo 5 + 5  = 10");
        }

        while (bodega.getNumOcupacion()==0){
            esperaActiva();            
        }

        productoADespachar = bodega.retirar();
        if (productoADespachar==null){
            despachar();
        }

        else{

            System.out.println(("El despachador esta esperando a un repartidor"));
            inter.recibirProducto(productoADespachar);
            productoADespachar=null;


        }


    }


    
}
