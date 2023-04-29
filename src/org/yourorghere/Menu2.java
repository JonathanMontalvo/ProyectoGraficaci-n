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
public class Menu2 implements GLEventListener, MouseListener, MouseWheelListener, MouseMotionListener, KeyListener
{

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256];
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;
    private static int bndKey = 0;
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
    static String enojado = "src/Sonidos/Tom Screaming Sound Effect (From Tom and Jerry).wav";
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

    private static final Menu menu = new Menu();

    private static boolean menuActivo = true;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Menu ");
        if (menuActivo) {
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
            jMIOriginal.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMIOriginalMouseClicked(aE);
                }
            });
            jMITraslacion.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMITraslacionMouseClicked(aE);
                }
            });
            jMIEscalacionDisminuir.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMIEscalacionDisminuirMouseClicked(aE);
                }
            });
            jMIEscalacionAumentar.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMIEscalacionAumentarMouseClicked(aE);
                }
            });
            jMIEscalacionPuntoFijo.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMIEscalacionPuntoFijoMouseClicked(aE);
                }
            });
            jMImov6.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMImov6MouseClicked(aE);
                }
            });
            jMImov7.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMImov7MouseClicked(aE);
                }
            });

            jMISonidoEncendido.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMISonidoEncendidoMouseClicked(aE);
                }
            });

            jMISonidoApagado.addActionListener(new java.awt.event.ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent aE)
                {
                    jMISonidoApagadoMouseClicked(aE);
                }
            });

            jMAcerca.addMouseListener(new java.awt.event.MouseAdapter()
            {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e)
                {
                    acercaMouseClicked(e);
                }
            });

            jMInstucciones.addMouseListener(new java.awt.event.MouseAdapter()
            {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e)
                {
                    jMInstruccionesMouseClicked(e);
                }
            });
            frame.setJMenuBar(jMenuBar);
        }
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Menu2());
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
        // Center frame
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

        //Agregando los Listeners
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
        drawable.addMouseListener(this);
        drawable.addMouseWheelListener(this);
        menu.texturasInit();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height); //(horiz,subir el personaje)
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(75.0f, h, 1.0, 20.0);//(hacerlo mas pequeño)                
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
        menu.diplayTextura(gl, glu, X_POSITION, Y_POSITION, Z_POSITION, view_rotx, view_roty, zoom, bndKey, bnd, keys);

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {

    }
//    GLU glu = new GLU();
//    GL gl = drawable.getGL();

    public static void jMIOriginalMouseClicked(ActionEvent e)
    {
        bnd = 1;
        bnds = 1;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMITraslacionMouseClicked(ActionEvent e)
    {
        bnd = 2;
        bnds = 2;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMIEscalacionAumentarMouseClicked(ActionEvent e)
    {
        bnd = 3;
        bnds = 3;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMIEscalacionDisminuirMouseClicked(ActionEvent e)
    {
        bnd = 4;
        bnds = 4;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMIEscalacionPuntoFijoMouseClicked(ActionEvent e)
    {
        bnd = 5;
        bnds = 5;
        sonidoFondo(bnds);
        // canvas.repaint();
    }

    public static void jMImov6MouseClicked(ActionEvent e)
    {
        bnd = 6;
        bnds = 6;
        sonidoFondo(bnds);
        //canvas.repaint();
    }

    public static void jMImov7MouseClicked(ActionEvent e)
    {
        bnd = 7;
        bnds = 7;
        sonidoFondo(bnds);
        //canvas.repaint();
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

    public void keyPressed(KeyEvent e)
    {
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
                    bndKey = 1;
                    break;
                case 'X':
                    bndKey = 2;
                    break;
                case 'C':
                    bndKey = 3;
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
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int gira = e.getWheelRotation();
        if (gira < 0) {
            zoom -= 0.1;
        } else {
            zoom += 0.1;
        }
    }

    public static void jMISonidoEncendidoMouseClicked(ActionEvent e)
    {

        bnds = 0;
        sonidoFondo(bnds);

    }

    public static void jMISonidoApagadoMouseClicked(ActionEvent e)
    {
        clipfondo.stop();

    }

    public static void acercaMouseClicked(MouseEvent e)
    {
        JOptionPane.showMessageDialog(null, "Desarrollado por: \n José Guillermo Salinas Diaz"
                + " \n Jonathan Montalvo Perez \n Bryan Hernandez Vazquez", "Creadores", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void jMInstruccionesMouseClicked(MouseEvent e)
    {
        JOptionPane.showMessageDialog(null, "Brincar -> Q\nLevantar la mano derecha -> W\n Pedir abracito ->E\nSentar -> R\n"
                + "Enojado -> T\nMuerto -> Y\n Brincar de felicidad ->U\n\n Para acercar o alejar la camara usa la RUEDITA del raton\n"
                + "Para mover la camara PRESIONA un boton del raton y muevelo\n                                  ¡D I V I E R T E T E! ",
                "Instrucciones", JOptionPane.INFORMATION_MESSAGE);

    }

    public static synchronized void sonidoFondo(final int n)
    {
        switch (n) {
            case 0:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 1:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 2:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 3:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 4:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 5:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 6:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 7:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
            case 8:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
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
                })
                {
                }.start();
                clipfondo.stop();
                break;
        }
    }
}
