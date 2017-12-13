package com.AlejandroAgca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContarFichero {

	public static void main(String[] args) {
		try {
			String ruta = args[0];
			ProcessBuilder proceso1 = new ProcessBuilder("cat", ruta);
			ProcessBuilder proceso2 = new ProcessBuilder("wc");
			Process miProceso1 = proceso1.start();
			Process miProceso2 = proceso2.start();
			BufferedReader salida1 = new BufferedReader(new InputStreamReader(miProceso1.getInputStream()));
			BufferedWriter entrada2 = new BufferedWriter(new OutputStreamWriter(miProceso2.getOutputStream()));
			BufferedReader salida2 = new BufferedReader(new InputStreamReader(miProceso2.getInputStream()));
			String resultado1;
			while ((resultado1 = salida1.readLine()) != null) {
				entrada2.write(resultado1);
				entrada2.newLine();
			}
			salida1.close();
			entrada2.close();
			String resultado2;
			while ((resultado2 = salida2.readLine()) != null) {
				System.out.println(resultado2);
			}

			salida2.close();
			int fin = miProceso2.waitFor();
			System.out.println("Salida del proceso: " + fin);

		} 
		
		catch (IOException e) {
			System.out.println("ERROR DE E/S: " + e.getMessage());
		} 
		
		catch (Exception e) {
			System.out.println("ERROR DE PARAMETRO: " + e.getMessage());
		}

	}
}
