/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author
 */
public class PreguntasNivel1
{

    private static Random rand;

    public PreguntasNivel1()
    {
        rand = new Random();
    }

    /**
     * @return 0 es una Suma
     * @return 1 es una Resta
     * @return 2 es una Multiplicación
     */
    private int operadorArtimetico()
    {
        return rand.nextInt(3);
    }

    /**
     * @return número entre 1 y 100
     */
    private int primerNumero()
    {
        return rand.nextInt(100) + 1;
    }

    /**
     * @return número entre 1 y 10
     */
    private int segundoNumero()
    {
        return rand.nextInt(10) + 1;
    }

    public Object[][] preguntaRespuesta()
    {
        Object arr[][] = new Object[2][];
        arr[0] = new Object[4];
        arr[1] = new Object[]{false, false, false};
        int operacion = operadorArtimetico();
        int numero1 = -1;
        int numero2 = -1;
        int pos1 = -1;
        int pos2 = -1;
        int pos3 = -1;
        int primerNumero1 = primerNumero();
        int primerNumero2 = primerNumero();
        int segundoNumero1 = primerNumero();
        int segundoNumero2 = primerNumero();

        switch (operacion) {
            case 0:
                //Suma
                numero1 = primerNumero();
                numero2 = primerNumero();

                arr[0][0] = "¿Cuánto es " + numero1 + " + " + numero2 + "?";

                while (pos1 == pos2 || pos2 == pos3 || pos1 == pos3) {
                    pos1 = operadorArtimetico();
                    pos2 = operadorArtimetico();
                    pos3 = operadorArtimetico();
                }

                arr[0][pos1 + 1] = "Es \"" + (numero1 + numero2) + "\"";
                arr[1][pos1] = true;

                do {
                    arr[0][pos2 + 1] = "Es \"" + (primerNumero() + primerNumero()) + "\"";
                    arr[0][pos3 + 1] = "Es \"" + (primerNumero() + primerNumero()) + "\"";
                } while (arr[0][pos1 + 1] == arr[0][pos2 + 1]
                        || arr[0][pos1 + 1] == arr[0][pos3 + 1]
                        || arr[0][pos2 + 1] == arr[0][pos3 + 1]);
                break;
            case 1:
                //Resta
                numero1 = primerNumero();
                numero2 = primerNumero();

                while (numero1 < numero2) {
                    numero1 = primerNumero();
                    numero2 = primerNumero();
                }

                arr[0][0] = "¿Cuánto es " + numero1 + " - " + numero2 + "?";

                while (pos1 == pos2 || pos2 == pos3 || pos1 == pos3) {
                    pos1 = operadorArtimetico();
                    pos2 = operadorArtimetico();
                    pos3 = operadorArtimetico();
                }

                arr[0][pos1 + 1] = "Es \"" + (numero1 - numero2) + "\"";
                arr[1][pos1] = true;

                do {
                    while (primerNumero1 < segundoNumero1) {
                        primerNumero1 = primerNumero();
                        segundoNumero1 = primerNumero();
                    }

                    while (primerNumero2 < segundoNumero2) {
                        primerNumero2 = primerNumero();
                        segundoNumero2 = primerNumero();
                    }

                    arr[0][pos2 + 1] = "Es \"" + (primerNumero1 - segundoNumero1) + "\"";
                    arr[0][pos3 + 1] = "Es \"" + (primerNumero2 - segundoNumero2) + "\"";
                } while (arr[0][pos1 + 1] == arr[0][pos2 + 1]
                        || arr[0][pos1 + 1] == arr[0][pos3 + 1]
                        || arr[0][pos2 + 1] == arr[0][pos3 + 1]);
                break;
            case 2:
                //Multiplicación
                numero1 = primerNumero();
                numero2 = segundoNumero();

                arr[0][0] = "¿Cuánto es " + numero1 + " * " + numero2 + "?";

                while (pos1 == pos2 || pos2 == pos3 || pos1 == pos3) {
                    pos1 = operadorArtimetico();
                    pos2 = operadorArtimetico();
                    pos3 = operadorArtimetico();
                }

                arr[0][pos1 + 1] = "Es \"" + (numero1 * numero2) + "\"";
                arr[1][pos1] = true;

                do {
                    arr[0][pos2 + 1] = "Es \"" + (primerNumero() * segundoNumero()) + "\"";
                    arr[0][pos3 + 1] = "Es \"" + (primerNumero() * segundoNumero()) + "\"";
                } while (arr[0][pos1 + 1] == arr[0][pos2 + 1]
                        || arr[0][pos1 + 1] == arr[0][pos3 + 1]
                        || arr[0][pos2 + 1] == arr[0][pos3 + 1]);
                break;
            default:
                for (int i = 0; i < 4; i++) {
                    arr[0][i] = "Error";
                }
                break;
        }

        return arr;
    }
}
