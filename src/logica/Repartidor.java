package logica;

public class Repartidor {

    private String id;
    private int numProductos;
    private Producto productoARepartir;
    private Intermediario inter;
    
    public Repartidor (String id, int numProductos, Intermediario inter){
        
        this.id=id;
        this.numProductos=0;
        this.productoARepartir=null;
        this.inter=inter;

    }

    public void repartir(){

        productoARepartir=inter.darProducto();
        System.out.println("Entregando producto: "+productoARepartir.getId()+ " por el repartidor: "+this.id);
        productoARepartir.setEntregado();
        productoARepartir.notify();
        productoARepartir=null;
        numProductos++;
        System.out.println("El repartidor "+id+" ha entregado "+numProductos+" productos");

    }

    /**
     * Falta hacer el método Run, hay que verificar si ya todos los productos fueron entregados.
     * Para esto se necesita ayuda del despachador
     */
    
}
