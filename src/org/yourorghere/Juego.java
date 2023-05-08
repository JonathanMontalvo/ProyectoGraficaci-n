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

    //Movimiento del juego
    private boolean hiloVelocidades = false;
    public static boolean pieIzquierdo = true;
    public static boolean pieDerecho = false;
    private PartesJuego pJ = new PartesJuego();

    //Texture
    private Texture tAtras1, tDerecha1, TIzquierda1, tPiso1,
            tAtras2, tDerecha2, TIzquierda2, tPiso2,
            tAtras3, tDerecha3, TIzquierda3, tPiso3,
            tAtras4, tDerecha4, TIzquierda4, tPiso4,
            tAtras5, tDerecha5, TIzquierda5, tPiso5,
            tAtras6, tDerecha6, TIzquierda6, tPiso6,
            tAtras7, tDerecha7, TIzquierda7, tPiso7;

    //velocidad
    public static int velocidadP1 = 1;
    public static int velocidadP2 = 1;
    public static float velocidadHitBox = 0.256f;
    public static int velocidadP3 = 1;
    public static float parte1 = -1.0f;
    public static int control1 = 1;

    //posicion objetos
    private float c1 = 0.0f;
    private float c2 = 0.0f;
    private float c3 = 0.0f;
    public static float cz1 = 0.0f;
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
    public static cBoxObj cajaPieIzquierdo;
    public static cBoxObj cajaPieDerecho;

    //Caja de los cactus
    public static cBoxObj cajaCactus0;
    public static cBoxObj cajaCactus1;
    public static cBoxObj cajaCactus2;
    public static cBoxObj cajaCactus3;

    //Bandera de colision
    public static boolean colision = false;
    private boolean finT = false;

    //Bandera de final
    public static boolean fin = false;
    private boolean most = false;

    //Creamos el hilo del contador
    private Tiempo t = new Tiempo();
    private TextRenderer contador = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 55));
    private TextRenderer pregunta = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
    private TextRenderer seleccione = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 39));
    private TextRenderer respuesta1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private TextRenderer respuesta2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private TextRenderer respuesta3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private TextRenderer tecla1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private TextRenderer tecla2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private TextRenderer tecla3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
    private boolean mostrarVentanaPerder = false;

    //Creamos la preguntas y respuestas
    private PreguntasNivel1 p1 = new PreguntasNivel1();
    private PreguntasNivel2 p2 = new PreguntasNivel2();
    private PreguntasNivel3 p3 = new PreguntasNivel3();
    private Object[][] arr = null;
    private boolean preguntaNivel1 = false;
    private String preguntaNiv1 = "";
    private String respuestaNiv1 = "";
    private String respuestaNiv2 = "";
    private String respuestaNiv3 = "";
    private String letra = "";
    private int respuestaCorrecta = -1;
    private int respuestaPlayer = 0;

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
            int bndKey, boolean[] keys)
    {

        glu.gluLookAt(0.1f, 0.0f, 5,// eye 4.0f
                0.0f, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );

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

        gl.glPushMatrix();;
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
            if (bndKey == 1) {
                gl.glPushMatrix();
                pingu.cambioInstruccion(keys['W'], keys[' ']);
                gl.glTranslatef(0.0f, 0.008f, -2.09f);
                gl.glScalef(0.65f, 0.65f, 0.65f);
                pingu.draw_pingu(gl, keys['W'], keys[' '], false, false, false, false, false, false, false, false, false, false, false, false, false, false);
                gl.glPopMatrix();

                // Flush all drawing operations to the graphics card
                gl.glFlush();

                pieIzquierdo = pingu.pieIzq();
                pieDerecho = pingu.pieDer();
            } else if (bndKey == 2 || bndKey == 3) //bndKey 2 es kingdice, pero no tiene caminar
            {
                gl.glPushMatrix();
                cuphead.cambioInstruccion(keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F']);
                gl.glTranslatef(0.10f, 0.0f, -2.0f);
                //Para los dem·s solo vas aceptar el jump y walk, por lo que solo debes hacer dos cambios de estado en instrucciones
                cuphead.draw_cuphead(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F'], false, false);
                gl.glPopMatrix();

                // Flush all drawing operations to the graphics card
                gl.glFlush();

                pieIzquierdo = cuphead.pieIzq();
                pieDerecho = cuphead.pieDer();
            }

            if ((pieIzquierdo == true && pieDerecho == false) || (pieIzquierdo == false && pieDerecho == true)) {
                if (pieIzquierdo) {
                    centroPieIzquierdo[1] = -3.17f;
                    centroPieIzquierdo[2] = -3.64f;
                    cajaPieIzquierdo = new cBoxObj(0.23f, 0.3f, 0.5f, centroPieIzquierdo);

                    centroPieDerecho[1] = -3.26f;
                    centroPieDerecho[2] = -3.075f;
                    cajaPieDerecho = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieDerecho);
                }

                if (pieDerecho) {
                    centroPieIzquierdo[1] = -3.26f;
                    centroPieIzquierdo[2] = -3.075f;
                    cajaPieIzquierdo = new cBoxObj(0.23f, 0.3f, 0.74f, centroPieIzquierdo);

                    centroPieDerecho[1] = -3.17f;
                    centroPieDerecho[2] = -3.64f;
                    cajaPieDerecho = new cBoxObj(0.23f, 0.3f, 0.5f, centroPieDerecho);
                }
            } else {
                //Se asignan en la posicion est√°tica de los pies, pero con una altura mayor. Esto para evitar colisiones
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
            if (velocidadP3 == 1 || velocidadP3 == 240 || velocidadP3 == 480 || velocidadP3 == 720) {
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
            gl.glTranslatef(0.0f, 0.0f, c1 - ((float) velocidadP2 / 10));//Rango m√°ximo 6.0f Rango m√≠nimo 4.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 1 :0        
            centroCactus1[2] = cz1 - velocidadHitBox;
            cajaCactus1 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus1);

            //Cactus 2 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c2 - ((float) velocidadP2 / 10));//Rango m√°ximo 12.0f Rango m√≠nimo 10.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 2 :0        
            centroCactus2[2] = cz2 - velocidadHitBox;
            cajaCactus2 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus2);

            //Cactus 3 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c3 - ((float) velocidadP2 / 10));//Rango m√°ximo 17.0f Rango m√≠nimo 15.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 3 :0
            centroCactus3[2] = cz3 - velocidadHitBox;
            cajaCactus3 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus3);

            if (!hiloVelocidades) {
                pJ.start();
                hiloVelocidades = true;
            }

        } else {
            if (!fin) {
                //Si hay colision
                if (bndKey == 1) {
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.008f, -2.09f);
                    if (keys['U'] || keys['u']) {
                        gl.glTranslatef(0.0f, 0.0f, 0.0f);
                        this.respuestaPlayer = 0;
                    } else if (keys['I'] || keys['i']) {
                        gl.glTranslatef(0.0f, 0.0f, 2.0f);
                        this.respuestaPlayer = 1;
                    } else if (keys['O'] || keys['o']) {
                        gl.glTranslatef(0.0f, 0.0f, 3.6f);
                        this.respuestaPlayer = 2;
                    } else {
                    }
                    gl.glScalef(0.65f, 0.65f, 0.65f);
                    pingu.draw_pingu(gl, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
                    gl.glPopMatrix();

                    // Flush all drawing operations to the graphics card
                    gl.glFlush();
                } else if (bndKey == 2 || bndKey == 3) //bndKey 2 es kingdice, pero no tiene caminar
                {
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, -2.0f);
                    if (keys['U'] || keys['u']) {
                        gl.glTranslatef(0.0f, 0.0f, 0.0f);
                        this.respuestaPlayer = 0;
                    } else if (keys['I'] || keys['i']) {
                        gl.glTranslatef(0.0f, 0.0f, 2.0f);
                        this.respuestaPlayer = 1;
                    } else if (keys['O'] || keys['o']) {
                        gl.glTranslatef(0.0f, 0.0f, 3.6f);
                        this.respuestaPlayer = 2;
                    } else {
                    }
                    cuphead.draw_cuphead(gl, false, false, false, false, false, false, false, true, false);
                    gl.glPopMatrix();

                    // Flush all drawing operations to the graphics card
                    gl.glFlush();
                }

                /*gl.glPushMatrix();
                 gl.glTranslatef(-0.3f, 0.7f, -1.0f);
                 gl.glScalef(0.4f, 0.4f, 0.4f);
                 kingdice.draw_KingDice(gl, keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
                 gl.glPopMatrix();*/
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

                //Preguntas y contador
                if (!most) {
                    most = true;
                    t.start();
                }

                if (!finT) {
                    tiempoContador = t.getTiempo();

                    if (!preguntaNivel1) {
                        //arr = p1.preguntaRespuesta();
                        //arr = p2.matriz();
                        arr = p3.matriz();
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
                        pregunta.draw(preguntaNiv1, 10, 700);
                        //pregunta.draw(preguntaNiv1, 300, 700);
                        pregunta.endRendering();

                        seleccione.beginRendering(1000, 800);
                        seleccione.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        seleccione.draw("Presione una tecla para elegir su respuesta", 90, 120);
                        seleccione.endRendering();

                        respuesta1.beginRendering(1000, 800);
                        respuesta1.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta1.draw(respuestaNiv1, 80, 170);
                        respuesta1.endRendering();

                        switch (respuestaNiv1.length()) {
                            case 6:
                                letra = "  U";
                                break;
                            case 7:
                                letra = "   U";
                                break;
                            case 8:
                                letra = "   U";
                                break;
                            case 9:
                                letra = "    U";
                                break;
                        }

                        tecla1.beginRendering(1000, 800);
                        tecla1.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        tecla1.draw(letra, 80, 70);
                        tecla1.endRendering();

                        respuesta2.beginRendering(1000, 800);
                        respuesta2.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta2.draw(respuestaNiv2, 420, 170);
                        respuesta2.endRendering();

                        switch (respuestaNiv2.length()) {
                            case 6:
                                letra = "  I";
                                break;
                            case 7:
                                letra = "   I";
                                break;
                            case 8:
                                letra = "   I";
                                break;
                            case 9:
                                letra = "    I";
                                break;
                        }

                        tecla2.beginRendering(1000, 800);
                        tecla2.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        tecla2.draw(letra, 420, 70);
                        tecla2.endRendering();

                        respuesta3.beginRendering(1000, 800);
                        respuesta3.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        respuesta3.draw(respuestaNiv3, 760, 170);
                        respuesta3.endRendering();

                        switch (respuestaNiv3.length()) {
                            case 6:
                                letra = "  O";
                                break;
                            case 7:
                                letra = "   O";
                                break;
                            case 8:
                                letra = "   O";
                                break;
                            case 9:
                                letra = "    O";
                                break;
                        }

                        tecla3.beginRendering(1000, 800);
                        tecla3.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                        tecla3.draw(letra, 760, 70);
                        tecla3.endRendering();
                    }

                    if (mostrarVentanaPerder) {

                        finT = true;
                        //La respuesta correcta esta en el n˙mero de respuestaCorrecta(Inicia desde 0 y tÈrmina en 2)
                        if (respuestaCorrecta == respuestaPlayer) {
                            JOptionPane.showMessageDialog(null, "°Respuesta correcta!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "°Respuesta incorrecta!\nLa respuesta " + (arr[0][respuestaCorrecta + 1]).toString().toLowerCase(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Ventanas ventanaPerdio = new Ventanas("Nivel 1", 800, 400, false);
                        ventanaPerdio.ventanaPerdio();
                    }

                    if (tiempoContador.equals("00:00.00")) {
                        mostrarVentanaPerder = true;
                    }
                }

            } else {
                //Si es el fin del nivel
                if (bndKey == 1) {
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.008f, -2.09f);
                    gl.glScalef(0.65f, 0.65f, 0.65f);
                    pingu.draw_pingu(gl, false, false, false, false, false, true, false, false, false, false, false, false, false, false, true, false);
                    gl.glPopMatrix();

                    // Flush all drawing operations to the graphics card
                    gl.glFlush();
                } else if (bndKey == 2 || bndKey == 3) //bndKey 2 es kingdice, pero no tiene caminar
                {
                    gl.glPushMatrix();
                    gl.glTranslatef(0.0f, 0.0f, -2.0f);
                    cuphead.draw_cuphead(gl, false, false, false, false, true, false, false, false, false);
                    gl.glPopMatrix();

                    // Flush all drawing operations to the graphics card
                    gl.glFlush();
                }

                if (!most) {
                    most = true;
                    Ventanas ventanaN1 = new Ventanas("°Felicidades termino el nivel 1!", 800, 400, false);
                    ventanaN1.ventanaFinNivel1_2();
                }
            }
        }
    }

    public void reiniciarJuego()
    {
        //Movimiento del juego
        this.hiloVelocidades = false;
        Juego.pieIzquierdo = true;
        Juego.pieDerecho = false;
        this.pJ = new PartesJuego();
        //velocidad
        Juego.velocidadP1 = 1;
        Juego.velocidadP2 = 1;
        Juego.velocidadHitBox = 0.256f;
        Juego.velocidadP3 = 1;
        Juego.parte1 = -1.0f;
        Juego.control1 = 1;

        //posicion objetos
        this.c1 = 0.0f;
        this.c2 = 0.0f;
        this.c3 = 0.0f;
        Juego.cz1 = 0.0f;
        this.cz2 = 0.0f;
        this.cz3 = 0.0f;

        //Colision
        //Pies
        this.centroPieIzquierdo = new float[]{-0.03f, 0.0f, 0.0f};
        this.centroPieDerecho = new float[]{-1.13f, 0.0f, 0.0f};

        //Cactus
        this.centroCactus0 = new float[]{-0.565f, -1.41f, 0.0f};
        this.centroCactus1 = new float[]{-0.565f, -1.41f, 0.0f};
        this.centroCactus2 = new float[]{-0.565f, -1.41f, 0.0f};
        this.centroCactus3 = new float[]{-0.565f, -1.41f, 0.0f};

        //Bandera de colision
        Juego.colision = false;
        this.finT = false;

        //Bandera de final
        Juego.fin = false;
        this.most = false;

        //Creamos el hilo del contador
        this.t = new Tiempo();
        this.mostrarVentanaPerder = false;
        this.contador = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 55));
        //this.pregunta = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
        this.pregunta = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 28));
        this.seleccione = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 39));
        //this.respuesta1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
        this.respuesta1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 24));
        //this.respuesta2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
        this.respuesta2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 24));
        //this.respuesta3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
        this.respuesta3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 24));
        this.tecla1 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
        this.tecla2 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));
        this.tecla3 = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 36));

        //Creamos la preguntas y respuestas
        this.arr = null;
        this.preguntaNivel1 = false;
        this.preguntaNiv1 = "";
        this.respuestaNiv1 = "";
        this.respuestaNiv2 = "";
        this.respuestaNiv3 = "";
        this.letra = "";
        this.respuestaCorrecta = -1;
        this.respuestaPlayer = 0;
    }
}
