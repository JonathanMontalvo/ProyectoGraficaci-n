/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Jonathan Montalvo Pérez
 */
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
//import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Main implements GLEventListener, MouseListener, MouseMotionListener, /*MouseWheelListener,*/ KeyListener
{
    //Se hace este com//
    int elim;
    
    
    //Prueba edit valor
    int edit = 3;
    
    //Agregue desde github
    int pss = 58;
    
    //Prueba eliminar esto
    int ght;
    
    //Agregue esto desde netbeans
    int net1=15;
    
    //Agregue esto desde netbeans
    int net2=27;
    
    //Agregue esto desde netbeans
    int net3=39;
    
    
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256]; //to know which key is pressed

    //position of stan in the window
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;

    //Camera movements  
    private double zoom = 0.0;
    private double abajoYarriba = 0.0;
    private double izquierdaYderecha = 0.0;

    //sound
    Clip clip;
    static String normal = "src/Sonidos/normal.wav";
    static String caminar = "src/Sonidos/caminar.wav";
    static String saltar = "src/Sonidos/saltar.wav";
    static String agacharse = "src/Sonidos/agacharse.wav";
    static String apuntar = "src/Sonidos/knockout.wav";
    static String bailar = "src/Sonidos/bailar.wav";
    static String cintura = "src/Sonidos/cintura.wav";
    static String cara = "src/Sonidos/cara.wav";

    //Texture
    Texture tAtras1, tDerecha1, TIzquierda1, tPiso1,
            tAtras2, tDerecha2, TIzquierda2, tPiso2,
            tAtras3, tDerecha3, TIzquierda3, tPiso3,
            tAtras4, tDerecha4, TIzquierda4, tPiso4,
            tAtras5, tDerecha5, TIzquierda5, tPiso5,
            tAtras6, tDerecha6, TIzquierda6, tPiso6,
            tAtras7, tDerecha7, TIzquierda7, tPiso7;

    //velocidad
    int velocidadP1 = 2;
    int velocidadP2 = 2;
    float velocidadHitBox = 0.513f;
    int velocidadP3 = 1;
    float parte1 = -1.0f;
    int control1 = 1;

    //posicion objetos
    float c1 = 0.0f;
    float c2 = 0.0f;
    float c3 = 0.0f;
    float cz1 = 0.0f;
    float cz2 = 0.0f;
    float cz3 = 0.0f;

    //Colision
    //Pies
    float[] centroPieIzquierdo = {-0.03f, 0.0f, 0.0f};
    float[] centroPieDerecho = {-1.13f, 0.0f, 0.0f};

    //Cactus
    float[] centroCactus0 = {-0.565f, -1.41f, 0.0f};
    float[] centroCactus1 = {-0.565f, -1.41f, 0.0f};
    float[] centroCactus2 = {-0.565f, -1.41f, 0.0f};
    float[] centroCactus3 = {-0.565f, -1.41f, 0.0f};

    //Caja de los pies     
    cBoxObj cajaPieIzquierdo;
    cBoxObj cajaPieDerecho;

    //Caja de los cactus
    cBoxObj cajaCactus0;
    cBoxObj cajaCactus1;
    cBoxObj cajaCactus2;
    cBoxObj cajaCactus3;

    //Bandera de colisión
    boolean colision = false;
    boolean finT = false;

    //Bandera de final
    boolean fin = false;
    boolean most = false;

    //Creamos el hilo del contador
    Tiempo t = new Tiempo();

    public static void main(String[] args)
    {

        Frame frame = new Frame("Cuphead: Presiona \"H\" para saber las instrucciones de Cuphead Presiona \"A\" para saber quien desarrollo Cuphead");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Main());
        frame.add(canvas);
        frame.setSize(1000, 800);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();

    }

    public void init(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);

        // set up lighting
        float light_ambient[] = {0.9f, 0.9f, 0.9f, 1.0f};
        float light_diffuse[] = {0.3f, 0.3f, 0.3f, 1.0f};
        float light_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f, 1.5f, 1.0f, 0.0f};

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);

        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.50196078431f, 0.0f, 0.50196078431f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);

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
            System.out.println("Error en carga de imágen");
        }

        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        //drawable.addMouseWheelListener(this);
        drawable.addKeyListener(this);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
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
        //we draw Cuphead in the window        
        Cuphead cuphead = new Cuphead();
        KingDice kingdice = new KingDice();
        DrawPingu pingu = new DrawPingu();

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

        if (!colision) {
            gl.glPushMatrix();
            cuphead.cambioInstruccion(keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F']);
            gl.glTranslatef(0.0f, 0.0f, -2.0f);
            cuphead.draw_cuphead(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F'], false);
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
                //Se asignan en la posicion estática de los pies, pero con una altura mayor. Esto para evitar colisiones
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
            gl.glTranslatef(0.0f, 0.0f, c1 - ((float) velocidadP2 / 10));//Rango máximo 6.0f Rango mínimo 4.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 1 :0        
            centroCactus1[2] = cz1 - velocidadHitBox;
            cajaCactus1 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus1);

            //Cactus 2 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c2 - ((float) velocidadP2 / 10));//Rango máximo 12.0f Rango mínimo 10.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 2 :0        
            centroCactus2[2] = cz2 - velocidadHitBox;
            cajaCactus2 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus2);

            //Cactus 3 0:
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, c3 - ((float) velocidadP2 / 10));//Rango máximo 17.0f Rango mínimo 15.0f
            obstaculos.draw_obstacles(gl);
            gl.glPopMatrix();
            gl.glFlush();

            //caja cactus 3 :0
            centroCactus3[2] = cz3 - velocidadHitBox;
            cajaCactus3 = new cBoxObj(0.39f, 0.7f, 0.39f, centroCactus3);

            //Control fondo primera parte
            if ((velocidadP1 % 120) == 0) //Cuando llega a 120 va a cambiar la posicion del fondo
            {
                if ((control1 % 2) == 0) //Controlamos a que posición se debe colocar para que de el efecto de continuidad
                {
                    parte1 = -1.0f;//Esto es en la parte más cercana
                } else {
                    parte1 = 11.0f;//En la parte más alejada
                }
                velocidadP1 = 0;//Reiniciamos la velocidad
                control1++;//Es una bandera para controlar la posición
            }

            //Control fondo segunda parte
            if ((velocidadP2 % 240) == 0) //Cuando llegamos a 240 reinicia la velocidad, lo que altera la posición
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

                if (velocidadP3 >= 123) {//En cada if hacer el método aleatorio de nuevo para el primero evalua con p3=1
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
                //Si hay colisión
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.0f, -2.0f);
                cuphead.draw_cuphead(gl, false, false, false, false, false, false, false, true);
                gl.glPopMatrix();

                /*gl.glPushMatrix();
                 gl.glTranslatef(-0.3f, 0.7f, -1.0f);
                 gl.glScalef(0.4f, 0.4f, 0.4f);
                 kingdice.draw_KingDice(gl, keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
                 gl.glPopMatrix();*/
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.008f, -2.09f);
                gl.glScalef(0.65f, 0.65f, 0.65f);
                pingu.draw_pingu(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
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
                    System.out.println("" + t.getTiempo());
                    if (t.getTiempo().equals("00:00.00")) {
                        finT = true;
                        JOptionPane.showMessageDialog(null, "respuesta bien o mal", "Evaluar respuesta", JOptionPane.INFORMATION_MESSAGE);
                        Ventanas ventanaPerdio = new Ventanas("Nivel 1", 800, 400, false);
                        ventanaPerdio.ventanaPerdio();
                    }
                }

            } else {
                //Si es el fin del nivel
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 0.0f, -2.0f);
                cuphead.draw_cuphead(gl, false, false, false, false, true, false, false, false);
                gl.glPopMatrix();

                if (!most) {
                    most = true;
                    Ventanas ventanaN1 = new Ventanas("¡Felicidades terminó el nivel 1!", 800, 400, false);
                    ventanaN1.ventanaFinNivel1_2();
                }
            }
        }
    }

    // Función para verificar si hay intersección entre dos cajas de colisión
    public boolean interseccion(cBoxObj caja1, cBoxObj caja2, float c1, float c2)
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

        // Verificar colisión en el eje X
        if (izquierdaCaja1 >= derechaCaja2 && derechaCaja1 <= izquierdaCaja2) {
            hayColisionX = true;
        }

        // Verificar colisión en el eje Y
        if (arribaCaja1 >= abajoCaja2 && abajoCaja1 <= arribaCaja2) {
            hayColisionY = true;
        }

        // Verificar colisión en el eje Z
        if (adelanteCaja2 <= adelanteCaja1 - c1 && atrasCaja2 >= adelanteCaja1 - c2)//-2.6390127+adelanteCaja1 da -6.779013
        {
            hayColisionZ = true;
        }
        return hayColisionX && hayColisionY && hayColisionZ;
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseWheelMoved(MouseWheelEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e)
    {

        //int x = e.getX();
        //int y = e.getY();
        //Dimension size = e.getComponent().getSize();
        //float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        //float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        //oldMouseX = x;
        //oldMouseY = y;
        //view_rotx += thetaX;
        //view_roty += thetaY;
        //System.out.println("vX" + view_rotx);
        //System.out.println("vY" + view_roty);
    }

    public void keyPressed(KeyEvent e)
    {
        boolean bndEscenario[] = new boolean[256];
        bndEscenario['2'] = keys['2'];
        bndEscenario['3'] = keys['3'];
        bndEscenario['4'] = keys['4'];
        bndEscenario['5'] = keys['5'];
        bndEscenario['6'] = keys['6'];
        bndEscenario['7'] = keys['7'];

//        System.out.println("x: " + e.getKeyCode() + "\ny:" + e.getKeyChar());
        if (e.getKeyCode() < 250 && keys[e.getKeyCode()] == false) {
            keys['W'] = false;
            keys[' '] = false;
            keys['C'] = false;
            keys['E'] = false;
            keys['B'] = false;
            keys['Q'] = false;
            keys['F'] = false;
            keys['2'] = false;
            keys['3'] = false;
            keys['4'] = false;
            keys['5'] = false;
            keys['6'] = false;
            keys['7'] = false;
            keys[e.getKeyCode()] = true;
            if (e.getKeyChar() != '1' && e.getKeyChar() != '2' && e.getKeyChar() != '3' && e.getKeyChar() != '4'
                    && e.getKeyChar() != '5' && e.getKeyChar() != '6' && e.getKeyChar() != '7') {
                keys['2'] = bndEscenario['2'];
                keys['3'] = bndEscenario['3'];
                keys['4'] = bndEscenario['4'];
                keys['5'] = bndEscenario['5'];
                keys['6'] = bndEscenario['6'];
                keys['7'] = bndEscenario['7'];
            }
        } else {
            keys[e.getKeyCode()] = false;
        }

        if (e.getKeyChar() == 'I' || e.getKeyChar() == 'i') {
            zoom = -1.0f;
        } else if (e.getKeyChar() == 'O' || e.getKeyChar() == 'o') {
            zoom = 1.0f;
        } else if (e.getKeyChar() == 'N' || e.getKeyChar() == 'n') {
            zoom = 0.0f;
            abajoYarriba = 0.0f;
            izquierdaYderecha = 0.0f;
        } else if (e.getKeyCode() == 37)//Izquierda 
        {
            izquierdaYderecha = 1.0f;
        } else if (e.getKeyCode() == 38) //Arriba
        {
            abajoYarriba = 3.0f;
        } else if (e.getKeyCode() == 39) //Derecha
        {
            izquierdaYderecha = -1.0f;
        } else if (e.getKeyCode() == 40) //Abajo
        {
            abajoYarriba = 2.0f;
        } else if (e.getKeyChar() == 'H' || e.getKeyChar() == 'h') {
            JOptionPane.showMessageDialog(null, "Presiona \"W\" para caminar.\n"
                    + "Presiona la \" Barra de Espacio\" para saltar.\n"
                    + "Presiona \"C\" para agacharse.\n"
                    + "Presiona \"E\" para apuntar.\n"
                    + "Presiona \"B\" para bailar.\n"
                    + "Presiona \"Q\" para poner las manos en la cintura.\n"
                    + "Presiona \"F\" para poner la mano en la cara.\n"
                    + "\nPresiona del \"1-7\" para cambiar de escenario\n"
                    + "\nPresiona \"N\" para dejar la cámara normal.\n"
                    + "Presiona \"I\" para hacer zoom in.\n"
                    + "Presiona \"O\" para hacer zoom out.\n"
                    + "Presiona \"Flecha Arriba\" para mover la cámara a arriba.\n"
                    + "Presiona \"Flecha Abajo\" para mover la cámara a abajo.\n"
                    + "Presiona \"Flecha Izquierda\" para mover la cámara a la izquierda.\n"
                    + "Presiona \"Flecha Derecha\" para mover la cámara a la derecha.",
                    "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
            JOptionPane.showMessageDialog(null, "Desarrollado por: \nHernández Vázquez Bryan."
                    + "\nMontalvo Pérez Jonathan."
                    + "\nSalinas Díaz José Guillermo.",
                    "Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
            parar();
            reproducir(caminar);
        } else if (e.getKeyChar() == ' ') {
            parar();
            reproducir(saltar);
        } else if (e.getKeyChar() == 'C' || e.getKeyChar() == 'c') {
            parar();
            reproducir(agacharse);
        } else if (e.getKeyChar() == 'E' || e.getKeyChar() == 'e') {
            parar();
            reproducir(apuntar);
        } else if (e.getKeyChar() == 'B' || e.getKeyChar() == 'b') {
            parar();
            reproducir(bailar);
        } else if (e.getKeyChar() == 'Q' || e.getKeyChar() == 'q') {
            parar();
            reproducir(cintura);
        } else if (e.getKeyChar() == 'F' || e.getKeyChar() == 'f') {
            parar();
            reproducir(cara);
        } else if (e.getKeyChar() == 'G' || e.getKeyChar() == 'g') {
            parar();
            reproducir(normal);
        } else if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
            parar();
        }
    }

    public void parar()
    {
        try {
            clip.stop();
        } catch (NullPointerException nPE) {
        }
    }

    public void reproducir(String efecto)
    {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(efecto)));
            clip.start();
        } catch (Exception e) {
            System.out.println("Error de carga sonido");
        }
    }
}
