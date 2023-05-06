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

    long tiempoInicial = System.currentTimeMillis(); //Obtener el tiempo actual en milisegundos
    long tiempoActual = tiempoInicial;

    public PartesJuego()
    {
        this.tiempoInicial = 0;
        this.tiempoActual = 0;
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
        }

        // Control de velocidad
        velocidadP1 += 2;
        velocidadP2 += 2;
        velocidadHitBox += 0.513f;
        velocidadP3 += 1;

        if (velocidadP3 <= 139) {
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
        } else if (velocidadP3 <= 195) {
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
                if (interseccion(cajaPieIzquierdo, cajaCactus3, 0.5130005f, 0.76950075f)) {
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
                if (interseccion(cajaPieDerecho, cajaCactus3, 0.5130005f, 0.76950075f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
        } else if (velocidadP3 <= 231) {//231
            if (pIzquierdo) {
                if (interseccion(cajaPieIzquierdo, cajaCactus0, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus1, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus2, 0.87210085f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus3, 0.35910035f, 1.31950635f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
            if (pDerecho) {
                if (interseccion(cajaPieDerecho, cajaCactus0, 0.5130005f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus1, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus2, 0.87210085f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus3, 0.35910035f, 1.31950635f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
        } else {
            if (pIzquierdo) {
                if (interseccion(cajaPieIzquierdo, cajaCactus0, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus1, 1.5390015f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus2, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieIzquierdo, cajaCactus3, 1.5390015f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
            if (pDerecho) {
                if (interseccion(cajaPieDerecho, cajaCactus0, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.1f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus1, 1.5390015f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.2f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus2, 1.026001f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.3f;
                }
                if (interseccion(cajaPieDerecho, cajaCactus3, 1.5390015f, 2.6390127f)) {
                    colision = true;
                    cz1 = 0.4f;
                }
            }
        }

        if (velocidadP3 == 122) {
            velocidadHitBox = 1.026f;
        }
        if (velocidadP3 == 184) {
            velocidadHitBox = 2.565f;
        }
        if (velocidadP3 == 222) {
            velocidadHitBox = -1.026f;
        }
        if (!colision) {

            if (velocidadP3 >= 123) {//En cada if hacer el m茅todo aleatorio de nuevo para el primero evalua con p3=1
                velocidadP1 += 2;
                velocidadP2 += 2;
                velocidadHitBox += 0.513f;
            }
            if (velocidadP3 >= 185) {
                velocidadP1 += 2;
                velocidadP2 += 2;
                velocidadHitBox += 0.513f;
            }
            if (velocidadP3 >= 223) {//223 224 225 
                velocidadP1 += 2;
                velocidadP2 += 2;
                velocidadHitBox += 0.513f;
                //System.out.println("\nk:" + velocidadP2);//Siempre debe coincidir con 120 para limpiar
                //System.out.println("c:" + velocidadP1);//Siempre debe coincidir con 240 para limpiar
            }
        } else {
            velocidadP1 -= 2;
            velocidadP2 -= 2;
        }
        if (velocidadP3 >= 255) {
            colision = true;
            fin = true;

            //restale los del ultimo avance a esos 2
            velocidadP1 -= 2;
            velocidadP2 -= 2;
        }
        if (colision) {
            stop();
        }
    }

    public void velocidades()
    {
        tiempoInicial = System.currentTimeMillis(); //Obtener el tiempo actual en milisegundos
        tiempoActual = tiempoInicial;

        while (tiempoActual - tiempoInicial <= 20160 * 1000) {
            try {
                //Bucle de tiempo para el primer intervalo de tiempo de 20160 milisegundos
                juego();
                sleep(84); //Esperar 42 milisegundos antes de la siguiente iteraci髇
                tiempoActual = System.currentTimeMillis(); //Actualizar el tiempo actual
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (tiempoActual - tiempoInicial <= 30240 * 1000) {
            try {
                //Bucle de tiempo para el segundo intervalo de tiempo de 10080 milisegundos
                juego();
                sleep(42); //Esperar 21 milisegundos antes de la siguiente iteraci髇
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiempoActual = System.currentTimeMillis(); //Actualizar el tiempo actual
        }

        while (tiempoActual - tiempoInicial <= 36960 * 1000) {
            try {
                //Bucle de tiempo para el tercer intervalo de tiempo de 6720 milisegundos
                juego();
                sleep(28); //Esperar 10 milisegundos antes de la siguiente iteraci髇
                tiempoActual = System.currentTimeMillis(); //Actualizar el tiempo actual
            } catch (InterruptedException ex) {
                Logger.getLogger(PartesJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (tiempoActual - tiempoInicial <= 41760 * 1000) {
            try {
                //Bucle de tiempo para el tercer intervalo de tiempo de 4800 milisegundos
                juego();
                sleep(20); //Esperar 10 milisegundos antes de la siguiente iteraci髇
                tiempoActual = System.currentTimeMillis(); //Actualizar el tiempo actual
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
