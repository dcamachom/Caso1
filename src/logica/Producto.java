package logica;

public class Producto {

    private String id;
    private boolean entregado;

    public Producto (String id ){

        this.id=id;
        this.entregado=false;

    }

    public synchronized void setEntregado(){
        entregado=true;
        notifyAll();
    }

    public synchronized void reportarEntregado(){

        while(!entregado){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Producto "+id+" entregado");

    }

    public String getId(){

        return id;

    }
    
}
