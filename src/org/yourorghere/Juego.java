/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Juego
{

    //Texture
    private Texture tAtras1, tDerecha1, TIzquierda1, tPiso1,
            tAtras2, tDerecha2, TIzquierda2, tPiso2,
            tAtras3, tDerecha3, TIzquierda3, tPiso3,
            tAtras4, tDerecha4, TIzquierda4, tPiso4,
            tAtras5, tDerecha5, TIzquierda5, tPiso5,
            tAtras6, tDerecha6, TIzquierda6, tPiso6,
            tAtras7, tDerecha7, TIzquierda7, tPiso7;

    //velocidad
    private static int velocidadP1 = 2;
    private static int velocidadP2 = 2;
    private static float velocidadHitBox = 0.513f;
    private static int velocidadP3 = 1;
    private static float parte1 = -1.0f;
    private static int control1 = 1;

    //posicion objetos
    private float c1 = 0.0f;
    private float c2 = 0.0f;
    private float c3 = 0.0f;
    private float cz1 = 0.0f;
    private float cz2 = 0.0f;
    private float cz3 = 0.0f;

    //Colision
    //Pies
    private float[] centroPieIzquierdo = {-0.03f, 0.0f, 0.0f};
    private float[] centroPieDerecho = {-1.13f, 0.0f, 0.0f};

    //Cactus
    private float[] centroCactus0 = {-0.565f, -1.41f, 0.0f};
    private float[] centroCactus1 = {-0.565f, -1.41f, 0.0f};
    private float[] centroCactus2 = {-0.565f, -1.41f, 0.0f};
    private float[] centroCactus3 = {-0.565f, -1.41f, 0.0f};

    //Caja de los pies     
    private cBoxObj cajaPieIzquierdo;
    private cBoxObj cajaPieDerecho;

    //Caja de los cactus
    private cBoxObj cajaCactus0;
    private cBoxObj cajaCactus1;
    private cBoxObj cajaCactus2;
    private cBoxObj cajaCactus3;

    //Bandera de colision
    private boolean colision = false;
    private boolean finT = false;

    //Bandera de final
    private boolean fin = false;
    private boolean most = false;

    //Creamos el hilo del contador
    private Tiempo t = new Tiempo();
    private final TextRenderer contador = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 55));
    private final TextRenderer pregunta = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
    private final TextRenderer respuesta1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private final TextRenderer respuesta2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private final TextRenderer respuesta3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private boolean mostrarVentanaPerder = false;

    //Creamos la preguntas y respuestas
    private PreguntasNivel1 p = new PreguntasNivel1();
    private Object[][] arr = null;
    private boolean preguntaNivel1 = false;
    private String preguntaNiv1 = "";
    private String respuestaNiv1 = "";
    private String respuestaNiv2 = "";
    private String respuestaNiv3 = "";
    private int respuestaCorrecta = -1;

    public Juego()
    {
    }

    public void texturasInit()
    {
        try {
            //Escenario 1
            File iAtras = new File("src/Fondos/casa.jpg");
            tAtras1 = TextureIO.newTexture(iAtras, true);
            File iDerecha = new File("src/Fondos/bosque.jpg");
            tDerecha1 = TextureIO.newTexture(iDerecha, true);
            File iIzquierda = new File("src/Fondos/bosque.jpg");
            TIzquierda1 = TextureIO.newTexture(iIzquierda, true);
            File iPiso = new File("src/Fondos/suelo.jpg");
            tPiso1 = TextureIO.newTexture(iPiso, true);

            //Escenario2
            iAtras = new File("src/Fondos/minecraftLado.jpg");
            tAtras2 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/minecraftLado.jpg");
            tDerecha2 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/minecraftLado.jpg");
            TIzquierda2 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/minecraftSuelo.jpg");
            tPiso2 = TextureIO.newTexture(iPiso, true);

            //Escenario3
            iAtras = new File("src/Fondos/feriaLados.jpg");
            tAtras3 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/feriaLados.jpg");
            tDerecha3 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/feriaLados.jpg");
            TIzquierda3 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/suelo.jpg");
            tPiso3 = TextureIO.newTexture(iPiso, true);

            //Escenario4
            iAtras = new File("src/Fondos/atraccion.jpg");
            tAtras4 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/atraccion.jpg");
            tDerecha4 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/atraccion.jpg");
            TIzquierda4 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tPiso4 = TextureIO.newTexture(iPiso, true);

            //Escenario5
            iAtras = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tAtras5 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/ladoCiudad.jpg");
            tDerecha5 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/ladoCiudad.jpg");
            TIzquierda5 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/sueloCiudad.jpg");
            tPiso5 = TextureIO.newTexture(iPiso, true);

            //Escenario6
            iAtras = new File("src/Fondos/atrasCarretera.jpg");
            tAtras6 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/ladoCarretera.jpg");
            tDerecha6 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/ladoCarretera.jpg");
            TIzquierda6 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/sueloCarretera.jpg");
            tPiso6 = TextureIO.newTexture(iPiso, true);

            //Escenario7
            iAtras = new File("src/Fondos/desiertoAtras.jpg");
            tAtras7 = TextureIO.newTexture(iAtras, true);
            iDerecha = new File("src/Fondos/desiertoLados.jpg");
            tDerecha7 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/desiertoLados.jpg");
            TIzquierda7 = TextureIO.newTexture(iIzquierda, true);
            iPiso = new File("src/Fondos/desiertoSuelo.jpg");
            tPiso7 = TextureIO.newTexture(iPiso, true);

        } catch (IOException iOE) {
            System.out.println("Error en carga de imagen en juego");
        }
    }

    public void displayJuego(GL gl, GLU glu, double zoom, double abajoYarriba, double izquierdaYderecha,
            final float X_POSITION, final float Y_POSITION, final float Z_POSITION, float view_rotx, float view_roty,
            boolean[] keys)
    {

        //glu.gluLookAt(0.1f, 0.0f, 4.0f + zoom,// eye
        glu.gluLookAt(0.1f, 0.0f, 5,// eye 4.0f
                0.0f, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );
//        glu.gluLookAt(1.0f + abajoYarriba, -1.0f, 4.0f + zoom,// eye
//                0.0f, 0.0f + izquierdaYderecha, 0.0f, // looking at
//                0.0f, 0.0f, 1.0f // is up
//        );

        if (abajoYarriba == 3.0f) {
            gl.glRotatef(70, 0.0f, 1.0f, 0.0f);
        } else if (izquierdaYderecha == 1.0f) {
            gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
            gl.glRotatef(-90, 0.0f, 0.0f, 1.0f);
        } else if (izquierdaYderecha == -1.0f) {
            gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
            gl.glRotatef(90, 0.0f, 0.0f, 1.0f);
        }
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        view_rotx = -70.233894f;
        view_roty = 0.01f;
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

        String tiempoContador = "";

        //we draw Cuphead in the window        
        Cuphead cuphead = new Cuphead();
        KingDice kingdice = new KingDice();
        DrawPingu pingu = new DrawPingu();
        TextRenderer preguntaJuego = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 40));

        //We draw Cactus in the window
        Obstaculos obstaculos = new Obstaculos();

        //Dibujamos la texturas del lado derecho 1
        //System.out.println(""+(velocidad/10));
        gl.glPushMatrix();
