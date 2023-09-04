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
                System.out.println("No hay espacio, el productor se duerme sobre la bodega");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productos.add(producto);
        producto.dormirSobreProducto();
        System.out.println("El productor: "+producto.getProductor().getId()+ "se durmio sobre el producto: "+ producto.getId());
        notify();
        System.out.println("Se añadio correctamente el producto: " + producto.getId());
    }

    public synchronized Producto retirar(){

        Producto productoRetirado = productos.remove(0);
        notify();
        System.out.println("Producto "+productoRetirado.getId()+" despachado");
        return productoRetirado;

    }

    
    public int getEspaciosLibres(){

        return capacidad-productos.size();

    }


    public int getNumOcupacion (){

        return productos.size();

    }

    public boolean productoEnBodega (Producto producto){
        
        return productos.contains(producto);

    }


}
