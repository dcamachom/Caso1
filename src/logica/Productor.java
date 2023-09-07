package logica;

public class Productor extends Thread{

    private int id;
    private int numProductos;
    private Bodega BODEGA;
    private Producto producto;

    public void run(){
        System.out.println("Soy el productor: " + id + " y produzco: " + numProductos);

        for(int i=0; i<numProductos ; i++){
            producto = crearProducto(i);
            System.out.println("El productor"+id+"creo el producto "+producto.getId());
            BODEGA.almacenar(producto);
            producto.dormirSobreProducto();

        }
    }

    public Productor (int id, int productosPorProducir, Bodega BODEGA){

        this.id=id;
        this.producto=null;
        this.numProductos=productosPorProducir;
        this.BODEGA = BODEGA;

    }

    public Producto crearProducto(int i){
        
        int productoId= Integer.parseInt(String.valueOf(id)+String.valueOf(i));
        Producto productoCreado = new Producto(productoId, this);
        return productoCreado;
    }
    
}
