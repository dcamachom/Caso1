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

    public void setProductoNull (){
        this.producto=null;
        notify();
    }
    
}
