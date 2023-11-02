/**
 * Modifica el programa anterior para sincronizar el acceso a dicha 
 * variable. Lanza primero los hilos mediante la clase Thread y después
 * mediante el interfaz Runnable.
 */
public class ua2tarea1fr2 extends Thread{
    
    // variable compartida por todos los hilos.
    private static int contador=0;
    private boolean suspender=false;
    private Thread hiloReferencia;

    /**
     * Constructor para indicar un hilo de referencia. Este constructor se utiliza si 
     * se quiere sincronizar este hilo con otros. Al pasarle un hilo de referencia se 
     * entiende que inicializará con el estado suspender = true, por lo que hará join.
     * @param hiloReferencia el hilo al que deberá esperar.
     */
    public ua2tarea1fr2(Thread hiloReferencia){
        this.suspender=true;
        this.hiloReferencia = hiloReferencia;
    }

    /**
     * Constructor por defecto, inicia con el estado suspender = false, por lo que no hace join
     */
    public ua2tarea1fr2(){
        suspender=false;
    }
    
    /** 
     * Crea 5 hilos y los ejecuta.
     * @param args
     */
    public static void main(String[] args){
        //Sincronizar mediante join
        ua2tarea1fr2 hilo1 = new ua2tarea1fr2();
        ua2tarea1fr2 hilo2 = new ua2tarea1fr2(hilo1);
        ua2tarea1fr2 hilo3 = new ua2tarea1fr2(hilo2);
        ua2tarea1fr2 hilo4 = new ua2tarea1fr2(hilo3);
        ua2tarea1fr2 hilo5 = new ua2tarea1fr2(hilo4);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        try{
            Thread.sleep(500);
            System.out.println(contador);
        }catch
    }


    @Override
    public void run(){
        try{
            //espera al hilo de referencia si es preciso.
            if(suspender){
                hiloReferencia.join();
            }
            for (int i = 0 ; i<1000; i++){
                contador++;
            }

            //Por simplicidad en lugar de mostrar cada incremento muestro la cantidad final de cada hilo.    
            System.out.println(contador);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}