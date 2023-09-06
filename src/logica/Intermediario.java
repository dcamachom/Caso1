package logica;

public class Intermediario {
    
    private Producto producto;

    public Intermediario (){
        this.producto=null;
    }

    public synchronized void recibirProducto(Producto pr){

        while (producto!=null){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        producto=pr;
        notify();

    }

    public synchronized Producto darProducto (){

        while (producto==null){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Producto pr= producto;
        this.producto=null;
        notify();
        return pr;

    }

    public synchronized void esperaProductoEntregado(){

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
