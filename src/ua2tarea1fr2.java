/**
 * Modifica el programa anterior para sincronizar el acceso a dicha 
 * variable. Lanza primero los hilos mediante la clase Thread y después
 * mediante el interfaz Runnable.
 */
public class ua2tarea1fr2 extends Thread{
    
    // variable compartida por todos los hilos.
    private static int contador=0;

    /** 
     * Crea 5 hilos y los ejecuta.
     * @param args
     */
    public static void main(String[] args){
        //Sincronizar mediante join
        ua2tarea1fr2 hilo1 = new ua2tarea1fr2();
        ua2tarea1fr2 hilo2 = new ua2tarea1fr2();
        ua2tarea1fr2 hilo3 = new ua2tarea1fr2();
        ua2tarea1fr2 hilo4 = new ua2tarea1fr2();
        ua2tarea1fr2 hilo5 = new ua2tarea1fr2();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        System.out.println(contador);
    }

    @Override
    public void run(){
        contador+=1000;
    }
}