package logica;

public class Despachador extends Thread{

    private int numProductos;
    private int numRepartidores;
    private Producto productoADespachar;
    private Bodega bodega;
    private Intermediario inter;

    public Despachador (int numProductos, int numRepartidores, Bodega bodega, Intermediario inter){
        
        this.numProductos= numProductos;
        this.numRepartidores= numRepartidores;
        this.productoADespachar=null;
        this.bodega=bodega;
        this.inter= inter;
        
    }

    public void esperaActiva(){

        System.out.println("Despachador en espera activa");

    }

    public synchronized void despachar(){

        while (bodega.getNumOcupacion()<=0){

            esperaActiva();            

        }

        productoADespachar=bodega.despacharProducto();
        
        //entregar a repartidor 
        inter.recibirProducto(productoADespachar);
        
        //espera hasta que sea entregado
        inter.esperaProductoEntregado();
        System.out.println("Producto "+productoADespachar.getId()+" ha sido recogido");
        productoADespachar=null;


    }
    
}
