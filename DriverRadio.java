/****************************************
 * Oscar Fernando López Barrios 20679
 * Jose Pablo Monzon 20309
 * Estructuras de Datos
 * 22-01-2021
 ****************************************/

/*****************************************************************
 * NOTA: Se pide el parametro de el metodo asignar y emisora,
 * ya que asi estaba diseñado por la sección, se necesitan estos
 * parametros para que los metodos funcionen.
 *****************************************************************/ 


//Librerias utilizadas
import java.util.InputMismatchException;
import java.util.Scanner;

//Creacion de la clase Driver Radio
public class DriverRadio {
    
    //Creacion del main
    public static void main(String[] args) {
        
        //Creacion de las instancias
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido al Sistema de Radio");

        //Ciclo de inicio para encender la radio
        a: while(radio.isON() == false){

            System.out.println("\nDesea encender la radio:");
            System.out.println("1) Si");
            System.out.println("2) No");
            System.out.println("3) Salir");

            //Ciclo con Try Catch para evitar errores
            boolean var = false;
            while(var == false){

                try {
                
                    int opcion = scanner.nextInt();
                    
                    //Opcion de encender 
                    if(opcion == 1){
    
                        radio.encender();
                        var = true;
    
                    }

                    //Opcion de regresar al menu
                    else if(opcion == 2){
    
                        System.out.println("Regresando al menu...");
                        var = true;
    
                    }

                    //Opcion de salir
                    else if(opcion == 3){
                        
                        System.out.println("Saliendo del programa de Radio");
                        break a;
    
                    }
                    else{

                        System.out.println("Numero invalido, ingrese otro numero: ");

                    }
    
                } catch (InputMismatchException e) {
        
                    System.out.println("Error, Por favor ingrese numeros enteros: ");
				    scanner.next();

                }

            }

        }

        //Ciclo que contiene las opciones de la radio
        while(radio.isON() == true){

            //Ciclo con Try Catch para evitar errores
            boolean var = false;
            while(var == false){

                System.out.println("\n\nQue desea realizar:");
                System.out.println("1) Cambiar de Frecuencia");
                System.out.println("2) Avanzar de emisora");
                System.out.println("3) Guardar una emisora");
                System.out.println("4) Seleccionar emisora guardada");
                System.out.println("5) Apagar");

                try {
                
                    int opcion = scanner.nextInt();
                    
                    //Opcion con el metodo frecuencia
                    if(opcion == 1){
    
                        radio.frecuencia();
                        var = true;
    
                    }

                    //Opcion con el metodo incrementar
                    else if(opcion == 2){
    
                        radio.incrementar();
                        var = true;
    
                    }

                    //Opcion que pide un numero del 1 al 12 y corre el metodo asignar
                    else if(opcion == 3){
                        
                        int num = 0;
                        var = radio.asignar(num);
    
                    }

                    //Opcion que pide un numero del 1 al 12 y corre el metodo emisora
                    else if(opcion == 4){
                        
                        int num = 0;
                        var = radio.emisora(num);
    
                    }

                    //Opcion con el metodo apagar
                    else if(opcion == 5){
    
                        radio.apagar();
                        var = true;
    
                    }
                    else{

                        System.out.println("Numero invalido, Ingrese otro numero: ");

                    }
    
                } catch (InputMismatchException e) {
        
                    System.out.println("Error, Por favor ingrese numeros enteros: ");
				    scanner.next();

                }

            }

        }

    }

}
