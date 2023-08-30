package logica;

public class Repartidor {

    private String id;
    private int numProductos;
    private Producto productoARepartir;
    private Intermediario inter;
    
    public Repartidor (String id, int numProductos, Intermediario inter){
        
        this.id=id;
        this.numProductos=numProductos;
        this.productoARepartir=null;
        this.inter=inter;

    }

    public synchronized void repartir(){



    }
    
}
