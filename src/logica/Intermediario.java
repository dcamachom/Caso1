package logica;

public class Intermediario {
    
    private Producto producto;
    private static boolean entregados=false;

    public Intermediario (){
        this.producto=null;
    }

    public synchronized void recibirProducto(Producto pr){

        producto=pr;
        notifyAll();


        try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }

    public synchronized Producto darProducto (){

        while (producto==null && entregados == false){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(producto!=null){
            System.out.println("Producto: "+producto.getId()+" lo tiene el repartidor.");
            notifyAll();
        return producto;
        }

        notifyAll();
        return null;

        

    }

    public  void setProducto(){
        this.producto=null;
    }


    public synchronized void setEntregado(){
        entregados= true;
    }

    public synchronized boolean getEntregado(){
        return entregados;
    }

}
