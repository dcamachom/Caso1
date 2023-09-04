package logica;

public class Producto {

    private int id;
    private boolean entregado;
    private Productor productor;

    public Producto (int id, Productor productor){

        this.id=id;
        this.entregado=false;
        this.productor= productor;

    }

    public void dormirSobreProducto(){
        try{
            wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Productor getProductor(){
        return this.productor;
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
