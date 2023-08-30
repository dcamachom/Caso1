package logica;

public class Producto {

    private String id;
    private boolean entregado;
    private boolean recogido;
    private Productor productor;

    public Producto (String id, Productor productor){

        this.id=id;
        this.entregado=false;
        this.recogido=false;
        this.productor=productor;

    }

    public synchronized void setEntregado(){
        entregado=true;
        notify();
    }

    public boolean getEntregado(){
        return entregado;
    }

    public String getId(){
        return id;
    }

    public boolean getRecogido(){
        return recogido;
    }
    
}
