/**
 * Crea un programa en Java que lance 5 hilos. 
 * Cada hilo incrementará una variable contador de tipo entero en 1000 unidades. 
 * Esta variable estará compartida por todos los hilos.
 */
public class ua2tarea1fr1 extends Thread{

    private static int contador;
    /** 
     * Crea 5 hilos y los ejecuta.
     * @param args
     */
    public static void main(String[] args){
        ua2tarea1fr1 hilo1 = new ua2tarea1fr1();
        ua2tarea1fr1 hilo2 = new ua2tarea1fr1();
        ua2tarea1fr1 hilo3 = new ua2tarea1fr1();
        ua2tarea1fr1 hilo4 = new ua2tarea1fr1();
        ua2tarea1fr1 hilo5 = new ua2tarea1fr1();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(contador);
    }

    @Override
        public void run(){
            for (int i = 0 ; i<1000; i++){
                contador++;
            }
        }
}