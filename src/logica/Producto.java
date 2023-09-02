package logica;

public class Producto {

    private int id;
    private boolean entregado;

    public Producto (int id){

        this.id=id;
        this.entregado=false;

    }

    public void setEntregado(){
        entregado=true;
    }

    public boolean getEntregado(){
        return entregado;
    }

    public int getId(){
        return id;
    }
    
}
