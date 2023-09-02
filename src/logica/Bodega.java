package logica;

import java.util.ArrayList;

public class Bodega {

    private int capacidad;
    private ArrayList<Producto> productos;

    public Bodega (int capacidad){

        this.capacidad=capacidad;
        this.productos=new ArrayList<Producto>();

    }

    public synchronized void almacenar(Producto producto){
        while(productos.size()==capacidad){
            try{
                System.out.println("No hay espacio");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productos.add(producto);
        notify();
        System.out.println("Se añadio correctamente");
    }

    public synchronized Producto retirar(){
        while(productos.size()==0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Producto productoRetirado = productos.remove(0);
        notify();
        return productoRetirado;

    }

    
    public int getEspaciosLibres(){

        return capacidad-productos.size();

    }

    public void addProducto(Producto producto){

        productos.add(producto);

    }

    public int getNumOcupacion (){

        return productos.size();

    }

    public boolean productoEnBodega (Producto producto){
        
        return productos.contains(producto);

    }

    public Producto despacharProducto(){

        Producto pr= productos.get(0);
        productos.remove(0);
        System.out.println("Producto "+pr.getId()+" despachado");
        return pr;

    }

}
