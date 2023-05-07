/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.yourorghere.Juego.control1;
import static org.yourorghere.Juego.parte1;
import static org.yourorghere.Juego.velocidadP1;
import static org.yourorghere.Juego.velocidadP2;
import static org.yourorghere.Juego.velocidadP3;
import static org.yourorghere.Juego.velocidadHitBox;
import static org.yourorghere.Juego.colision;
import static org.yourorghere.Juego.fin;
import static org.yourorghere.Juego.cz1;
import static org.yourorghere.Juego.cajaPieIzquierdo;
import static org.yourorghere.Juego.cajaPieDerecho;
import static org.yourorghere.Juego.cajaCactus0;
import static org.yourorghere.Juego.cajaCactus1;
import static org.yourorghere.Juego.cajaCactus2;
import static org.yourorghere.Juego.cajaCactus3;
import static org.yourorghere.Juego.pIzquierdo;
import static org.yourorghere.Juego.pDerecho;
//import static org.yourorghere.Juego.;

/**
 *
 * @author Jonathan Montalvo P閞ez
 */
public class PartesJuego extends Thread
{

    private int repetir;

    public PartesJuego()
    {
        this.repetir = 0;
    }

    // Funci贸n para verificar si hay intersecci贸n entre dos cajas de colisi贸n
    private boolean interseccion(cBoxObj caja1, cBoxObj caja2, float c1, float c2)
    {

        boolean hayColisionX = false;
        boolean hayColisionY = false;
        boolean hayColisionZ = false;

        // Calcular las posiciones de los bordes de las cajas
        float izquierdaCaja1 = caja1.centro[0] + caja1.extend[0];
        float derechaCaja1 = caja1.centro[0] - caja1.extend[0];
        float arribaCaja1 = caja1.centro[1] + (caja1.extend[1] * 4);
        float abajoCaja1 = caja1.centro[1] - (caja1.extend[1] * 4);
        float adelanteCaja1 = caja1.centro[2] - caja1.extend[2];
        float atrasCaja1 = caja1.centro[2] + caja1.extend[2];

        float izquierdaCaja2 = caja2.centro[0] + caja2.extend[0];
        float derechaCaja2 = caja2.centro[0] - caja2.extend[0];
        float arribaCaja2 = caja2.centro[1] + caja2.extend[1];
        float abajoCaja2 = caja2.centro[1] - caja2.extend[1];
        float adelanteCaja2 = caja2.centro[2] - caja2.extend[2];
        float atrasCaja2 = caja2.centro[2] + caja2.extend[2];

        // Verificar colisi贸n en el eje X
        if (izquierdaCaja1 >= derechaCaja2 && derechaCaja1 <= izquierdaCaja2) {
            hayColisionX = true;
        }

        // Verificar colisi贸n en el eje Y
        if (arribaCaja1 >= abajoCaja2 && abajoCaja1 <= arribaCaja2) {
            hayColisionY = true;
        }

        // Verificar colisi贸n en el eje Z
        if (adelanteCaja2 <= adelanteCaja1 - c1 && atrasCaja2 >= adelanteCaja1 - c2)//-2.6390127+adelanteCaja1 da -6.779013
        {
            hayColisionZ = true;
        }
        return hayColisionX && hayColisionY && hayColisionZ;
    }

    public void juego()
    {
        //Es la parte de las velocidades
        //Control fondo primera parte
        if ((velocidadP1 % 120) == 0) //Cuando llega a 120 va a cambiar la posicion del fondo
        {
            if ((control1 % 2) == 0) //Controlamos a que posici贸n se debe colocar para que de el efecto de continuidad
            {
                parte1 = -1.0f;//Esto es en la parte m谩s cercana
            } else {
                parte1 = 11.0f;//En la parte m谩s alejada
            }
            velocidadP1 = 0;//Reiniciamos la velocidad
            control1++;//Es una bandera para controlar la posici贸n
        }

        //Control fondo segunda parte
        if ((velocidadP2 % 240) == 0) //Cuando llegamos a 240 reinicia la velocidad, lo que altera la posici贸n
        {
            velocidadP2 = 0;
            velocidadHitBox = 0.256f;
        }

        // Control de velocidad
        velocidadP1 += 1;
        velocidadP2 += 1;
        velocidadHitBox += 0.256f;
        velocidadP3 += 1;

        if (velocidadP3 <= 960) {
            if (pIzquierdo) {
                if (interseccion(cajaPieIzquierdo, cajaCactus0, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus1, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus2, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus3, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
            if (pDerecho) {
                if (interseccion(cajaPieDerecho, cajaCactus0, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus1, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus2, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus3, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
        }

        if (velocidadP3 >= 960) {
            colision = true;
            fin = true;
            //restale los del ultimo avance a esos 2
            velocidadP1 -= 1;
            velocidadP2 -= 1;
        }
        if (colision) {
            velocidadP1 -= 1;
            velocidadP2 -= 1;
            stop();
        }
    }

    public void velocidades()
    {
        int repetir = 0;

        while (repetir < 240) {
            try {
                //Bucle de tiempo para el primer intervalo de tiempo de 10080 milisegundos
                juego();
                sleep(50); //Esperar 42 milisegundos antes de la siguiente iteraci髇
                repetir++;
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (repetir < 480) {
            try {
                //Bucle de tiempo para el segundo intervalo de tiempo de 17520 milisegundos
                juego();
                sleep(40); //Esperar 21 milisegundos antes de la siguiente iteraci髇
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            repetir++;
        }

        while (repetir < 720) {
            try {
                //Bucle de tiempo para el tercer intervalo de tiempo de 6000 milisegundos
                juego();
                sleep(30); //Esperar 10 milisegundos antes de la siguiente iteraci髇
                repetir++;
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (repetir < 975) {
            try {
                //Bucle de tiempo para el tercer intervalo de tiempo de 4800 milisegundos
                juego();
                sleep(20); //Esperar 10 milisegundos antes de la siguiente iteraci髇
                repetir++;
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void run()
    {
        velocidades();
    }
}
