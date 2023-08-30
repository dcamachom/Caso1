package logica;

import java.util.ArrayList;

public class Bodega {

    private int capacidad;
    private int numOcupacion;
    private ArrayList<Producto> productos;

    public Bodega (int capacidad, int numOcupado){

        this.capacidad=capacidad;
        this.numOcupacion=numOcupado;
        this.productos=new ArrayList<>();

    }

    
    public int getEspaciosLibres(){

        return capacidad-numOcupacion;

    }

    public synchronized void addProducto(Producto producto){

        while (capacidad-numOcupacion<=0){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
        productos.add(producto);
        numOcupacion++;

    }

    public int getNumOcupacion (){

        return numOcupacion;

    }

    public boolean productoEnBodega (Producto producto){
        
        return productos.contains(producto);

    }

    public synchronized Producto despacharProducto(){

        Producto pr= productos.get(0);
        productos.remove(0);
        System.out.println("Producto "+pr.getId()+" despachado");
        notify();
        return pr;

    }

}
