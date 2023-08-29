package logica;

public class Productor {

    private String id;
    private int numProductos;
    private int productosProducidos;
    private Producto producto;

    public Productor (String id, int numProductos){

        this.id=id;
        this.numProductos=numProductos;
        this.productosProducidos=0;
        this.producto=null;

    }
    
}
