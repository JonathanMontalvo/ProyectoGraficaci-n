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
    private static final String menu_musica = "src/Sonidos/1.wav";
    private static final String cuphead_musica = "src/Sonidos/cuphead.wav";
    private static final String kingdice_musica = "src/Sonidos/king.wav";
    private static final String pingu_musica = "src/Sonidos/pin.wav";
    private static final String pregunta_musica = "src/Sonidos/pregunta.wav";
    private static final String victoria_musica = "src/Sonidos/victoria.wav";

    //Game
    private static final Juego juego = new Juego();

    //Clase del menú
    private static final Menu menu = new Menu();

    //Banderas para menú y juegos
    private static boolean menuActivo = true;
    private static boolean juegoActivo = false;

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
        } else if (juegoActivo) {
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
            parar();
            reproducir(menu_musica);
        } else if (juegoActivo) {
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
        } else if (juegoActivo) {
            //System.out.println(": " + keys[32]);
            juego.displayJuego(gl, glu, zoom, abajoYarriba, izquierdaYderecha, X_POSITION, Y_POSITION, Z_POSITION, view_rotx, view_roty, bndKey, keys);
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
            keys['U'] = false;
            keys['I'] = false;
            keys['O'] = false;
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
                if (!juegoActivo) {
                    bndKey = 1;
                }
                break;
            case 'X':
                if (!juegoActivo) {
                    bndKey = 2;
                }
                break;
            case 'C':
                if (!juegoActivo) {
                    bndKey = 3;
                }
                break;
            case 'P':
                if (!juegoActivo) {
                    if (bndKey == 1 || bndKey == 2 || bndKey == 3) {
                        inicioNiveles();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un personaje primero",
                                "Selección de personaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;
        }
        if (e.getKeyChar() == 'H' || e.getKeyChar() == 'h') {
            JOptionPane.showMessageDialog(null, "Presiona la \" Barra de Espacio\" para saltar.\n"
                    + "Presiona \"Ctrl\" para agacharse.\n"
                    + "Presiona \"U\" para elegir una respuesta.\n"
                    + "Presiona \"I\" para elegir una respuesta.\n"
                    + "Presiona \"O\" para elegir una respuestan"
                    + "Presiona \"C\" para elegir el nivel 1.\n"
                    + "Presiona \"X\" para elegir el nivel 2.\n"
                    + "Presiona \"Z\" para elegir el nivel 3.\n"
                    + "Presiona \"P\" para iniciar a jugar.\n",
                    "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
            JOptionPane.showMessageDialog(null, "Desarrollado por: \nHernandez Vazquez Bryan."
                    + "\nMontalvo Perez Jonathan."
                    + "\nSalinas Diaz Jose Guillermo.",
                    "Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void jMISonidoEncendidoMouseClicked(ActionEvent e)
    {
        parar();
        reproducir(menu_musica);
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
        JOptionPane.showMessageDialog(null, "Presiona la \" Barra de Espacio\" para saltar.\n"
                + "Presiona \"Ctrl\" para agacharse.\n"
                + "Presiona \"U\" para elegir una respuesta.\n"
                + "Presiona \"I\" para elegir una respuesta.\n"
                + "Presiona \"O\" para elegir una respuestan"
                + "Presiona \"C\" para elegir el nivel 1.\n"
                + "Presiona \"X\" para elegir el nivel 2.\n"
                + "Presiona \"Z\" para elegir el nivel 3.\n"
                + "Presiona \"P\" para iniciar a jugar.\n",
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
        keys['U'] = false;
        keys['I'] = false;
        keys['O'] = false;
        keys[17] = false;
    }

    public static void inicioNiveles()
    {
        menuActivo = false;
        juegoActivo = true;
        frame.dispose();
        menu.quitarParteMain(frame, bndKey);
        frame.setVisible(true);
        desactivarTeclas();
        parar();
        switch (bndKey) {
            case 1:
                reproducir(pingu_musica);
                break;
            case 2:
                reproducir(kingdice_musica);
                break;
            case 3:
                reproducir(cuphead_musica);
                break;
        }
    }

    public static void regresoMenu()
    {
        parar();
        menuActivo = true;
        juegoActivo = false;
        frame.dispose();
        juego.reiniciarJuego();
        menu.cargarMenu(frame);
        frame.setVisible(true);
        desactivarTeclas();
    }

    public static void reiniciar()
    {
        menuActivo = false;
        juegoActivo = true;
        frame.dispose();
        menu.quitarParteMain(frame, bndKey);
        juego.reiniciarJuego();
        frame.setVisible(true);
        desactivarTeclas();
        parar();
        switch (bndKey) {
            case 1:
                reproducir(pingu_musica);
                break;
            case 2:
                reproducir(kingdice_musica);
                break;
            case 3:
                reproducir(cuphead_musica);
                break;
        }
    }

    public static int nivelActual()
    {
        return Main.bndKey;
    }

    public static void pasoNivel2()
    {
        Main.bndKey = 2;
    }

    public static void pasoNivel3()
    {
        Main.bndKey = 1;
    }
    
    public static void musVic(){
        parar();
        reproducir(victoria_musica);
    }
    
    public static void musPregu(){
        parar();
        reproducir(pregunta_musica);
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
