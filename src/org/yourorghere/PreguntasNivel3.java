package org.yourorghere;

import java.util.Random;

/**
 *
 * @author crossover
 */
public class PreguntasNivel3 {

    private static Random rand;

    public PreguntasNivel3() {
        rand = new Random();
    }

    private int aleatorio1_10() {
        return rand.nextInt(10) + 1;
    }

    public Object[][] matriz() {
        Object completa[][] = {
            {"¿Cual de estos planetas esta mas cerca del sol?", "saturno", "tierra", "marte"}, {false, false, true},
            {"¿Cuál de estos ecosistemas no esta en mexico?", "islas", "Indlandsis", "matorrales"}, {false, true, false},
            {"¿Cuál de estos animales no son oviparos?", "Cocodrilo", "Perro", "pajaro"}, {false, true, false},
            {"¿Cuál de estas no es una mezcla homogenea?", "Agua y aceite", "Agua y acero ", "Cafe con azucar"}, {true, false, false},
            {"¿Es un conjunto de seres vivos y condiciones ambientales relacionados que comparten un determinado lugar ?", "Ecosistema", "Biodiversidad", "Naturaleza"}, {false, true, false},
            {"¿Cuál de estos los siguientes no es un metodo de conservacion de los alimentos?", "Refrigerado", "Evaporacion", "Ahumado"}, {false, true, false},
            {"¿Cuáles son los estados fisicos de la materia?", "Solido,Liquido,Gaseoso", "Tierra,Fuego,Aire", "Arena,Miel,Leche"}, {true, false, false},
            {"¿Que alimento se descompondria mas pronto?", "Carne fresca", "Carne ahumada", "Pescado fresco"}, {true, false, false},
            {"¿Cuál es el causante de la descomposicion de los alimentos?", "El frio", "El aire", "Los microorganismos"}, {false, false, true},
            {"¿Qué movimiento terrestre es el que genera el dia y la noche?", "Movimiento de rotacion", "Movimiento de traslación", "Movimiento de Inclinacion"}, {true, false, false},};
        Object respuesta[][] = new Object[2][];
        respuesta[0] = new Object[4];
        respuesta[1] = new Object[3];

        switch (aleatorio1_10()) {
            case 1:
                respuesta[0][0] = completa[0][0];
                respuesta[0][1] = completa[0][1];
                respuesta[0][2] = completa[0][2];
                respuesta[0][3] = completa[0][3];
                respuesta[1][0] = completa[1][0];
                respuesta[1][1] = completa[1][1];
                respuesta[1][2] = completa[1][2];
                break;
            case 2:
                respuesta[0][0] = completa[2][0];
                respuesta[0][1] = completa[2][1];
                respuesta[0][2] = completa[2][2];
                respuesta[0][3] = completa[2][3];
                respuesta[1][0] = completa[3][0];
                respuesta[1][1] = completa[3][1];
                respuesta[1][2] = completa[3][2];
                break;
            case 3:
                respuesta[0][0] = completa[4][0];
                respuesta[0][1] = completa[4][1];
                respuesta[0][2] = completa[4][2];
                respuesta[0][3] = completa[4][3];
                respuesta[1][0] = completa[5][0];
                respuesta[1][1] = completa[5][1];
                respuesta[1][2] = completa[5][2];
                break;
            case 4:
                respuesta[0][0] = completa[6][0];
                respuesta[0][1] = completa[6][1];
                respuesta[0][2] = completa[6][2];
                respuesta[0][3] = completa[6][3];
                respuesta[1][0] = completa[7][0];
                respuesta[1][1] = completa[7][1];
                respuesta[1][2] = completa[7][2];
                break;
            case 5:
                respuesta[0][0] = completa[8][0];
                respuesta[0][1] = completa[8][1];
                respuesta[0][2] = completa[8][2];
                respuesta[0][3] = completa[8][3];
                respuesta[1][0] = completa[9][0];
                respuesta[1][1] = completa[9][1];
                respuesta[1][2] = completa[9][2];
                break;
            case 6:
                respuesta[0][0] = completa[10][0];
                respuesta[0][1] = completa[10][1];
                respuesta[0][2] = completa[10][2];
                respuesta[0][3] = completa[10][3];
                respuesta[1][0] = completa[11][0];
                respuesta[1][1] = completa[11][1];
                respuesta[1][2] = completa[11][2];
                break;
            case 7:
                respuesta[0][0] = completa[12][0];
                respuesta[0][1] = completa[12][1];
                respuesta[0][2] = completa[12][2];
                respuesta[0][3] = completa[12][3];
                respuesta[1][0] = completa[13][0];
                respuesta[1][1] = completa[13][1];
                respuesta[1][2] = completa[13][2];
                break;
            case 8:
                respuesta[0][0] = completa[14][0];
                respuesta[0][1] = completa[14][1];
                respuesta[0][2] = completa[14][2];
                respuesta[0][3] = completa[14][3];
                respuesta[1][0] = completa[15][0];
                respuesta[1][1] = completa[15][1];
                respuesta[1][2] = completa[15][2];
                break;
            case 9:
                respuesta[0][0] = completa[16][0];
                respuesta[0][1] = completa[16][1];
                respuesta[0][2] = completa[16][2];
                respuesta[0][3] = completa[16][3];
                respuesta[1][0] = completa[17][0];
                respuesta[1][1] = completa[17][1];
                respuesta[1][2] = completa[17][2];
                break;
            case 10:
                respuesta[0][0] = completa[18][0];
                respuesta[0][1] = completa[18][1];
                respuesta[0][2] = completa[18][2];
                respuesta[0][3] = completa[18][3];
                respuesta[1][0] = completa[19][0];
                respuesta[1][1] = completa[19][1];
                respuesta[1][2] = completa[19][2];
                break;
            default:
                break;
        }
        return respuesta;
    }
}
