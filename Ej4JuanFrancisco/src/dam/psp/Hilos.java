package dam.psp;

public class Hilos implements Runnable {
	int contadorPrimo;
	Integer[] arrayPrimos;
	Object mutex = new Object();
	int porcion;
	
	public Hilos(int i, Integer[] arrayPrimos) {
		porcion=i;
		this.arrayPrimos=arrayPrimos;
	}
	
	@Override
	public void run() {
		ContarPrimos();
		System.out.println("Yo el hilo numero "+porcion+" he leido "+contadorPrimo+ " primos");
				
	}
	private void ContarPrimos() {
		int numero;
		boolean primo=true;
		
		for(int i =0+porcion*20; i<porcion*20+20;i++)
		{
			numero=arrayPrimos[i];
			if(numero!=2)
			{
			for(int j = 2; j<numero/2;j++)
			{
				if(numero%j==0)
				{
					primo=false;
				}
			}
			}else {
				primo=true;
			}
			if(primo)
			{
				contadorPrimo++;	
				
			}else {
				primo=true;
			}
		}
		synchronized (mutex) {
			CuentaPrimos.AumentarContador(contadorPrimo);
		}
		
	}

}
