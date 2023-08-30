package logica;

public class Productor{

    private String id;
    //private int numProductos;
    private int productosProducidos;
    private Producto producto;
    private Bodega bodega;

    public Productor (String id, Bodega bodega){

        this.id=id;
        this.productosProducidos=0;
        this.producto=null;
        this.bodega=bodega;

    }

    public synchronized void producir (){

        String productoId= String.valueOf(Integer.parseInt(id)+productosProducidos); //idProducto= idProductor+numProducto
        producto= new Producto(productoId,this);

        bodega.addProducto(producto);
        System.out.println("Producto "+producto.getId()+" ha sido añadido a la bodega");
        productosProducidos++;
        System.out.println("El productor "+id+ " ha producido "+productosProducidos+" productos");

        //esperar que el producto sea entregado
        while(!producto.getEntregado()){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Productor "+id+" libre");

    }
    
}
