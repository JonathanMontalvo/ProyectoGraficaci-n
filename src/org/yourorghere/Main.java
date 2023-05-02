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
import java.awt.Dimension;
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
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main implements GLEventListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener
{

    private static JFrame frame = null;

    private static float view_rotx = 0.01f;
    private static float view_roty = 0.01f;
    private static int oldMouseX;
    private static int oldMouseY;
    private static boolean[] keys = new boolean[256]; //to know which key is pressed

    //position of stan in the window
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;

    //Camera movements  
    private static double zoom = 10.0;
    private static double abajoYarriba = 0.0;
    private static double izquierdaYderecha = 0.0;

    //sound
    private static Clip clip;
    private static final String normal = "src/Sonidos/normal.wav";
    private static final String caminar = "src/Sonidos/caminar.wav";
    private static final String saltar = "src/Sonidos/saltar.wav";
    private static final String agacharse = "src/Sonidos/agacharse.wav";
    private static final String apuntar = "src/Sonidos/knockout.wav";
    private static final String bailar = "src/Sonidos/bailar.wav";
    private static final String cintura = "src/Sonidos/cintura.wav";
    private static final String cara = "src/Sonidos/cara.wav";
    private static final String notnot = "src/Sonidos/Pingu Sound - Noot Noot.wav";
    private static final String saltar2 = "src/Sonidos/Penguin - Sound Effect _ ProSounds.wav";
    private static final String enojado = "src/Sonidos/Tom Screaming Sound Effect (From Tom and Jerry).wav";
    private static final String guniar = "src/Sonidos/Bonitos y Gorditos.wav";
    private static final String mrs = "src/Sonidos/mrbeast sound effect.wav";
    private static final String mimido = "src/Sonidos/Pinche gato zzz.wav";
    private static final String rola = "src/Sonidos/SE.wav";
    private static final String rola2 = "src/Sonidos/SE.wav";

    //Game
    private static final Juego juego = new Juego();

    //Clase del men�
    private static final Menu menu = new Menu();

    //Banderas para men� y juegos
    private static boolean menuActivo = true;
    private static boolean nivelUno = false;
    private static boolean nivelDos = false;
    private static boolean nivelTres = false;

    public static int bnd = 1;
    private static int bndKey = 0;

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

        //Establecemos que texturas va a cargar
        if (menuActivo) {
            menu.texturasInit();
        } else if (nivelUno) {
            juego.texturasInit();
        }

        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addMouseWheelListener(this);
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

        if (menuActivo) {
            glu.gluPerspective(75.0f, h, 1.0, 20.0);
        } else if (nivelUno) {
            glu.gluPerspective(45.0f, h, 1.0, 20.0);
        }

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
        if (menuActivo) {
            menu.diplayTextura(gl, glu, X_POSITION, Y_POSITION, Z_POSITION, view_rotx, view_roty, zoom, bndKey, bnd, keys);
        } else if (nivelUno) {
            //System.out.println(": " + keys[32]);
            juego.displayJuego(gl, glu, zoom, abajoYarriba, izquierdaYderecha, X_POSITION, Y_POSITION, Z_POSITION, view_rotx, view_roty, keys);
        }
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

    public static void jMIOriginalMouseClicked(ActionEvent e)
    {
        bndKey = 3;
    }

    public static void jMITraslacionMouseClicked(ActionEvent e)
    {
        bndKey = 2;
    }

    public static void jMIEscalacionAumentarMouseClicked(ActionEvent e)
    {
        bndKey = 1;
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
        if (menuActivo) {
            int gira = e.getWheelRotation();
            if (gira < 0) {
                zoom -= 0.1;
            } else {
                zoom += 0.1;
            }
        }
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
        if (menuActivo) {
            int x = e.getX();
            int y = e.getY();
            Dimension size = e.getComponent().getSize();
            float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
            float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
            oldMouseX = x;
            oldMouseY = y;
            view_rotx += thetaX;
            view_roty += thetaY;
            //System.out.println("vX" + view_rotx);
            //System.out.println("vY" + view_roty);
        }
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
            keys['P'] = false;
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
            keys['U']=false;
            keys['I']=false;
            keys['O']=false;
            keys[17] = false;
            keys[e.getKeyCode()] = true;
            //System.out.println("" + e.getKeyCode() + ": " + keys[e.getKeyCode()]);
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
            if (menuActivo) {
                keys[e.getKeyCode()] = false;
            }
        }
        switch (e.getKeyCode()) {
            case '1':
                bnd = 1;
                break;
            case '2':
                bnd = 2;
                break;
            case '3':
                bnd = 3;
                break;
            case '4':
                bnd = 4;
                break;
            case '5':
                bnd = 5;
                break;
            case '6':
                bnd = 6;
                break;
            case '7':
                bnd = 7;
                break;
            case 'Z':
                bndKey = 1;
                break;
            case 'X':
                bndKey = 2;
                break;
            case 'C':
                bndKey = 3;
                break;
            case 'P':
                if (!nivelUno) {
                    if (bndKey == 1 || bndKey == 2 || bndKey == 3) {
                        inicioNivel1();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un personaje primero",
                                "Selecci�n de personaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;
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
            JOptionPane.showMessageDialog(null, "Desarrollado por: \nHernandez Vazquez Bryan."
                    + "\nMontalvo Perez Jonathan."
                    + "\nSalinas Diaz Jose Guillermo.",
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

    public static void jMISonidoEncendidoMouseClicked(ActionEvent e)
    {
        parar();
        reproducir(agacharse);
    }

    public static void jMISonidoApagadoMouseClicked(ActionEvent e)
    {
        parar();
    }

    public static void parar()
    {
        try {
            clip.stop();
        } catch (NullPointerException nPE) {
        }
    }

    public static void reproducir(String efecto)
    {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(efecto)));
            clip.start();
        } catch (Exception e) {
            System.out.println("Error de carga sonido");
        }
    }

    public static void acercaMouseClicked(MouseEvent e)
    {
        JOptionPane.showMessageDialog(null, "Desarrollado por: \nHernandez Vazquez Bryan."
                + "\nMontalvo Perez Jonathan."
                + "\nSalinas Diaz Jose Guillermo.",
                "Desarrollador", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void jMInstruccionesMouseClicked(MouseEvent e)
    {
        JOptionPane.showMessageDialog(null, "Presiona \"W\" para caminar.\n"
                + "Presiona la \" Barra de Espacio\" para saltar.\n"
                + "Presiona \"C\" para agacharse.\n"
                + "Presiona \"E\" para apuntar.\n"
                + "Presiona \"B\" para bailar.\n"
                + "Presiona \"Q\" para poner las manos en la cintura.\n"
                + "Presiona \"F\" para poner la mano en la cara.\n"
                + "\nPresiona del \"1-7\" para cambiar de escenario\n"
                + "\nPresiona \"N\" para dejar la camara normal.\n"
                + "Presiona \"I\" para hacer zoom in.\n"
                + "Presiona \"O\" para hacer zoom out.\n"
                + "Presiona \"Flecha Arriba\" para mover la camara a arriba.\n"
                + "Presiona \"Flecha Abajo\" para mover la camara a abajo.\n"
                + "Presiona \"Flecha Izquierda\" para mover la camara a la izquierda.\n"
                + "Presiona \"Flecha Derecha\" para mover la camara a la derecha.\n"
                + "Para acercar o alejar la camara usa la RUEDITA del raton.",
                "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }

    //We can chage the key value
    public static void cambiarEspacio(boolean estado)
    {
        keys[' '] = estado;
    }

    private static void desactivarTeclas()
    {
        keys['P'] = false;
        keys['W'] = false;
        keys[' '] = false;
        keys['C'] = false;
        keys['E'] = false;
        keys['B'] = false;
        keys['Q'] = false;
        keys['F'] = false;
    }

    public static void inicioNivel1()
    {
        menuActivo = false;
        nivelUno = true;
        frame.dispose();
        menu.quitarParteMain(frame);
        frame.setVisible(true);
        desactivarTeclas();
    }

    public static void regresoMenu()
    {
        menuActivo = true;
        nivelUno = false;
        nivelDos = false;
        nivelTres = false;
        frame.dispose();
        menu.cargarMenu(frame);
        frame.setVisible(true);
        desactivarTeclas();
    }

    public static void main(String[] args)
    {
        frame = new JFrame("Menu");
        menu.parteMain(frame);
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
}
