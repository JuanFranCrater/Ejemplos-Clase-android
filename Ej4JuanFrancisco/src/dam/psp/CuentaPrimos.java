package dam.psp;

import java.util.Random;

public class CuentaPrimos {
	static Integer contadorPrimo = new Integer(0);
	
	public static void main(String[] args) {
		
		Integer[] arrayPrimos= new Integer[100];
		Thread[] hilo=new Thread[5];
		for(int i =0; i<arrayPrimos.length;i++)
		{
			arrayPrimos[i]=new Random().nextInt(1001);
		}
		
		for(int i =0; i<5;i++)
		{
		 hilo[i] = new Thread(new Hilos(i,arrayPrimos));
		 hilo[i].start();
		}
		
		for(int i =0; i<5;i++)
		{
		 try {
			hilo[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("El total de primos es "+contadorPrimo);
	}
	
	public static void AumentarContador(int primos) {
		contadorPrimo+=primos;
	}
}
