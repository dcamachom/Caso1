package logica;

public class Intermediario {
    
    private Producto producto;

    public Intermediario (){
        this.producto=null;
    }

    public synchronized void recibirProducto(Producto pr){

        /*while (producto!=null){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }*/

        producto=pr;
        notify();

        //esperaProductoEntregado();

    }

    public synchronized Producto darProducto (){

        while (producto==null){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Producto: "+producto.getId()+" lo tiene el repartidor.");

        notify();
        return producto;

    }

    public synchronized void setProducto(){
        this.producto=null;
    }

    public void esperaProductoEntregado(){

        while(producto!=null){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Producto "+producto.getId()+" ha sido recogido");

    }

}
