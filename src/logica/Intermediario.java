package logica;

public class Intermediario {

    //esta clase tiene que ser static
    private Producto producto;

    public Intermediario (){

        this.producto=null;

    }

    public Producto geProducto(){

        return producto;

    }

    public void setProducto(Producto pr){

        this.producto=pr;

    }

    public synchronized void recibirProducto(Producto pr){

        while (!(producto==null)){

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
        
        Producto pr=producto;
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

        notify();

    }
    
}
