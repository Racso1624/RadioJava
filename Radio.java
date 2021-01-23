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

//Creacion de la clase Radio que implementa la interfaz RadioGeneral
public class Radio implements RadioGeneral{
	
	//Creacion de las propiedades
	private Boolean encendido; 
	private String freq;
	private float emisora;
	private int[] emisorasfavam = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private float[] emisorasfavfm = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
	Scanner input = new Scanner(System.in);	

	//Crecion del metodo constructor
	public Radio(){

		encendido = false; 
		freq = "AM";
		emisora = 530;

	}
	
	//Creacion del Override del metodo isON, regresa un booleano
	@Override
	public boolean isON() {

		return encendido;
	
	}

	//Creacion del Override del metodo encender, cambia el valor de encendido e imprime un texto
	@Override
	public void encender() {

		System.out.println("Radio Encendida");
		encendido = true;

	}

	//Creacion del Override del metodo apagar, cambia el valor de encendido e imprime un texto
	@Override
	public void apagar() {
		
		System.out.println("Radio Apagada");
		encendido = false;

	}

	//Creacion del Override del metodo incrementar, con una condicional incrementa cierta cantidad a cada emisora.
	@Override
	public void incrementar() {

		//Condicion para incrementar la cantidad
		if(freq == "AM"){

			emisora += 10;
			if(emisora > 1610){
				emisora = 530;
			}
			
			System.out.printf("\nSe ha incrementado la emisora a " + emisora);

		}
		else if(freq == "FM"){

			emisora += (float) 0.2;
			if(emisora > 107.9){
				emisora = (float) 87.9;
			}

			System.out.println("\nSe ha incrementado la emisora a " + emisora);

		}
		
	}

	//Creacion del Override del metodo asignar, pide una emisora y la asigna al boton del numero que se encuentra como parametro
	@Override
	public boolean asignar(int num) {

		System.out.println("\nIngrese la emisora de la frecuencia " + freq + " que desee guardar (Si la emisora tiene punto decimal escribela con coma: 89,7):");

		//Ciclo con Try Catch para evitar errores
		boolean var2 = false;
		while(var2 == false){

			//Condicion para pedir el numero de emisora segun corresponda
			if(freq == "AM"){

				try {
					
					int nemisora = input.nextInt();

					//Condicion para asegurar que sea una emisora en el rango
					if(nemisora >= 530 && nemisora <= 1650){

						emisorasfavam[num - 1] = nemisora; 
						System.out.println("Se ha guardado la emisora " + nemisora + " en el boton " + num);
						var2 = true;
						return true;

					}
					else{

						System.out.println("Emisora incorrecta, solo se permiten del 530 AM al 1630 AM");

					}	
					
				} catch (InputMismatchException e) {
					
					System.out.println("Error, Por favor ingrese numeros enteros o utilice coma para los decimales (,): ");
					input.next();
	
				}

			}
			else if(freq == "FM"){

				try {
					
					float nemisora = (float) input.nextDouble(); //AL MOMENTO DE INGRESAR LA EMISORA ESCRIBIRLA CON COMA

					//Condicion para asegurar que sea una emisora en el rango
					if(nemisora >= 87.9 && nemisora <= 107.9){

						emisorasfavfm[num - 1] = nemisora;
						System.out.println("\nSe ha guardado la emisora " + nemisora + " en el boton " + num);
						var2 = true;
						return true;
						
					}
					else{

						System.out.println("Emisora incorrecta, solo se permiten del 87.9 FM al 107.9 FM");

					}	
					
				} catch (InputMismatchException e) {
					
					System.out.println("Error, Por favor ingrese numeros reales: ");
					input.next();
	
				}
			}	
		}

		return false;

	} 

	//Creacion del Override del metodo emisora, hace una condicion y cambia la emisora
	@Override
	public boolean emisora(int num) {

		//Condicion para elegir la lista de la frecuencia
		if(freq == "AM"){

			//Condicion para elegir las emisoras guardadas
			if(emisorasfavam[num - 1] != 0){

				emisora = emisorasfavam[num - 1];
				System.out.println("Se ha sintanizado la emisora " + emisora);
				return true;
	
			}
			else{
	
				System.out.println("Ese boton no esta asignado a ninguna emisora");
	
			}	

		}
		else if(freq == "FM"){

			//Condicion para elegir las emisoras guardadas
			if(emisorasfavfm[num - 1] != 0.0){

				emisora = emisorasfavfm[num - 1];
				System.out.println("Se ha sintanizado la emisora " + emisora);
				return true;
	
			}
			else{
	
				System.out.println("Ese boton no esta asignado a ninguna emisora");
	
			}	

		}

		return false;
		
	}

	//Creacion del Override del metodo frecuencia, imprime un menu y cambia la frecuencia
	@Override
	public void frecuencia() {
		
		System.out.println("\nSeleccione una frecuencia");
		System.out.println("1) AM");
		System.out.println("2) FM");

		//Ciclo con Try Catch para evitar errores
		boolean var = false;
		while(var == false){
			try {

				int numero = input.nextInt();

				//Emisora AM
				if (numero == 1) {

					freq = "AM";
					emisora = 530;
					System.out.println("\nAhora se encuentra en "+freq);
					var = true;

				} 

				//Emisora FM
				else if(numero == 2) {

					freq = "FM";
					emisora = (float) 87.9;
					System.out.println("\nAhora se encuentra en "+freq);
					var = true;

				} else {

					System.out.println("Lo que ha ingresado no es valido, vuelva a intentar");
					System.out.println("Ingrese un numero del 1 al 2: ");
					
				}
			} catch (InputMismatchException e) {

				System.out.println("Por favor ingrese numeros enteros: ");
				input.next();
			
			}
		}

	}

}
