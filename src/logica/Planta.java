package logica;
import java.util.Scanner;

public class Planta extends Thread {

    private static int N;
    private static int M;
    private static int TAM;
    private static int C;
    private static Bodega BODEGA;
    private static Intermediario inter;

    public Planta(int nProductor, int nRepartidores, int nBodega, int numProductos){
        TAM = nBodega;
        C = numProductos;
        BODEGA = new Bodega(TAM);
        N = nProductor;
        M = nRepartidores;
        inter= new Intermediario();
        

    }

    public void run(){

    }

    public static void main(String[] args) throws Exception {

        
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el número de productores: ");
        int nProductor = scn.nextInt();
        System.out.println("Ingrese el número de repartidores: ");
        int nRepartidores = scn.nextInt();
        System.out.println("Ingrese la capacidad de la bodega: ");
        int nBodega = scn.nextInt();
        System.out.println("Ingrese el número de productos: ");
        int nProductos = scn.nextInt();

        

        Planta planta = new Planta(nProductor, nRepartidores, nBodega, nProductos);

        int[] productosPorProducir = new int[N];

        //Creacion nProductores Threads
        for(int i = 0; i<N; i++ ){
            if(C%N==0){
                new Productor(i, C/N, BODEGA ).start();
                productosPorProducir[i] = C/N;
            }
            else if(nProductos>0 && C<N){
                new Productor(i, 1 , BODEGA).start();
                productosPorProducir[i] = 1;
                nProductos--;
            }
            else{
                if(nProductos%N!=0){
                    new Productor(i, C/N+1 , BODEGA).start();
                    productosPorProducir[i] = C/N+1;
                    nProductos=nProductos-1;
                }
                else{
                     new Productor(i, C/N , BODEGA).start();
                     productosPorProducir[i] = C/N;
                }
            }

        //Creacion despachador Thread
        new Despachador(N, M, BODEGA, productosPorProducir, inter).start();

        //Creacion nRepartidores Threads



        }



        




        
    }

}