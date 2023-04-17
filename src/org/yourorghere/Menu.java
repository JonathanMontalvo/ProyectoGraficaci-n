/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Elizabeth
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
import java.awt.event.MouseWheelListener;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame implements GLEventListener, MouseListener, MouseMotionListener, KeyListener, MouseWheelListener  {

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256]; //to know which key is pressed

    //position of stan in the window
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;

    Clip clip;
    static String caminar = "src/Sonidos/camion.wav";
    static String saltar = "src/Sonidos/coin.wav";
    static String grunir = "src/Sonidos/tuberia.wav";

    private double zoom = 3.5;
    public static int per=0;
    public static int selec=1;
    

    //Textura
    Texture tAtras1, tFrente1, tDerecha1, TIzquierda1, tTecho1, tPiso1,tAtras2, tFrente2, tDerecha2, TIzquierda2, tTecho2, tPiso2,
            tAtras3, tFrente3, tDerecha3, TIzquierda3, tTecho3, tPiso3,tAtras4, tFrente4, tDerecha4, TIzquierda4, tTecho4, tPiso4,
            tAtras5, tFrente5, tDerecha5, TIzquierda5, tTecho5, tPiso5,tAtras6, tFrente6, tDerecha6, TIzquierda6, tTecho6, tPiso6,
            tAtras7, tFrente7, tDerecha7, TIzquierda7, tTecho7, tPiso7,
            tAtrasK1,tFrenteK1,tDerechaK1,TIzquierdaK1,tTechoK1,tPisoK1,tAtrasK2,tFrenteK2,tDerechaK2,TIzquierdaK2,tTechoK2,tPisoK2,
            tAtrasK3,tFrenteK3,tDerechaK3,TIzquierdaK3,tTechoK3,tPisoK3,tAtrasK4,tFrenteK4,tDerechaK4,TIzquierdaK4,tTechoK4,tPisoK4,
            tAtrasK5,tFrenteK5,tDerechaK5,TIzquierdaK5,tTechoK5,tPisoK5,tAtrasK6,tFrenteK6,tDerechaK6,TIzquierdaK6,tTechoK6,tPisoK6,
            tAtrasK7,tFrenteK7,tDerechaK7,TIzquierdaK7,tTechoK7,tPisoK7,
            tAtrasP1,tFrenteP1,tDerechaP1,TIzquierdaP1,tTechoP1,tPisoP1,tAtrasP2,tFrenteP2,tDerechaP2,TIzquierdaP2,tTechoP2,tPisoP2,
            tAtrasP3,tFrenteP3,tDerechaP3,TIzquierdaP3,tTechoP3,tPisoP3,tAtrasP4,tFrenteP4,tDerechaP4,TIzquierdaP4,tTechoP4,tPisoP4,
            tAtrasP5,tFrenteP5,tDerechaP5,TIzquierdaP5,tTechoP5,tPisoP5,tAtrasP6,tFrenteP6,tDerechaP6,TIzquierdaP6,tTechoP6,tPisoP6,
            tAtrasP7,tFrenteP7,tDerechaP7,TIzquierdaP7,tTechoP7,tPisoP7;

        public static int sel;
