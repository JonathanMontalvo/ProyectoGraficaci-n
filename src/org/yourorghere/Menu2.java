package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.swing.JLabel;

/**
 * KingDice.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Menu2 implements GLEventListener, MouseListener, MouseWheelListener, MouseMotionListener, KeyListener {

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256];
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;
    private static int bndKey=0;
    private double zoom = 10;
    public static int bnd = 1;
    public static int bnds = -1;
    public static Clip clipfondo;
    //Sonidos
    static String normal = "src/Sonidos/normal.wav";
    static String caminar = "src/Sonidos/caminar.wav";
    static String saltar = "src/Sonidos/saltar.wav";
    static String agacharse = "src/Sonidos/agacharse.wav";
    static String apuntar = "src/Sonidos/knockout.wav";
    static String bailar = "src/Sonidos/bailar.wav";
    static String cintura = "src/Sonidos/cintura.wav";
    static String cara = "src/Sonidos/cara.wav";
    static String notnot = "src/Sonidos/Pingu Sound - Noot Noot.wav";
    static String saltar2 = "src/Sonidos/Penguin - Sound Effect _ ProSounds.wav";
    static String enojado= "src/Sonidos/Tom Screaming Sound Effect (From Tom and Jerry).wav";
    static String guniar = "src/Sonidos/Bonitos y Gorditos.wav";
    static String mrs = "src/Sonidos/mrbeast sound effect.wav";
    static String mimido = "src/Sonidos/Pinche gato zzz.wav";
    static String rola = "src/Sonidos/SE.wav";
    static String rola2 = "src/Sonidos/SE.wav";

    private static final JMenuBar jMenuBar = new JMenuBar();

    private static final JMenu jMInstucciones = new JMenu();
    private static final JMenu jMTransformaciones = new JMenu();
    private static final JMenu jMSonido = new JMenu();
    private static final JMenu jMAcerca = new JMenu();
    private static final JMenuItem jMISonidoEncendido = new JMenuItem();
    private static final JMenuItem jMISonidoApagado = new JMenuItem();

    private static final JMenuItem jMIOriginal = new JMenuItem();
    private static final JMenuItem jMITraslacion = new JMenuItem();
    private static final JMenuItem jMIEscalacionAumentar = new JMenuItem();
    private static final JMenuItem jMIEscalacionDisminuir = new JMenuItem();
    private static final JMenuItem jMIEscalacionPuntoFijo = new JMenuItem();
    private static final JMenuItem jMIRotacionIzquierda = new JMenuItem();
    private static final JMenuItem jMIRotacionDerecha = new JMenuItem();
    private static final JMenuItem jMIRotacionPuntoFijo = new JMenuItem();
    private static final JMenuItem jMICorteHorizontal = new JMenuItem();
    private static final JMenuItem jMICorteVertical = new JMenuItem();
    private static final JMenuItem jMIReflexionEnX = new JMenuItem();
    private static final JMenuItem jMIReflexionEnY = new JMenuItem();
    private static final JMenuItem jMIReflexionEnElOrigen = new JMenuItem();
    private static final JMenuItem jMIReflexionSobreLaRecta = new JMenuItem();
    private static final JMenuItem jMImov6 = new JMenuItem();
    private static final JMenuItem jMImov7 = new JMenuItem();

    private static final JLabel selecciona = new JLabel();

    Texture tAtras, tFrente, tDerecha, TIzquierda, tTecho, tPiso, tAtras2, tFrente2, tDerecha2, TIzquierda2, tTecho2, tPiso2,
            tAtras3, tFrente3, tDerecha3, TIzquierda3, tTecho3, tPiso3, tAtras4, tFrente4, tDerecha4, TIzquierda4, tTecho4, tPiso4,
            tAtras7, tFrente7, tDerecha7, TIzquierda7, tTecho7, tPiso7, tAtras5, tFrente5, tDerecha5, TIzquierda5, tTecho5, tPiso5,
            tAtras6, tFrente6, tDerecha6, TIzquierda6, tTecho6, tPiso6,tTeclaX,tTeclaZ,tTeclaC,
            tAtrasP1,tFrenteP1,tDerechaP1,TIzquierdaP1,tTechoP1,tPisoP1,tAtrasP2,tFrenteP2,tDerechaP2,TIzquierdaP2,tTechoP2,tPisoP2,
            tAtrasP3,tFrenteP3,tDerechaP3,TIzquierdaP3,tTechoP3,tPisoP3,tAtrasP4,tFrenteP4,tDerechaP4,TIzquierdaP4,tTechoP4,tPisoP4,
            tAtrasP5,tFrenteP5,tDerechaP5,TIzquierdaP5,tTechoP5,tPisoP5,tAtrasP6,tFrenteP6,tDerechaP6,TIzquierdaP6,tTechoP6,tPisoP6,
            tAtrasP7,tFrenteP7,tDerechaP7,TIzquierdaP7,tTechoP7,tPisoP7,tAtrasK1,tFrenteK1,tDerechaK1,TIzquierdaK1,tTechoK1,tPisoK1,tAtrasK2,tFrenteK2,tDerechaK2,TIzquierdaK2,tTechoK2,tPisoK2,
            tAtrasK3,tFrenteK3,tDerechaK3,TIzquierdaK3,tTechoK3,tPisoK3,tAtrasK4,tFrenteK4,tDerechaK4,TIzquierdaK4,tTechoK4,tPisoK4,
            tAtrasK5,tFrenteK5,tDerechaK5,TIzquierdaK5,tTechoK5,tPisoK5,tAtrasK6,tFrenteK6,tDerechaK6,TIzquierdaK6,tTechoK6,tPisoK6,
            tAtrasK7,tFrenteK7,tDerechaK7,TIzquierdaK7,tTechoK7,tPisoK7;
    static final GLCanvas canvas = new GLCanvas();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu ");
//        JOptionPane.showMessageDialog(null, "King Dice: Presiona el boton de INSTRUCCIONES para comezar\n ",
//                "Holi", JOptionPane.INFORMATION_MESSAGE);

        jMInstucciones.setText("Instrucciones");
        jMenuBar.add(jMInstucciones);
        jMTransformaciones.setText("Selecciona el personaje");
        jMenuBar.add(jMTransformaciones);
        jMIOriginal.setText("Cuphead -> Presiona C");
        //jMIOriginal.setEnabled(false);
        jMTransformaciones.add(jMIOriginal);
        jMITraslacion.setText("King Dice -> Presiona X");
        //jMITraslacion.setEnabled(false);
        jMTransformaciones.add(jMITraslacion);
        jMIEscalacionAumentar.setText("Pingu -> Presiona Z");
        //jMIEscalacionAumentar.setEnabled(false);
        jMTransformaciones.add(jMIEscalacionAumentar);

        jMSonido.setText("Audio");
        jMenuBar.add(jMSonido);
        jMISonidoEncendido.setText("Iniciar");
        jMSonido.add(jMISonidoEncendido);
        jMISonidoApagado.setText("Detener");
        jMSonido.add(jMISonidoApagado);

        jMAcerca.setText("Acerca de");
        jMenuBar.add(jMAcerca);

        selecciona.setText("Selecciona un personaje");

        jMIOriginal.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMIOriginalMouseClicked(aE);
            }
        });
        jMITraslacion.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMITraslacionMouseClicked(aE);
            }
        });
        jMIEscalacionDisminuir.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMIEscalacionDisminuirMouseClicked(aE);
            }
        });
        jMIEscalacionAumentar.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMIEscalacionAumentarMouseClicked(aE);
            }
        });
        jMIEscalacionPuntoFijo.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMIEscalacionPuntoFijoMouseClicked(aE);
            }
        });
        jMImov6.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMImov6MouseClicked(aE);
            }
        });
        jMImov7.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMImov7MouseClicked(aE);
            }
        });

        jMISonidoEncendido.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMISonidoEncendidoMouseClicked(aE);
            }
        });

        jMISonidoApagado.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aE) {
                jMISonidoApagadoMouseClicked(aE);
            }
        });

        jMAcerca.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                acercaMouseClicked(e);
            }
        });

        jMInstucciones.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                jMInstruccionesMouseClicked(e);
            }
        });

//        GLCanvas canvas = new GLCanvas();
        frame.setJMenuBar(jMenuBar);
        canvas.addGLEventListener(new Menu2());
        frame.add(canvas);
        frame.setSize(900, 750);
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
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("King Dice" + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        //Agrega
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
        gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f); //Fondo
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.

//Agregando los Listeners
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
        drawable.addMouseListener(this);
        drawable.addMouseWheelListener(this);

        try {
            File iAtras = new File("src/Fondos/f1.jpg");
            tAtras = TextureIO.newTexture(iAtras, true);
            File iFrente = new File("src/Fondos/f1.jpg");
            tFrente = TextureIO.newTexture(iFrente, true);
            File iDerecha = new File("src/Fondos/f1.jpg");
            tDerecha = TextureIO.newTexture(iDerecha, true);
            File iIzquierda = new File("src/Fondos/f1.jpg");
            TIzquierda = TextureIO.newTexture(iIzquierda, true);
            File iTecho = new File("src/Fondos/r3.jpg");
            tTecho = TextureIO.newTexture(iTecho, true);
            File iPiso = new File("src/Fondos/p.jpg");
            tPiso = TextureIO.newTexture(iPiso, true);
            File iAtras2 = new File("src/Fondos/f2.jpg");
            tAtras2 = TextureIO.newTexture(iAtras2, true);
            File iFrente2 = new File("src/Fondos/f2.jpg");
            tFrente2 = TextureIO.newTexture(iFrente2, true);
            File iDerecha2 = new File("src/Fondos/f2.jpg");
            tDerecha2 = TextureIO.newTexture(iDerecha2, true);
            File iIzquierda2 = new File("src/Fondos/f2.jpg");
            TIzquierda2 = TextureIO.newTexture(iIzquierda2, true);
            File iTecho2 = new File("src/Fondos/r3.jpg");
            tTecho2 = TextureIO.newTexture(iTecho2, true);
            File iPiso2 = new File("src/Fondos/p.jpg");
            tPiso2 = TextureIO.newTexture(iPiso2, true);
            File iAtras3 = new File("src/Fondos/f3.jpg");
            tAtras3 = TextureIO.newTexture(iAtras3, true);
            File iFrente3 = new File("src/Fondos/f3.jpg");
            tFrente3 = TextureIO.newTexture(iFrente3, true);
            File iDerecha3 = new File("src/Fondos/f3.jpg");
            tDerecha3 = TextureIO.newTexture(iDerecha3, true);
            File iIzquierda3 = new File("src/Fondos/f3.jpg");
            TIzquierda3 = TextureIO.newTexture(iIzquierda3, true);
            File iTecho3 = new File("src/Fondos/r3.jpg");
            tTecho3 = TextureIO.newTexture(iTecho3, true);
            File iPiso3 = new File("src/Fondos/p.jpg");
            tPiso3 = TextureIO.newTexture(iPiso3, true);
            File iAtras4 = new File("src/Fondos/e.jpg");
            tAtras4 = TextureIO.newTexture(iAtras4, true);
            File iFrente4 = new File("src/Fondos/e.jpg");
            tFrente4 = TextureIO.newTexture(iFrente4, true);
            File iDerecha4 = new File("src/Fondos/e.jpg");
            tDerecha4 = TextureIO.newTexture(iDerecha4, true);
            File iIzquierda4 = new File("src/Fondos/e.jpg");
            TIzquierda4 = TextureIO.newTexture(iIzquierda4, true);
            File iTecho4 = new File("src/Fondos/r3.jpg");
            tTecho4 = TextureIO.newTexture(iTecho4, true);
            File iPiso4 = new File("src/Fondos/p.jpg");
            tPiso4 = TextureIO.newTexture(iPiso4, true);
            File iAtras5 = new File("src/Fondos/f4.jpg");
            tAtras5 = TextureIO.newTexture(iAtras5, true);
            File iFrente5 = new File("src/Fondos/f4.jpg");
            tFrente5 = TextureIO.newTexture(iFrente5, true);
            File iDerecha5 = new File("src/Fondos/f4.jpg");
            tDerecha5 = TextureIO.newTexture(iDerecha5, true);
            File iIzquierda5 = new File("src/Fondos/f4.jpg");
            TIzquierda5 = TextureIO.newTexture(iIzquierda5, true);
            File iTecho5 = new File("src/Fondos/r3.jpg");
            tTecho5 = TextureIO.newTexture(iTecho, true);
            File iPiso5 = new File("src/Fondos/p.jpg");
            tPiso5 = TextureIO.newTexture(iPiso, true);
            File iAtras6 = new File("src/Fondos/f5.jpg");
            tAtras6 = TextureIO.newTexture(iAtras6, true);
            File iFrente6 = new File("src/Fondos/f5.jpg");
            tFrente6 = TextureIO.newTexture(iFrente6, true);
            File iDerecha6 = new File("src/Fondos/f5.jpg");
            tDerecha6 = TextureIO.newTexture(iDerecha6, true);
            File iIzquierda6 = new File("src/Fondos/f5.jpg");
            TIzquierda6 = TextureIO.newTexture(iIzquierda6, true);
            File iTecho6 = new File("src/Fondos/r3.jpg");
            tTecho6 = TextureIO.newTexture(iTecho6, true);
            File iPiso6 = new File("src/Fondos/p.jpg");
            tPiso6 = TextureIO.newTexture(iPiso6, true);
            File iAtras7 = new File("src/Fondos/c.jpg");
            tAtras7 = TextureIO.newTexture(iAtras7, true);
            File iFrente7 = new File("src/Fondos/c.jpg");
            tFrente7 = TextureIO.newTexture(iFrente7, true);
            File iDerecha7 = new File("src/Fondos/c.jpg");
            tDerecha7 = TextureIO.newTexture(iDerecha7, true);
            File iIzquierda7 = new File("src/Fondos/c.jpg");
            TIzquierda7 = TextureIO.newTexture(iIzquierda7, true);
            File iTecho7 = new File("src/Fondos/r3.jpg");
            tTecho7 = TextureIO.newTexture(iTecho7, true);
            File iPiso7 = new File("src/Fondos/p.jpg");
            tPiso7 = TextureIO.newTexture(iPiso7, true);
            //Pingu
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
                    //Cuphead
                    //Escenario 1
            File iAtrasC = new File("src/Fondos/casa.jpg");
            tAtrasK1 = TextureIO.newTexture(iAtrasC, true);
            File iFrenteC = new File("src/Fondos/feria.jpg");
            tFrenteK1 = TextureIO.newTexture(iFrenteC, true);
            File iDerechaC = new File("src/Fondos/bosque.jpg");
            tDerechaK1 = TextureIO.newTexture(iDerechaC, true);
            File iIzquierdaC = new File("src/Fondos/bosque.jpg");
            TIzquierdaK1 = TextureIO.newTexture(iIzquierdaC, true);
            File iTechoC = new File("src/Fondos/cielo.jpg");
            tTechoK1 = TextureIO.newTexture(iTechoC, true);
            File iPisoC = new File("src/Fondos/suelo.jpg");
            tPisoK1 = TextureIO.newTexture(iPisoC, true);
            //Escenario2
            iAtrasC = new File("src/Fondos/minecraftLado.jpg");
            tAtrasK2 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/minecraftFrente.jpg");
            tFrenteK2 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/minecraftLado.jpg");
            tDerechaK2 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/minecraftLado.jpg");
            TIzquierdaK2 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/minecraftCielo.jpg");
            tTechoK2 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/minecraftSuelo.jpg");
            tPisoK2 = TextureIO.newTexture(iPisoC, true);
            //Escenario3
            iAtrasC = new File("src/Fondos/feriaLados.jpg");
            tAtrasK3 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/feriaFrente.jpg");
            tFrenteK3 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/feriaLados.jpg");
            tDerechaK3 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/feriaLados.jpg");
            TIzquierdaK3 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloNoche.jpg");
            tTechoK3 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/suelo.jpg");
            tPisoK3 = TextureIO.newTexture(iPisoC, true);
            //Escenario4
            iAtrasC = new File("src/Fondos/atraccion.jpg");
            tAtrasK4 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/atraccion.jpg");
            tFrenteK4 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/atraccion.jpg");
            tDerechaK4 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/atraccion.jpg");
            TIzquierdaK4 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tTechoK4 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tPisoK4 = TextureIO.newTexture(iPisoC, true);
            //Escenario5
            iAtrasC = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tAtrasK5 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tFrenteK5 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/ladoCiudad.jpg");
            tDerechaK5 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/ladoCiudad.jpg");
            TIzquierdaK5 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloCiudad.jpg");
            tTechoK5 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/sueloCiudad.jpg");
            tPisoK5 = TextureIO.newTexture(iPisoC, true);
            //Escenario6
            iAtrasC = new File("src/Fondos/atrasCarretera.jpg");
            tAtrasK6 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/frenteCarretera.jpg");
            tFrenteK6 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/ladoCarretera.jpg");
            tDerechaK6 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/ladoCarretera.jpg");
            TIzquierdaK6 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloCarretera.jpg");
            tTechoK6 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/sueloCarretera.jpg");
            tPisoK6 = TextureIO.newTexture(iPisoC, true);
            //Escenario7
            iAtrasC = new File("src/Fondos/desiertoAtras.jpg");
            tAtrasK7 = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/desiertoFrente.jpg");
            tFrenteK7 = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/desiertoLados.jpg");
            tDerechaK7 = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/desiertoLados.jpg");
            TIzquierdaK7 = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/desiertoCielo.jpg");
            tTechoK7 = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/desiertoSuelo.jpg");
            tPisoK7 = TextureIO.newTexture(iPisoC, true);
            //Teclas
            File iTeclaZ = new File("src/Fondos/keyboard_key_z.png");
            tTeclaZ = TextureIO.newTexture(iTeclaZ, true);
            File iTeclaX = new File("src/Fondos/X.jpg");
            tTeclaX = TextureIO.newTexture(iTeclaX, true);
            File iTeclaC= new File("src/Fondos/keyboard_key_c.png");
            tTeclaC = TextureIO.newTexture(iTeclaC, true);
            
        } catch (IOException iOE) {
            System.out.println("Error en carga de imágen");
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(-20, 0, width, height); //(horiz,subir el personaje)
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(70.0f, h, 1.0, 20.0);//(hacerlo mas pequeño)                
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

        glu.gluLookAt(0.1f, 0.0f, zoom,// eye (ver desde los pies, acostar der,zoom)
                0.0f, 0.0f, 0.0f, // looking at (de cabeza, acostar izq,)
                0.0f, 0.0f, 1.0f // is up (cabeza,acostar der)
        );

        // Move the whole scene Agrega
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

//Mostrar el FONDO
        //we draw Stan in the window
        KingDice kd = new KingDice();
        DrawPingu pingu = new DrawPingu();
        Cuphead cuphead = new Cuphead();
        switch (bndKey)
        {
            case 0:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 1:
                switch(bnd)
        {
            case 1:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP1);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 2:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP2);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 3:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP3);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 4:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP4);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 5:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP5);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 6:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP6);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 7:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaP7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaP7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoP7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoP7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasP7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteP7);
                gl.glPopMatrix();
                gl.glFlush();
                }
                break;
            case 2:
          switch (bnd) {
            case 1:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTecho);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 2:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha2);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda2);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho2);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso2);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras2);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente2);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 3:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha3);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda3);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho3);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso3);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras3);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente3);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 4:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha4);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda4);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho4);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso4);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras4);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente4);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 5:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha5);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda5);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho5);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso5);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras5);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente5);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 6:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha6);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda6);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho6);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso6);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras6);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente6);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 7:
                //Dibujamos la texturas del lado derecho
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerecha7);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del lado izquierdo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierda7);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del cielo
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTecho7);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas del piso
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPiso7);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la casa
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtras7);
                gl.glPopMatrix();
                gl.glFlush();
                //Dibujamos la texturas de la feria
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrente7);
                gl.glPopMatrix();
                gl.glFlush();
                break;
        }      
                break;
            case 3:
                        switch(bnd)
        {
            case 1:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK1);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK1);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 2:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK2);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK2);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 3:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK3);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK3);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 4:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK4);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK4);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 5:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK5);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK5);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 6:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK6);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK6);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 7:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tDerechaK7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, TIzquierdaK7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoK7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoK7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tAtrasK7);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tFrenteK7);
                gl.glPopMatrix();
                gl.glFlush();
                }
                break;
        }
        switch(bndKey)
        {
            case 0:
                //Dibujamos la texturas de los botones
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaX);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZ);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaC);
                gl.glPopMatrix();
                gl.glFlush();
        gl.glPushMatrix();
        gl.glTranslatef(-5f, 0f, 0f);
        pingu.draw_pingu(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
        gl.glPopMatrix();
        gl.glPushMatrix();        
        kd.draw_KingDice(gl, true, false, false, false, false, false, true);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(5f, 0f, 0f);     
        cuphead.draw_cuphead(gl, true, true, true, true, true, true, true, true);
        gl.glPopMatrix();
        // Flush all drawing operations to the graphics card
        gl.glFlush();
                break;
            case 1:
                gl.glPushMatrix();
        gl.glTranslatef(-5f, 0f, 0f);
        pingu.draw_pingu(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U']);
        pingu.set_white_head_material(gl);
        gl.glPopMatrix();
       gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaC);
                gl.glPopMatrix();
                gl.glFlush();;
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaX);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 2:
                gl.glPushMatrix();        
        kd.draw_KingDice(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J']);
        gl.glPopMatrix();
        gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaC);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZ);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 3:
                gl.glPushMatrix();
        gl.glTranslatef(5f, 0f, 0f);     
        cuphead.draw_cuphead(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q']);
        gl.glPopMatrix();
        gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaX);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f,0.1f,0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZ);
                gl.glPopMatrix();
                gl.glFlush();
                break;
                
               
        }
        
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }
//    GLU glu = new GLU();
//    GL gl = drawable.getGL();

    public static void jMIOriginalMouseClicked(ActionEvent e) {
        bnd = 1;
        bnds = 1;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMITraslacionMouseClicked(ActionEvent e) {
        bnd = 2;
        bnds = 2;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMIEscalacionAumentarMouseClicked(ActionEvent e) {
        bnd = 3;
        bnds = 3;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMIEscalacionDisminuirMouseClicked(ActionEvent e) {
        bnd = 4;
        bnds = 4;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMIEscalacionPuntoFijoMouseClicked(ActionEvent e) {
        bnd = 5;
        bnds = 5;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMImov6MouseClicked(ActionEvent e) {
        bnd = 6;
        bnds = 6;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMImov7MouseClicked(ActionEvent e) {
        bnd = 7;
        bnds = 7;
        sonidoFondo(bnds);
        //canvas.repaint();
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
            keys['A'] = false;
            keys['S'] = false;
            keys['D'] = false;
            keys['F'] = false;
            keys['G'] = false;
            keys['H'] = false;
            keys['J'] = false;
            keys['Q'] = false;
            keys['W'] = false;
            keys['E'] = false;
            keys['R'] = false;
            keys['T'] = false;
            keys['Y'] = false;
            keys['U'] = false;
            keys['Z'] = false;
            keys['X'] = false;
            keys['C'] = false;
            keys[e.getKeyCode()] = true;
            switch (e.getKeyCode()) {
                case 'A':
                    break;
                case 'S':
                    break;
                case 'D':
                    break;
                case 'F':
                    break;
                case 'G':
                    break;
                case 'H':
                    break;
                case 'J':
                    break;
                case 'Q':
                    bnd = 1;
                    bnds = 1;
                    sonidoFondo(bnds);
                    break;
                case 'W':
                    bnd = 2;
                    bnds = 2;
                    sonidoFondo(bnds);
                    break;
                case 'E':
                    bnd = 3;
                    bnds = 3;
                    sonidoFondo(bnds);
                    break;
                case 'R':
                    bnd = 4;
                    bnds = 4;
                    sonidoFondo(bnds);
                    break;
                case 'T':
                    bnd = 5;
                    bnds = 5;
                    sonidoFondo(bnds);
                    break;
                case 'Y':
                    bnd = 6;
                    bnds = 7;
                    sonidoFondo(bnds);
                    break;
                case 'U':
                    bnd = 7;
                    bnds = 8;
                    sonidoFondo(bnds);
                    break;
                    case 'Z':
                        bndKey=1;
                        break;
                    case 'X':
                        bndKey=2;
                        break;
                    case 'C':
                        bndKey=3;
                        break;
                        
                default:
                    JOptionPane.showMessageDialog(null, "PRESIONA una tecla valida =D\n puedes consultarlas en el menú, en INSTRUCCIONES ",
                            "UPSSS!", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } else {
            keys[e.getKeyCode()] = false;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int gira = e.getWheelRotation();
        if (gira < 0) {
            zoom -= 0.1;
        } else {
            zoom += 0.1;
        }
    }

    public static void jMISonidoEncendidoMouseClicked(ActionEvent e) {

        bnds = 0;
        sonidoFondo(bnds);

    }

    public static void jMISonidoApagadoMouseClicked(ActionEvent e) {
        clipfondo.stop();
        canvas.repaint();
    }

    public static void acercaMouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "Desarrollado por: \n José Guillermo Salinas Diaz"
                + " \n Jonathan Montalvo Perez \n Bryan Hernandez Vazquez", "Creadores", JOptionPane.INFORMATION_MESSAGE);
        canvas.repaint();
    }

    public static void jMInstruccionesMouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "Brincar -> Q\nLevantar la mano derecha -> W\n Pedir abracito ->E\nSentar -> R\n"
                + "Enojado -> T\nMuerto -> Y\n Brincar de felicidad ->U\n\n Para acercar o alejar la camara usa la RUEDITA del raton\n"
                + "Para mover la camara PRESIONA un boton del raton y muevelo\n                                  ¡D I V I E R T E T E! ",
                "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
        canvas.repaint();
    }

    public static synchronized void sonidoFondo(final int n) {
        switch (n) {
            case 0:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/Dm.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/1.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/2.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/13.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 4:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/12.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 5:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/5.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 6:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/6.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 7:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/11.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
            case 8:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("src/Sonido/10.wav");
                        try {
                            clipfondo = AudioSystem.getClip();
                            AudioInputStream inputstream = AudioSystem.getAudioInputStream(file);
                            clipfondo.open(inputstream);
                            clipfondo.start();
                        } catch (Exception C) {
                            System.out.println("Error al intentar reproducir");
                        }
                    }
                }) {
                }.start();
                clipfondo.stop();
                break;
        }
    }
}
