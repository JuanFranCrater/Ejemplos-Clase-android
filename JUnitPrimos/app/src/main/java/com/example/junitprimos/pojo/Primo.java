package com.example.junitprimos.pojo;

/**
 * Created by usuario on 8/11/17.
 */

public final class Primo {
    /**
     * Metodo que comprueba si un número es primo
     *
     * @param numero
     * @return
     */

    public static boolean esPrimo(int numero) {
        boolean esPrimo = true;
        if (numero < 0) {
            //numero negativo
            esPrimo = false;
        } else if (numero<2) {
            esPrimo=false;
        } else {
            for(int i = 2; i< numero;i++)
            {
                if(numero%i==0)
                    esPrimo=false;
            }
        }
        return esPrimo;
    }
}
