/**
 * Modifica el programa anterior para sincronizar el acceso a dicha 
 * variable. Versión con interfaz Runnable
 */
public class ua2tarea1fr2runnable implements Runnable{

    // Variable compartida por todos los hilos.
    private static int contador=0;

    /** 
     * Crea 1 hilo y lo ejecuta 5 veces
     * @param args
     */
    public static void main(String[] args){
        //Sincronizar mediante declaración synchronized
        ua2tarea1fr2runnable hilo = new ua2tarea1fr2runnable();

        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();
        new Thread(hilo).start();

        try{
            Thread.sleep(1000);
            System.out.println(contador);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        incrementarMil();
    }

    private synchronized void incrementarMil(){
        for (int i = 0 ; i<1000; i++){
            contador++;
        }
    }
}