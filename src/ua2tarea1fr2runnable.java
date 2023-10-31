/**
 * Modifica el programa anterior para sincronizar el acceso a dicha 
 * variable. Lanza primero los hilos mediante la clase Thread y después
 * mediante el interfaz Runnable.
 */
public class ua2tarea1fr2runnable implements Runnable{
    
    // variable compartida por todos los hilos.
    private static int contador=0;

    /** 
     * Crea 5 hilos y los ejecuta.
     * @param args
     */
    public static void main(String[] args){
        ua2tarea1fr2runnable hilo = new ua2tarea1fr2runnable();

        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();
        System.out.println(contador);
    }

    @Override
    public void run(){
        contador+=1000;
    }
}