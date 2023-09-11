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
                System.out.println("No hay espacio, el productor: " + producto.getProductor().getid() + " se duerme sobre la bodega");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productos.add(producto);
        System.out.println("Se almaceno el producto: " + producto.getId());
        System.out.println("El productor: "+producto.getProductor().getid()+ " se durmio sobre el producto: "+ producto.getId());
        //notify();
    }

    public synchronized Producto retirar(){

        /*while(productos.size()==0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        Producto productoRetirado = productos.remove(0);
        System.out.println("El despachador tiene el producto: " + productoRetirado.getId()+" se libera un espacio de bodega");
        notifyAll();
        return productoRetirado;


    }


    public int getNumOcupacion (){

        return productos.size();

    }



}
