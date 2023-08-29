package logica;

public class Despachador {

    private int numProductos;
    private int numRepartidores;
    private Producto productoADespachar;

    public Despachador (int numProductos, int numRepartidores){
        
        this.numProductos= numProductos;
        this.numRepartidores= numRepartidores;
        this.productoADespachar=null;
        
    }
    
}