//Componentes menu        
    private static javax.swing.JComboBox jComboBox1;
    private static  javax.swing.JLabel labTitulo;
    private static  javax.swing.JLabel labSel;
    public void Menuu()
    {
        
    }
    public static void main(String[] args) {

        Frame frame = new Frame("Menu");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Menu());
    jComboBox1 = new javax.swing.JComboBox();
    labTitulo = new javax.swing.JLabel();
    labSel = new javax.swing.JLabel();
    labSel.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        labSel.setText("Seleccion de personaje :");
        labSel.setBounds(25,35,490,45);
    frame.add(labSel);
     jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cuphead", "King Dice", "Pingu" }));
        jComboBox1.setBounds(25,85,250,45);
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        frame.add(jComboBox1);
    JButton boton1 = new JButton();
    boton1.setText("Ver personaje");
    boton1.setBounds(25,140,220,30);
    boton1.setEnabled(true);
    boton1.setMnemonic('a');
    boton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botonVerActionPerformed(evt);
            }
        });
    frame.add(boton1);
    labTitulo.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        labTitulo.setText("Instrucciones");
        labTitulo.setBounds(25,180,280,45);
    frame.add(labTitulo);
    JButton boton2 = new JButton();
    boton2.setText("Ver Instrucciones");
    boton2.setBounds(25,230,220,30);
    boton2.setEnabled(true);
    boton2.setMnemonic('a');
    boton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botonVerInsActionPerformed(evt);
            }
        });
    frame.add(boton2);
    JButton boton3 = new JButton();
    boton3.setText("Jugar");
    boton3.setBounds(25,270,220,30);
    boton3.setEnabled(true);
    boton3.setMnemonic('a');
    boton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botonPlayActionPerformed(evt);
            }
        });
    frame.add(boton3);
        frame.add(canvas);
        frame.setSize(1000, 800);
        
        final Animator animator = new Animator(canvas);
 
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {
                    public void run() {
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

    public void init(GLAutoDrawable drawable) {

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
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
        gl.glShadeModel(GL.GL_SMOOTH);

 try {
            //Escenario 1
            File iAtras = new File("src/Fondos/casa.jpg");
            tAtras1 = TextureIO.newTexture(iAtras, true);
            File iFrente = new File("src/Fondos/feria.jpg");
            tFrente1 = TextureIO.newTexture(iFrente, true);
            File iDerecha = new File("src/Fondos/bosque.jpg");
            tDerecha1 = TextureIO.newTexture(iDerecha, true);
            File iIzquierda = new File("src/Fondos/bosque.jpg");
            TIzquierda1 = TextureIO.newTexture(iIzquierda, true);
            File iTecho = new File("src/Fondos/cielo.jpg");
            tTecho1 = TextureIO.newTexture(iTecho, true);
            File iPiso = new File("src/Fondos/suelo.jpg");
            tPiso1 = TextureIO.newTexture(iPiso, true);

            //Escenario2
            iAtras = new File("src/Fondos/minecraftLado.jpg");
            tAtras2 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/minecraftFrente.jpg");
            tFrente2 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/minecraftLado.jpg");
            tDerecha2 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/minecraftLado.jpg");
            TIzquierda2 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/minecraftCielo.jpg");
            tTecho2 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/minecraftSuelo.jpg");
            tPiso2 = TextureIO.newTexture(iPiso, true);

            //Escenario3
            iAtras = new File("src/Fondos/feriaLados.jpg");
            tAtras3 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/feriaFrente.jpg");
            tFrente3 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/feriaLados.jpg");
            tDerecha3 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/feriaLados.jpg");
            TIzquierda3 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/cieloNoche.jpg");
            tTecho3 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/suelo.jpg");
            tPiso3 = TextureIO.newTexture(iPiso, true);

            //Escenario4
            iAtras = new File("src/Fondos/atraccion.jpg");
            tAtras4 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/atraccion.jpg");
            tFrente4 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/atraccion.jpg");
            tDerecha4 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/atraccion.jpg");
            TIzquierda4 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tTecho4 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tPiso4 = TextureIO.newTexture(iPiso, true);

            //Escenario5
            iAtras = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tAtras5 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tFrente5 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/ladoCiudad.jpg");
            tDerecha5 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/ladoCiudad.jpg");
            TIzquierda5 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/cieloCiudad.jpg");
            tTecho5 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/sueloCiudad.jpg");
            tPiso5 = TextureIO.newTexture(iPiso, true);

            //Escenario6
            iAtras = new File("src/Fondos/atrasCarretera.jpg");
            tAtras6 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/frenteCarretera.jpg");
            tFrente6 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/ladoCarretera.jpg");
            tDerecha6 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/ladoCarretera.jpg");
            TIzquierda6 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/cieloCarretera.jpg");
            tTecho6 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/sueloCarretera.jpg");
            tPiso6 = TextureIO.newTexture(iPiso, true);

            //Escenario7
            iAtras = new File("src/Fondos/desiertoAtras.jpg");
            tAtras7 = TextureIO.newTexture(iAtras, true);
            iFrente = new File("src/Fondos/desiertoFrente.jpg");
            tFrente7 = TextureIO.newTexture(iFrente, true);
            iDerecha = new File("src/Fondos/desiertoLados.jpg");
            tDerecha7 = TextureIO.newTexture(iDerecha, true);
            iIzquierda = new File("src/Fondos/desiertoLados.jpg");
            TIzquierda7 = TextureIO.newTexture(iIzquierda, true);
            iTecho = new File("src/Fondos/desiertoCielo.jpg");
            tTecho7 = TextureIO.newTexture(iTecho, true);
            iPiso = new File("src/Fondos/desiertoSuelo.jpg");
            tPiso7 = TextureIO.newTexture(iPiso, true);
            //Escenario King Dice
             File tAtrask = new File("src/Fondos/f1.jpg");
            tAtrasK1 = TextureIO.newTexture(tAtrask, true);
            File tFrentek = new File("src/Fondos/f1.jpg");
            tFrenteK1 = TextureIO.newTexture(tFrentek, true);
            File iDerechak = new File("src/Fondos/f1.jpg");
            tDerechaK1 = TextureIO.newTexture(iDerechak, true);
            File iIzquierdak = new File("src/Fondos/f1.jpg");
            TIzquierdaK1 = TextureIO.newTexture(iIzquierdak, true);
            File iTechok = new File("src/Fondos/r3.jpg");
            tTechoK1 = TextureIO.newTexture(iTechok, true);
            File iPisok = new File("src/Fondos/p.jpg");
            tPisoK1 = TextureIO.newTexture(iPisok, true);
            //2
            tAtrask = new File("src/Fondos/f2.jpg");
            tAtrasK2 = TextureIO.newTexture(tAtrask, true);
             tFrentek = new File("src/Fondos/f2.jpg");
            tFrenteK2 = TextureIO.newTexture(tFrentek, true);
            iDerechak = new File("src/Fondos/f2.jpg");
            tDerechaK2 = TextureIO.newTexture(iDerechak, true);
            iIzquierdak = new File("src/Fondos/f2.jpg");
            TIzquierdaK2 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK2 = TextureIO.newTexture(iTechok, true);
            iPisok = new File("src/Fondos/p.jpg");
            tPisoK2 = TextureIO.newTexture(iPisok, true);
            //3
            tAtrask = new File("src/Fondos/f3.jpg");
            tAtrasK3 = TextureIO.newTexture(tAtrask, true);
            tFrentek = new File("src/Fondos/f3.jpg");
            tFrenteK3 = TextureIO.newTexture(tFrentek, true);
            iDerechak = new File("src/Fondos/f3.jpg");
            tDerechaK3 = TextureIO.newTexture(iDerechak, true);
            iIzquierdak = new File("src/Fondos/f3.jpg");
            TIzquierdaK3 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK3 = TextureIO.newTexture(iTechok, true);
            iPisok = new File("src/Fondos/p.jpg");
            tPisoK3 = TextureIO.newTexture(iPisok, true);
            //4
             tAtrask = new File("src/Fondos/e.jpg");
            tAtrasK4 = TextureIO.newTexture(tAtrask, true);
             tFrentek = new File("src/Fondos/e.jpg");
            tFrenteK4 = TextureIO.newTexture(tFrentek, true);
             iDerechak = new File("src/Fondos/e.jpg");
            tDerechaK4 = TextureIO.newTexture(iDerechak, true);
             iIzquierdak = new File("src/Fondos/e.jpg");
            TIzquierdaK4 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK4 = TextureIO.newTexture(iTechok, true);
             iPisok = new File("src/Fondos/p.jpg");
            tPisoK4 = TextureIO.newTexture(iPisok, true);
            //5
            tAtrask = new File("src/Fondos/f4.jpg");
            tAtrasK5 = TextureIO.newTexture(tAtrask, true);
            tFrentek = new File("src/Fondos/f4.jpg");
            tFrenteK5 = TextureIO.newTexture(tFrentek, true);
            iDerechak = new File("src/Fondos/f4.jpg");
            tDerechaK5 = TextureIO.newTexture(iDerechak, true);
            iIzquierdak = new File("src/Fondos/f4.jpg");
            TIzquierdaK5 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK5 = TextureIO.newTexture(iTechok, true);
            iPisok = new File("src/Fondos/p.jpg");
            tPisoK5 = TextureIO.newTexture(iPisok, true);
            //6
            tAtrask = new File("src/Fondos/f5.jpg");
            tAtrasK6 = TextureIO.newTexture(tAtrask, true);
            tFrentek = new File("src/Fondos/f5.jpg");
            tFrenteK6 = TextureIO.newTexture(tFrentek, true);
            iDerechak = new File("src/Fondos/f5.jpg");
            tDerechaK6 = TextureIO.newTexture(iDerechak, true);
            iIzquierdak = new File("src/Fondos/f5.jpg");
            TIzquierdaK6 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK6 = TextureIO.newTexture(iTechok, true);
            iPisok = new File("src/Fondos/p.jpg");
            tPisoK6 = TextureIO.newTexture(iPisok, true);
            //7
            tAtrask = new File("src/Fondos/c.jpg");
            tAtrasK7 = TextureIO.newTexture(tAtrask, true);
            tFrentek = new File("src/Fondos/c.jpg");
            tFrenteK7 = TextureIO.newTexture(tFrentek, true);
            iDerechak = new File("src/Fondos/c.jpg");
            tDerechaK7 = TextureIO.newTexture(iDerechak, true);
            iIzquierdak = new File("src/Fondos/c.jpg");
            TIzquierdaK7 = TextureIO.newTexture(iIzquierdak, true);
            iTechok = new File("src/Fondos/r3.jpg");
            tTechoK7 = TextureIO.newTexture(iTechok, true);
            iPisok = new File("src/Fondos/p.jpg");
            tPisoK7 = TextureIO.newTexture(iPisok, true);
            //Escenario Pingu
                File iAtrasP = new File("src/Fondos/i1.jpg");
            File iFrenteP = new File("src/Fondos/i6.jpg");
            File iDerechaP = new File("src/Fondos/i3.jpg");
            File iIzquierdaP = new File("src/Fondos/i5.jpg");
            File iTechoP = new File("src/Fondos/i4.jpg");
            File iPisoP = new File("src/Fondos/i2.jpg");
            tAtrasP1 = TextureIO.newTexture(iAtrasP, true);
                    tFrenteP1 = TextureIO.newTexture(iFrenteP, true);
                    tDerechaP1 = TextureIO.newTexture(iDerechaP, true);
                    TIzquierdaP1 = TextureIO.newTexture(iIzquierdaP, true);
                    tTechoP1 = TextureIO.newTexture(iTechoP, true);
                    tPisoP1 = TextureIO.newTexture(iPisoP, true);
//2
            iAtrasP = new File("src/Fondos/i8.jpg");
            iFrenteP = new File("src/Fondos/i9.jpg");
            iDerechaP = new File("src/Fondos/i10.jpg");
            iIzquierdaP = new File("src/Fondos/i11.jpg");
            iTechoP = new File("src/Fondos/i4.jpg");
            iPisoP = new File("src/Fondos/i12.jpg");
                    tAtrasP2 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP2 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP2 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP2 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP2 = TextureIO.newTexture(iTechoP, false);
                    tPisoP2 = TextureIO.newTexture(iPisoP, false);
          //3
            iAtrasP = new File("src/Fondos/i13.jpg");
            iFrenteP = new File("src/Fondos/i14.jpg");
            iDerechaP = new File("src/Fondos/i15.jpg");
            iIzquierdaP = new File("src/Fondos/i16.jpg");
            iTechoP = new File("src/Fondos/i18.jpg");
            iPisoP = new File("src/Fondos/i17.jpg");
                    tAtrasP3 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP3 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP3 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP3 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP3 = TextureIO.newTexture(iTechoP, false);
                    tPisoP3 = TextureIO.newTexture(iPisoP, false);
                    ///4
            iAtrasP = new File("src/Fondos/i19.jpg");
            iFrenteP = new File("src/Fondos/i20.jpg");
            iDerechaP = new File("src/Fondos/i21.jpg");
            iIzquierdaP = new File("src/Fondos/i22.jpg");
            iTechoP = new File("src/Fondos/i24.jpg");
            iPisoP = new File("src/Fondos/i23.jpg");
                    tAtrasP4 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP4 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP4 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP4 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP4 = TextureIO.newTexture(iTechoP, false);
                    tPisoP4 = TextureIO.newTexture(iPisoP, false);
                    //5
            iAtrasP = new File("src/Fondos/i25.jpg");
            iFrenteP = new File("src/Fondos/i26.jpg");
            iDerechaP = new File("src/Fondos/i27.jpg");
            iIzquierdaP = new File("src/Fondos/i28.jpg");
            iTechoP = new File("src/Fondos/i30.jpg");
            iPisoP = new File("src/Fondos/i29.jpg");
                    tAtrasP5 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP5 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP5 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP5 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP5 = TextureIO.newTexture(iTechoP, false);
                    tPisoP5 = TextureIO.newTexture(iPisoP, false);
                    //6
            iAtrasP = new File("src/Fondos/i31.jpg");
            iFrenteP = new File("src/Fondos/i32.jpg");
            iDerechaP = new File("src/Fondos/i33.jpg");
            iIzquierdaP = new File("src/Fondos/i34.jpg");
            iTechoP = new File("src/Fondos/i36.jpg");
            iPisoP = new File("src/Fondos/i35.jpg");
                    tAtrasP6 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP6 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP6 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP6 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP6 = TextureIO.newTexture(iTechoP, false);
                    tPisoP6 = TextureIO.newTexture(iPisoP, false);
                    //7 
            iAtrasP = new File("src/Fondos/i37.jpg");
            iFrenteP = new File("src/Fondos/i38.jpg");
            iDerechaP = new File("src/Fondos/i39.jpg");
            iIzquierdaP = new File("src/Fondos/i40.jpg");
            iTechoP = new File("src/Fondos/i41.jpg");
            iPisoP = new File("src/Fondos/i42.jpg");
                    tAtrasP7 = TextureIO.newTexture(iAtrasP, false);
                    tFrenteP7 = TextureIO.newTexture(iFrenteP, false);
                    tDerechaP7 = TextureIO.newTexture(iDerechaP, false);
                    TIzquierdaP7 = TextureIO.newTexture(iIzquierdaP, false);
                    tTechoP7 = TextureIO.newTexture(iTechoP, false);
                    tPisoP7 = TextureIO.newTexture(iPisoP, false);
                    
        } catch (IOException iOE) {
            System.out.println("Error en carga de imágen");
        }
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        //drawable.addMouseWheelListener(this);
        drawable.addKeyListener(this);

//        drawable.addMouseListener(this);
//        drawable.addMouseMotionListener(this);
//        drawable.addKeyListener(this);
//        drawable.addMouseWheelListener(this);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
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

    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f, 0.0f, zoom,// eye 4.0f
                0.0f, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );

        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

        //we draw Stan in the window
        Cuphead cuphead = new Cuphead();
        KingDice kingdice = new KingDice();
        DrawPingu pingu = new DrawPingu();
        if (per==1)
        {
        cuphead.draw_cuphead(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F'], false);    
        }else if (per==2)
        {
        kingdice.draw_KingDice(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], false);
        }else if (per==3)
        {
         pingu.draw_pingu(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], false, false, false, false, false, false, false,false);
        }
        // Flush all drawing operations to the graphics card
        gl.glFlush();
        float mat_ambient[] = {0.9f, 0.9f, 0.9f, 1.0f};
        float mat_diffuse[] = {0.3f, 0.3f, 0.3f, 1.0f};
        float mat_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f, 1.5f, 1.0f, 0.0f};
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
switch(per)
{
    case 1:
        switch(selec)
        {
            case 1:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha1);
        gl.glPopMatrix();
        gl.glFlush();
        selec=2;
                break;
            case 2:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha2);
        gl.glPopMatrix();
        gl.glFlush();
        selec=3;
                break;
            case 3:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha3);
        gl.glPopMatrix();
        gl.glFlush();
        selec=4;
                break;
            case 4:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha4);
        gl.glPopMatrix();
        gl.glFlush();
        selec=5;
                break;
            case 5:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha5);
        gl.glPopMatrix();
        gl.glFlush();
        selec=6;
                break;
            case 6:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha6);
        gl.glPopMatrix();
        gl.glFlush();
        selec=7;
                break;
            case 7:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha7);
        gl.glPopMatrix();
        gl.glFlush();
        selec=1;
                break;                  
        }
        break;
    case 2:
        switch(selec)
        {
            case 1:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK1);
        gl.glPopMatrix();
        gl.glFlush();
            selec=2;
                break;
            case 2:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK2);
        gl.glPopMatrix();
        gl.glFlush();
        selec=3;
                break;
            case 3:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK3);
        gl.glPopMatrix();
        gl.glFlush();
        selec=4;
                break;
            case 4:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK4);
        gl.glPopMatrix();
        gl.glFlush();
        selec=5;
                break;
            case 5:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK5);
        gl.glPopMatrix();
        gl.glFlush();
        selec=6;
                break;
            case 6:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK6);
        gl.glPopMatrix();
        gl.glFlush();
        selec=7;
                break;
            case 7:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasK7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteK7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoK7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoK7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaK7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaK7);
        gl.glPopMatrix();
        gl.glFlush();
        selec=1;
                break; 
        }
        break;
    case 3:
        switch(selec)
        {
            case 1:
            gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP1);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP1);
        gl.glPopMatrix();
        gl.glFlush(); 
                selec=2;
                break;
            case 2:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP2);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP2);
        gl.glPopMatrix();
        gl.glFlush();
        selec=3;
                break;
            case 3:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP3);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP3);
        gl.glPopMatrix();
        gl.glFlush();
        selec=4;
                break;
            case 4:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP4);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP4);
        gl.glPopMatrix();
        gl.glFlush();
        selec=5;
                break;
            case 5:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP5);
        gl.glPopMatrix();
        gl.glFlush();
        selec=6;
                break;
            case 6:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP6);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP6);
        gl.glPopMatrix();
        gl.glFlush();
        selec=7;
                break;
            case 7:
                gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtrasP7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrenteP7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPisoP7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTechoP7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierdaP7);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerechaP7);
        gl.glPopMatrix();
        gl.glFlush();
        selec=1;
                break;
        }        
        break;
    default:
        gl.glPushMatrix();
        cuphead.fondo(gl, glu, tAtras5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tFrente5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tPiso5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 1.0f, 0.0f, 0.0f);
        cuphead.fondo(gl, glu, tTecho5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, TIzquierda5);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glRotatef(-90f, 0.0f, 1.0f, 0.0f);
        cuphead.fondo(gl, glu, tDerecha5);
        gl.glPopMatrix();
        gl.glFlush();
        break;
}
       
    }
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
    public void mouseWheelMoved(MouseWheelEvent e) {
        int gira = e.getWheelRotation();
        if (gira < 0) {
            zoom -= 0.1;
        } else {
            zoom += 0.1;
        }
    }
    public void mousePressed(MouseEvent e) {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 250 && keys[e.getKeyCode()] == false) {
            keys['W'] = false;
            keys['J'] = false;
            keys['A'] = false;
            keys['D'] = false;
            keys['S'] = false;
            keys[e.getKeyCode()] = true;

            switch (e.getKeyCode()) {
                case 'W':
                    reproducir(caminar);
                    break;
                case 'J':
                    reproducir(saltar);
                    break;
                case 'A':
                    reproducir(grunir);
                    break;
                 case 'D':
                    break;
                case 'S':
                    break;

            }
        } else {
            keys[e.getKeyCode()] = false;
        }
    }

    public void reproducir(String efecto) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(efecto)));
            clip.start();
        } catch (Exception e) {
            System.out.println("Error de carga de sonido");
        }
    }
      public static void botonVerActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        // TODO add your handling code here:
        sel=jComboBox1.getSelectedIndex();
        System.out.println("sleccion "+sel);
        if (sel==0)
        {
            per=1;
        }else if (sel==1)
        {
            per=2;
        }else if (sel==2)
        {
            per=3;
        }
        
    }                                                   
      public static void botonVerInsActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Usa las teclas para jugar");
        
    }                                                   
      public static void botonPlayActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        // TODO add your handling code here:   
    }                                                   
         private static void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        // TODO add your handling code here:
    }      
}
