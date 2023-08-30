package logica;

public class Producto {

    private String id;
    private boolean entregado;

    public Producto (String id){

        this.id=id;
        this.entregado=false;

    }

    public void setEntregado(){
        entregado=true;
    }

    public boolean getEntregado(){
        return entregado;
    }

    public String getId(){
        return id;
    }
    
}
