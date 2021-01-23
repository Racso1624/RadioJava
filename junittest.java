package Radio;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class junittest {

	@Test
	public void testisON() {
		
		Radio instance = new Radio();
		instance.encender();
		
		boolean result = instance.isON();
		
		if (result != true) {
			System.out.println("Ocurrio un error");
			fail("Ocurre un error");}
		System.out.println("El programa funciona correctamente");
	}
	
	@Test
	public void testencender() {

		Radio instance = new Radio();
		instance.encender();

	}
	
	@Test
	public void testapagar() {

		Radio instance = new Radio();
		instance.encender();
		
		instance.apagar();
		
	}
	
	@Test
	public void testincrementar() {

		Radio instance = new Radio();
		instance.encender();
		
		instance.incrementar();
		
	}
	
	@Test
	public void testasignar() {

		int a = 90;
		Radio instance = new Radio();
		instance.encender();
		instance.frecuencia();
		instance.emisora(a);
		boolean result = instance.asignar(a);
		
		if (result != true) {
			System.out.println("Ocurrio un error");
			fail("Ocurre un error");}
		System.out.println("El programa funciona correctamente");
	}
	


}
