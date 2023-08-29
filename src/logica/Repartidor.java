package logica;

public class Repartidor {

    private String id;
    private int numProductos;
    private Producto productoARepartir;
    
    public Repartidor (String id, int numProductos){
        
        this.id=id;
        this.numProductos=numProductos;
        this.productoARepartir=null;

    }
    
}
