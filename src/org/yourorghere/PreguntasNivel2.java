package org.yourorghere;

import java.util.Random;

/**
 *
 * @author crossover
 */
public class PreguntasNivel2 {

    private static Random rand;

    public PreguntasNivel2() {
        rand = new Random();
    }

    private int aleatorio1_10() {
        return rand.nextInt(10) + 1;
    }

    public Object[][] matriz() {
        Object completa[][] = {
            {"¿Cuál de estas palabras es un SUSTANTIVO?", "correr", "feliz", "perro"}, {false, false, true},
            {"¿Cuál de estas palabras es un ADJETIVO?", "comer", "grande", "dormir"}, {false, true, false},
            {"¿Cuál de estas palabras es un VERBO?", "cama", "saltar", "casa"}, {false, true, false},
            {"¿Cuál de estas palabras es un ADVERBIO?", "rápido", "cantar", "libro"}, {true, false, false},
            {"¿Cuál de estas palabras es una PREPOSICIÓN?", "y", "en", "él"}, {false, true, false},
            {"¿Cuál de estas palabras es un PRONOMBRE?", "jugar", "yo", "gato"}, {false, true, false},
            {"¿Cuál de estas frases tiene una METÁFORA?", "El sol es un gigante amarillo", "La lluvia cae fuerte sobre el tejado", "El pájaro canta una dulce melodía"}, {true, false, false},
            {"¿Cuál de estas palabras RIMA con 'flor'?", "amor", "perro", "casa"}, {true, false, false},
            {"¿Cuál de estas opciones describe mejor una ESTROFA?", "Un párrafo en un poema", "Una oración en un poema", "Un conjunto de versos en un poema"}, {false, false, true},
            {"¿Cuál de estas opciones describe mejor una FÁBULA?", "Un relato breve y ficticio con una moraleja o enseñanza moral", "Un poema sin rima ni métrica", "Una historia de aventuras y acción"}, {true, false, false},};
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