//        System.out.println("k:" + ((float) velocidadP1 / 10));
//        System.out.println("c:" + ((float) velocidadP2 / 10));
//        System.out.println("q:" + velocidadP3);
        gl.glTranslatef(0.0f, 4.0f, parte1);
        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(-((float) velocidadP1 / 10), 0.0f, 0.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tDerecha2);
            gl.glTranslatef(1.0f, 0.0f, 0.0f);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tDerecha3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tDerecha4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tDerecha5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tDerecha6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tDerecha7);
        } else {
            cuphead.fondo(gl, glu, tDerecha1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del lado derecho 2
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(-12.0f + ((float) velocidadP2 / 10), 0.0f, 12.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tDerecha2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tDerecha3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tDerecha4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tDerecha5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tDerecha6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tDerecha7);
        } else {
            cuphead.fondo(gl, glu, tDerecha1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del lado izquierdo 1
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, parte1);
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(((float) velocidadP1 / 10), 0.0f, 0.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, TIzquierda2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, TIzquierda3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, TIzquierda4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, TIzquierda5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, TIzquierda6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, TIzquierda7);
        } else {
            cuphead.fondo(gl, glu, TIzquierda1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del lado izquierdo 2
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(12.0f - ((float) velocidadP2 / 10), 0.0f, 12.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, TIzquierda2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, TIzquierda3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, TIzquierda4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, TIzquierda5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, TIzquierda6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, TIzquierda7);
        } else {
            cuphead.fondo(gl, glu, TIzquierda1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del piso 1
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, parte1);
        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, ((float) velocidadP1 / 10), 0.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tPiso2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tPiso3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tPiso4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tPiso5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tPiso6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tPiso7);
        } else {
            cuphead.fondo(gl, glu, tPiso1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del piso 2
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, 12.0f - ((float) velocidadP2 / 10), 12.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tPiso2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tPiso3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tPiso4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tPiso5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tPiso6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tPiso7);
        } else {
            cuphead.fondo(gl, glu, tPiso1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas de la casa
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tAtras2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tAtras3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tAtras4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tAtras5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tAtras6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tAtras7);
        } else {
            cuphead.fondo(gl, glu, tAtras1);
        }
        gl.glPopMatrix();
        gl.glFlush();
        //Es la parte del juego
        if (!colision) {
            gl.glPushMatrix();
            cuphead.cambioInstruccion(keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F']);
            gl.glTranslatef(0.10f, 0.0f, -2.0f);
            //Para los dem醩 solo vas aceptar el jump y walk, por lo que solo debes hacer dos cambios de estado en instrucciones
            cuphead.draw_cuphead(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F'], false, false);
            gl.glPopMatrix();

            // Flush all drawing operations to the graphics card
            gl.glFlush();

            if ((cuphead.pieIzq() == true && cuphead.pieDer() == false) || (cuphead.pieIzq() == false && cuphead.pieDer() == true)) {
                if (cuphead.pieIzq()) {
                    centroPieIzquierdo[1] = -3.17f;
                    centroPieIzquierdo[2] = -3.64f;
                    cajaPieIzquierdo = new cBoxObj(0.23f, 0.3f, 0.5f, centroPieIzquierdo);

                    centroPieDerecho[1] = -3.26f;
                    centroPieDerecho[2] = -3.075f;
                    cajaPieDerecho = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieDerecho);
                }

                if (cuphead.pieDer()) {
                    centroPieIzquierdo[1] = -3.26f;
                    centroPieIzquierdo[2] = -3.075f;
                    cajaPieIzquierdo = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieIzquierdo);

                    centroPieDerecho[1] = -3.17f;
                    centroPieDerecho[2] = -3.64f;
                    cajaPieDerecho = new cBoxObj(0.23f, 0.3f, 0.5f, centroPieDerecho);
                }
            } else {
                //Se asignan en la posicion est谩tica de los pies, pero con una altura mayor. Esto para evitar colisiones
                centroPieIzquierdo[1] = 3.26f;
                centroPieIzquierdo[2] = -3.075f;
                cajaPieIzquierdo = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieIzquierdo);

                centroPieDerecho[1] = 3.26f;
                centroPieDerecho[2] = -3.075f;
                cajaPieDerecho = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieDerecho);
            }

            //Creacion de los obstaculos
            //Cactus 0 :0
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, -((float) velocidadP2 / 10));
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 0 0:      
            centroCactus0[2] = 14.89f - velocidadHitBox;
            cajaCactus0 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus0);

            //Otorgar las posiciones
            if (velocidadP3 == 1 || velocidadP3 == 123 || velocidadP3 == 185 || velocidadP3 == 223) {
                c1 = 6.0f - obstaculos.numerosAleatorios();
                c2 = 12.0f - obstaculos.numerosAleatorios();
                c3 = 17.0f - obstaculos.numerosAleatorios();
                if (c1 == 4.0f) {//original 14.89f
                    cz1 = 25.15f;
                } else if (c1 == 5.0f) {
                    cz1 = 27.715f;
                } else {
                    cz1 = 30.28f;
                }

                if (c2 == 10.0f) {
                    cz2 = 40.54f;
                } else if (c2 == 11.0f) {
                    cz2 = 43.105f;
                } else {
                    cz2 = 45.67f;
                }

                if (c3 == 15.0f) {
                    cz3 = 53.365f;
                } else if (c3 == 16.0f) {
                    cz3 = 55.93f;
                } else {
                    cz3 = 58.495f;
                }

            }
            //Cactus 1 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c1 - ((float) velocidadP2 / 10));//Rango m谩ximo 6.0f Rango m铆nimo 4.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 1 :0        
            centroCactus1[2] = cz1 - velocidadHitBox;
            cajaCactus1 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus1);

            //Cactus 2 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c2 - ((float) velocidadP2 / 10));//Rango m谩ximo 12.0f Rango m铆nimo 10.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 2 :0        
            centroCactus2[2] = cz2 - velocidadHitBox;
            cajaCactus2 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus2);

            //Cactus 3 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c3 - ((float) velocidadP2 / 10));//Rango m谩ximo 17.0f Rango m铆nimo 15.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 3 :0
            centroCactus3[2] = cz3 - velocidadHitBox;
            cajaCactus3 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus3);

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
                if (cuphead.pieIzq()) {
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
                if (cuphead.pieDer()) {
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
                if (cuphead.pieIzq()) {
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
                if (cuphead.pieDer()) {
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
                if (cuphead.pieIzq()) {
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
                if (cuphead.pieDer()) {
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
                if (cuphead.pieIzq()) {
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
                if (cuphead.pieDer()) {
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

        } else {
            if (!fin) {
                //Si hay colisi贸n
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.0f, -2.0f);
                cuphead.draw_cuphead(gl, false, false, false, false, false, false, false, true, false);
                gl.glPopMatrix();

                /*gl.glPushMatrix();
                 gl.glTranslatef(-0.3f, 0.7f, -1.0f);
                 gl.glScalef(0.4f, 0.4f, 0.4f);
                 kingdice.draw_KingDice(gl, keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
                 gl.glPopMatrix();*/
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.008f, -2.09f);
                gl.glScalef(0.65f, 0.65f, 0.65f);
                //pingu.draw_pingu(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U'], false);
                pingu.draw_pingu(gl, keys['W'], keys[' '], false, false, false, false, false, false, false, false, false, false, false, false, false);

                gl.glPopMatrix();

                if (cz1 == 0.1f) {
                    //Cactus 0 :0
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, -((float) velocidadP2 / 10));
                    obstaculos.draw_obstacles(gl);
                    gl.glPopMatrix();
                    gl.glFlush();
                } else if (cz1 == 0.2f) {
                    //Cactus 1 0:
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, c1 - ((float) velocidadP2 / 10));
                    obstaculos.draw_obstacles(gl);
                    gl.glPopMatrix();
                    gl.glFlush();
                } else if (cz1 == 0.3f) {
                    //Cactus 2 0:
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, c2 - ((float) velocidadP2 / 10));
                    obstaculos.draw_obstacles(gl);
                    gl.glPopMatrix();
                    gl.glFlush();
                } else {
                    //Cactus 3 0:
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, c3 - ((float) velocidadP2 / 10));
                    obstaculos.draw_obstacles(gl);
                    gl.glPopMatrix();
                    gl.glFlush();
                }

                if (!most) {
                    most = true;
                    t.start();
                }

                if (!finT) {
                    tiempoContador = t.getTiempo();

                    if (!preguntaNivel1) {
                        arr = p.preguntaRespuesta();
                        preguntaNiv1 = (String) arr[0][0];
                        respuestaNiv1 = (String) arr[0][1];
                        respuestaNiv2 = (String) arr[0][2];
                        respuestaNiv3 = (String) arr[0][3];

                        for (int i = 0; i < 3; i++) {
                            if (arr[1][i] == (Object) true) {
                                respuestaCorrecta = i;
                                break;
                            }
                        }

                        preguntaNivel1 = true;
                    }

                    if (!tiempoContador.equals("00:00:00")) {
                        contador.beginRendering(1000, 800);
                        contador.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        contador.draw(tiempoContador, 400, 750);
                        contador.endRendering();

                        pregunta.beginRendering(1000, 800);
                        pregunta.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        pregunta.draw(preguntaNiv1, 300, 700);
                        pregunta.endRendering();

                        respuesta1.beginRendering(1000, 800);
                        respuesta1.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta1.draw(respuestaNiv1, 80, 170);
                        respuesta1.endRendering();

                        respuesta2.beginRendering(1000, 800);
                        respuesta2.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta2.draw(respuestaNiv2, 420, 170);
                        respuesta2.endRendering();

                        respuesta3.beginRendering(1000, 800);
                        respuesta3.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta3.draw(respuestaNiv3, 760, 170);
                        respuesta3.endRendering();
                    }

                    if (mostrarVentanaPerder) {

                        finT = true;
                        //La respuesta correcta esta en el n鷐ero de respuestaCorrecta(Inicia desde 0 y t閞mina en 2)

                        JOptionPane.showMessageDialog(null, "respuesta bien o mal" + respuestaCorrecta, "Evaluar respuesta", JOptionPane.INFORMATION_MESSAGE);
                        Ventanas ventanaPerdio = new Ventanas("Nivel 1", 800, 400, false);
                        ventanaPerdio.ventanaPerdio();
                    }

                    if (tiempoContador.equals("00:00.00")) {
                        mostrarVentanaPerder = true;
                    }
                }

            } else {
                //Si es el fin del nivel
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.0f, -2.0f);
                cuphead.draw_cuphead(gl, false, false, false, false, true, false, false, false, true);
                gl.glPopMatrix();

                if (!most) {
                    most = true;
                    Ventanas ventanaN1 = new Ventanas("隆Felicidades termin贸 el nivel 1!", 800, 400, false);
                    ventanaN1.ventanaFinNivel1_2();
                }
            }
        }
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
}
