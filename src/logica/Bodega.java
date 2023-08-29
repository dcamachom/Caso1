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
    
}
