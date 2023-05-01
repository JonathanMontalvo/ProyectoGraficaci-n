package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.swing.JOptionPane;
import static org.yourorghere.Main.cambiarEspacio;

/**
 *
 * @author Guillermo Diaz
 */
public class KingDice
{

    //precision and global variables
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static int mvt = 0;
    private static boolean cam = false;
    private static boolean salt = false;
    private static boolean agach = false;
    private static boolean apunt = false;
    private static boolean bail = false;
    private static boolean mCint = false;
    private static boolean mCar = false;
    private static boolean pieDer = false;
    private static boolean pieIzq = false;

    //heigth and widht of each components
    private static final float HEIGHT_WHITE_STRAW = 0.4f;
    private static final float HEIGHT_RED_STRAW = 0.1f;
    private static final float HEIGHT_BODY = 0.55f;
    private static final float HEIGHT_SHORT_LEGS = 0.2f;
    private static final float HEIGHT_LEGS = 2.25f;
    private static final float HEIGHT_ARMS = 1.5f;
    private static final float HEIGHT_BACK_OF_SHOES = 0.06f;
    private static final float HEIGHT_FRONT_OF_SHOES = 0.06f;
    private static final float WIDTH_HEAD = 0.62f;
    private static final float WIDTH_MILK = 0.56f;
    private static final float WIDTH_EYESA = 0.228f;
    private static final float WIDTH_EYES = 0.25f;
    private static final float WIDTH_PUPIL_GREEN = 0.18f;
    private static final float WIDTH_PUPIL = 0.1f;
    private static final float WIDTH_NOSE = 0.15f;
    private static final float WIDTH_SHORTS = 0.4f;
    private static final float WIDTH_LEGS = 0.3f;
    private static final float WIDTH_HAND = 0.11f;
    private static final float WIDTH_ARMS = 0.2f;
    private static final float WIDTH_BACK_OF_SHOES = 0.1f;
    private static final float WIDTH_FRONT_OF_SHOES = 0.12f;
    private static final float WIDTH_BACK_OF_SHOES_SOLE = 0.09f;
    private static final float WIDTH_FRONT_OF_SHOES_SOLE = 0.09f;
    private static final float TOP_WHITE_STRAW = 0.09f;
    private static final float TOP_RED_STRAW = 0.091f;
    private static final float TOP_BODY = 0.25f;
    private static final float TOP_SHORT_LEGS = 0.08f;
    private static final float BOTTOM_WHITE_STRAW = 0.09f;
    private static final float BOTTOM_RED_STRAW = 0.091f;
    private static final float BOTTOM_BODY = 0.35f;
    private static final float BOTTOM_SHORT_LEGS = 0.1f;
    
    public void draw_KingDice(GL gl, boolean brincar, boolean guinio, boolean triste, boolean serio, boolean enojado, boolean muerto,
            boolean feliz)
    {
        
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //Cuphead only jumps once
        if (KingDice.mvt >= 11 && brincar) {
            cambiarEspacio(false);
        }
        
        if (brincar && mvt % 20 + 10 > 20) {
            gl.glTranslatef(0f, .5f, 0.0f);//(-izq+der,-abajo +arriba,-atras+enfrente)  
            //feliz, enojado, serio, sorpresa, triste, ginio, muerto, miedo
            dibujar_Cabeza(gl, glu, false, false, false, true, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, 'J', false);
            gl.glRotatef(240f, 1f, 0f, 0f);
            gl.glTranslatef(0f, -3.3f, 0.9f);//(-Izq+Der,-atras+enfrente,-abajo +arriba,)
            dibujar_Brazo_Derecho(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu);
        } else if (guinio) {//levanta mano izq y guiño            
            //feliz, enojado,serio,sorpresa,triste,ginio, muerto, miedo            
            dibujar_Cabeza(gl, glu, false, false, false, false, false, true, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
            dibujar_Brazo_Derecho(gl, glu);
            gl.glRotatef(240f, 1f, 0f, 0f);
            gl.glTranslatef(0f, -3.3f, 0.9f);//(-Izq+Der,-atras+enfrente,-abajo +arriba,)
            dibujar_Brazo_Izquierdo(gl, glu);
        } else if (triste) {
            //feliz, enojado,serio,sorpresa,triste,ginio, muerto, miedo            
            dibujar_Cabeza(gl, glu, false, false, false, false, true, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
            gl.glTranslatef(0.0f, .7f, 2.3f);//0.3//(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(290f, 1f, 0f, 0f);
            dibujar_Brazo_Derecho(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu);
        } else if (serio) {
            gl.glTranslatef(0f, -2.1f, 0.0f);
            ////feliz, enojado,serio,sorpresa,triste,ginio, muerto, miedo   
            dibujar_Cabeza(gl, glu, false, false, true, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Brazo_Derecho(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu);
            gl.glTranslatef(0.0f, -0.2f, 0.5f);//(-Izq+Der,-abajo +arriba,-atras+enfrente)            
            gl.glRotatef(275f, 1f, 0f, 0f);
            dibujar_Piernas(gl, glu, ' ', true);
        } else if (enojado) {
            //feliz,enojado,serio,sorpresa,triste,ginio, muerto, miedo            
            dibujar_Cabeza(gl, glu, false, true, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
            dibujar_Brazo_Izquierdo(gl, glu);
            gl.glTranslatef(4.0f, 1.2f, 0.3f);       //(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(120f, 0f, 0f, 1f);
            dibujar_Brazo_Derecho(gl, glu);
        } else if (muerto) {
            gl.glTranslatef(0f, -2f, 0.0f);
            gl.glRotatef(270f, 1f, 0f, 0f);
            //feliz, enojado,serio,sorpresa,triste,ginio,muerto,miedo   
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, true, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Brazo_Derecho(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
        } else if (feliz && mvt % 20 + 10 > 20) {
            gl.glTranslatef(0f, .5f, 0.0f);
            //feliz,enojado,serio,sorpresa,triste,ginio, muerto, miedo            
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
            gl.glPushMatrix();
            gl.glTranslatef(-1.8f, 2.5f, 0.3f);       //(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(-120f, 0f, 0f, 1f);
            dibujar_Brazo_Izquierdo(gl, glu);
            gl.glPopMatrix();
            gl.glTranslatef(4.06f, 1.2f, 0.3f);       //(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(120f, 0f, 0f, 1f);
            dibujar_Brazo_Derecho(gl, glu);
        } //        dibujar_Brazo_Derecho(gl, glu);
        else if (feliz && mvt % 20 + 10 <= 20) {
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', true);
            gl.glPushMatrix();
            gl.glTranslatef(-1.8f, 2.5f, 0.3f);       //(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(-120f, 0f, 0f, 1f);
            dibujar_Brazo_Izquierdo(gl, glu);
            gl.glPopMatrix();
            gl.glTranslatef(4.06f, 1.2f, 0.3f);       //(-Izq+Der,-abajo +arriba,-atras+enfrente)
            gl.glRotatef(120f, 0f, 0f, 1f);
            dibujar_Brazo_Derecho(gl, glu);
        } else {
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Piernas(gl, glu, ' ', false);
            dibujar_Brazo_Derecho(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu);
        }
        mvt++;
    }
    
    public void dibujar_Cabeza(GL gl, GLU glu, boolean feliz, boolean enojado, boolean serio, boolean sorpresa, boolean triste,
            boolean ginio, boolean muerto, boolean miedo)
    {
        set_white_head_material(gl);
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
        
        double[] cutplane = new double[]{0.0f, 0.1f, 0.0f, 0.0f};
        //pARPADOS DE ARRIBA
        double[] cutplaneA = new double[]{0.0f, 1.0f, 0.0f, 0.0f};
        double[] cutplaneP = new double[]{0.0f, -0.1f, 0.0f, 0.0f};
        //Creamos la nariz        
        set_blue_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 0.4f, 0.9f);
        glu.gluSphere(q, WIDTH_NOSE, 100, 100);
        gl.glPopMatrix();
        if (feliz != false || enojado != false || serio != false || sorpresa != false || triste != false
                || ginio != false || muerto != false || miedo != false) {
            
            if (feliz == true) {
//fELIZ 
//Right cejas
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, 1.0f, 1.0f);
                gl.glRotatef(-10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.1f, .95f, 1.0f);
                gl.glRotatef(10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

//Dibujamos ojos blancos
                set_white_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
//        Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();

                //Boca  feliz
                cutplane[1] = -1.0f;
                cutplane[2] = 0.0f;
                cutplane[3] = -0.65 * .1f;
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.5f, 0.27f, 1.16f);
                gl.glRotatef(30f, 1f, 0f, 0f);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                draw_torus(gl, 0.2f, 0.060f, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
            }

//enojado
            if (enojado == true) {
                set_purpura2_material(gl);
                //      PARAPDO IZQ ABAJO
                set_purpura2_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.71f, 0.851f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneP, 0);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
//PARPAD DERERECHA ABAJO
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.71f, 0.851f);//-4
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneP, 0);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();

                //      parpados de arriba IZQUIRDA
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.772f, 0.88F);//87f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneA, 0);
                glu.gluSphere(q, .22F, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, .772f, .88f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneA, 0);
                glu.gluSphere(q, .22F, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
//Dibujamos ojos blancos
                set_white_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();

//        Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                gl.glEnable(GL.GL_CLIP_PLANE2);
                gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glDisable(GL.GL_CLIP_PLANE2);
                gl.glPopMatrix();

//Dibujamos las Cejas enojado
                //      Rigth
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.55f, 0.84f, 1.0f);
                gl.glRotatef(45f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //    Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.49f, 0.867f, 1.0f);
                gl.glRotatef(135f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                //Boca sorprendido
                gl.glPushMatrix();
                gl.glTranslatef(0.4f, 0.15f, 0.91f);
                glu.gluSphere(q, WIDTH_NOSE, 100, 100);
                gl.glPopMatrix();
            }
            
            if (ginio == true) {

//Giño la roca Rigth Cejas
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, 1.0f, 1.0f);
                gl.glRotatef(-10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.49f, 0.867f, 1.0f);
                gl.glRotatef(175f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

//Dibujamos ojos blancos
                set_white_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
//        Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();

//Boca 
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.35f, 0.15f, 1.0f);
                gl.glRotatef(.9f, 0f, 0f, 1f);
                gl.glScalef(0.4f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
            }
            if (sorpresa == true) { //Validado :)
//SOrprendido cejas
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, 1.0f, 1.0f);
                gl.glRotatef(-10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.1f, .95f, 1.0f);
                gl.glRotatef(10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

//Dibujamos ojos blancos
                set_white_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
//        Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();

                //Boca sorprendido
                gl.glPushMatrix();
                gl.glTranslatef(0.4f, 0.15f, 0.91f);
                glu.gluSphere(q, WIDTH_NOSE, 100, 100);
                gl.glPopMatrix();
            }
            if (triste == true) {
//truste cejas
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, .9f, 1.0f);
                gl.glRotatef(-10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                //Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.1f, .85f, 1.0f);
                gl.glRotatef(10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //Dibujamos ojos blancos
                set_white_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.83f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
                gl.glPopMatrix();
//        Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();

//Boca truste
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.18f, .2f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                gl.glScalef(.5f, 0.06f, .05f);
                boxC(gl);
                gl.glPopMatrix();
            }
            
            if (miedo == true) {
                //Miedo
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, .9f, 1.0f);
                gl.glRotatef(-10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();

                //Left
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.1f, .85f, 1.0f);
                gl.glRotatef(10f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.26f, .15f, 1.0f);
                gl.glRotatef(-5f, 0f, 0f, 1f);
                gl.glScalef(.4f, 0.06f, .05f);
                boxC(gl);
                gl.glPopMatrix();
                //Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, .985f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, .985f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
            }
            
            if (serio == true) {
//Serio
                //Creamos la pupila verde de los ojos
                set_green_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 0.91f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 0.91f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
                gl.glPopMatrix();
//Boca serio
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.3f, .1f, 1.0f);
                //gl.glRotatef(f, 0f, 0f, 1f);
                gl.glScalef(.5f, 0.06f, .05f);
                boxC(gl);
                gl.glPopMatrix();

//        Creamos la pupila de los ojos
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.7f, 1.0f);
                gl.glRotatef(-15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
                
                gl.glPushMatrix();
                gl.glTranslatef(0.3f, 0.70f, 1.0f);
                gl.glTranslatef(0.4f, 0.0f, 0.0f);
                gl.glRotatef(15f, 0f, 0f, 1f);
                glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
                gl.glPopMatrix();
            }
            
            if (muerto == true) {
//Muerto
////ojoIzquierdo
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.1f, .9f, 1.1f);
                gl.glRotatef(-30f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.1f, .715f, 1.1f);
                gl.glRotatef(30f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
//Derecho
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(.6f, .9f, 1.1f);
                gl.glRotatef(-30f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                gl.glPushMatrix();
                set_black_material(gl);
                gl.glTranslatef(0.6f, .715f, 1.1f);
                gl.glRotatef(30f, 0f, 0f, 1f);
                gl.glScalef(0.3f, 0.04f, 0.05f);
                boxC(gl);
                gl.glPopMatrix();
                
            }
        } //Validado :)
        else {
            set_purpura2_material(gl);
            //   PARAPDO IZQ ABAJO
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.71f, 0.851f);
            gl.glRotatef(-15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneP, 0);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
//PARPAD DERERECHA ABAJO
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.71f, 0.851f);//-4
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneP, 0);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //      parpados de arriba IZQUIRDA
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.772f, 0.88F);//87f);
            gl.glRotatef(-15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneA, 0);
            glu.gluSphere(q, .22F, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, .772f, .88f);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplaneA, 0);
            glu.gluSphere(q, .22F, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
//Dibujamos ojos blancos
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.70f, 0.83f);
            gl.glRotatef(-15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.70f, 0.83f);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

//        Creamos la pupila verde de los ojos
            set_green_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.7f, 0.91f);
            gl.glRotatef(-15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.70f, 0.91f);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_PUPIL_GREEN, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            //Creamos la pupila de los ojos
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.7f, 1.0f);
            gl.glRotatef(-15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.70f, 1.0f);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

//Dibujamos las Cejas enojado
            //      Rigth
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(0.55f, 0.84f, 1.0f);
            gl.glRotatef(45f, 0f, 0f, 1f);
            gl.glScalef(0.3f, 0.04f, 0.05f);
            boxC(gl);
            gl.glPopMatrix();

            //    Left
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(0.49f, 0.867f, 1.0f);
            gl.glRotatef(135f, 0f, 0f, 1f);
            gl.glScalef(0.3f, 0.04f, 0.05f);
            boxC(gl);
            gl.glPopMatrix();
            
        }

//        //Creamos el moño        
        set_purpuraF_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, -0.2f, 1.0f);//(,-abajo +arriba,-atras+enfrente)
        glu.gluSphere(q, WIDTH_NOSE, 100, 100);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.25f, -0.2f, 1.0f);//(-izq+der,-abajo +arriba,-atras+enfrente)
        glu.gluSphere(q, 0.2f, 100, 100);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.75f, -0.2f, 1.0f);//(-izq+der,-abajo +arriba,-atras+enfrente)
        glu.gluSphere(q, 0.2f, 100, 100);
        gl.glPopMatrix();
        set_blue_material(gl);

//Dos puntos
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.70f, 0.70f, -.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.30f, 0.30f, -.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();

//Cuatro puntos
        set_blue_material(gl);
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.75f, 0.75f, 1.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.25f, 0.75f, 1.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.75f, 0.25f, 1.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 0f, 1f, 0f);
        gl.glTranslatef(-0.25f, 0.25f, 1.0001f);//(-enfrente +atras,-abajo +arriba,-izquierda +derecha,)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();

        //cinco puntos        
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.5f, 0.5f, -1.0001f);//(-izquierda +derecha,-atras +enfrente,-arriba +abajo)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.2f, 0.8f, -1.0001f);//(-izquierda +derecha,-atras +enfrente,-arriba +abajo)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.8f, 0.8f, -1.0001f);//(-izquierda +derecha,-atras +enfrente,-arriba +abajo)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.2f, 0.2f, -1.0001f);//(-izquierda +derecha,-atras +enfrente,-arriba +abajo)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.8f, 0.2f, -1.0001f);//(-izquierda +derecha,-atras +enfrente,-arriba +abajo)
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glPopMatrix();

        //seis puntos                        
        gl.glTranslatef(0.75f, 0.5f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glTranslatef(0f, 0.3f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glTranslatef(0.0f, -0.6f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glTranslatef(-0.5f, 0.0f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glTranslatef(0f, 0.3f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
        gl.glTranslatef(0f, 0.3f, -0.0001f);
        glu.gluDisk(q, -0.12f, BOTTOM_WHITE_STRAW, SLICES, STACKS);
    }
    
    public void dibujar_Brazo_Derecho(GL gl, GLU glu)
    {
        //Creamos los hombro y el brazo
        set_purpura3_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(1.70f, 1.8f, 0.5f);//0.3
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glRotatef(5f, 0f, 1f, 0f);
        gl.glRotatef(330f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        gl.glPopMatrix();

        //Creamos la mano
        gl.glPushMatrix();
        set_white_head_material(gl);
        gl.glTranslatef(1.67f, 0.9f, 1.0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glRotatef(20f, 0f, 1f, 0f);
        gl.glRotatef(330f, 1f, 0f, 0f);
        gl.glTranslatef(0.0f, 0.0f, 0.42f);
        draw_torus(gl, 0.04f, 0.045f, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, -0.42f);
        gl.glTranslatef(0.0f, 0.0f, 0.5f);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }
    
    public void dibujar_Brazo_Izquierdo(GL gl, GLU glu)
    {
        //Creamos el hombro y el brazo
        set_purpura3_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.20f, 1.8f, 0.5f);//-0.3
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glRotatef(-5f, 0f, 1f, 0f);
        gl.glRotatef(330f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        gl.glPopMatrix();

        //Dibujar la mano
        gl.glPushMatrix();
        set_white_head_material(gl);
        gl.glTranslatef(-0.17f, 0.9f, 1.01f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glRotatef(340f, 0f, 1f, 0f);
        gl.glRotatef(330f, 1f, 0f, 0f);
        gl.glTranslatef(0.0f, 0.0f, 0.42f);
        draw_torus(gl, 0.04f, 0.045f, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, -0.42f);
        gl.glTranslatef(0.0f, 0.0f, 0.5f);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }
    
    public void draw_torus(GL gl, float R, float r, int N, int n)
    {
        
        int maxn = 1000;
        n = Math.min(n, maxn - 1);
        N = Math.min(N, maxn - 1);
        float rr = 1.5f * r;
        double dv = 2 * Math.PI / n;
        double dw = 2 * Math.PI / N;
        double v = 0.0f;
        double w = 0.0f;
        while (w < 2 * Math.PI + dw) {
            v = 0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while (v < 2 * Math.PI + dv) {
                gl.glNormal3d(
                        (R + rr * Math.cos(v)) * Math.cos(w) - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w) - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw) - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw) - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        rr * Math.sin(v + dv) - r * Math.sin(v + dv));
                gl.glVertex3d((R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        r * Math.sin(v + dv));
                v += dv;
            }
            gl.glEnd();
            w += dw;
        }
    }
    
    public void boxC(GL gl)
    {
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
        
    }
    
    public void dibujar_Cuerpo(GL gl, GLU glu)
    {
        // Creamos el cuello
        set_purpura3_material(gl);
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.25f, 0.6f, 0.5f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);//Cilindro del cuello
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -0.55f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);//Base del cuello
        gl.glPopMatrix();

        //Cuerpo
        gl.glTranslatef(-0.5f, -2f, 0f);//(H,V,f)
        gl.glBegin(GL.GL_POLYGON);/* f3:arriba */
        
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 1.0f, 0.0f);
        gl.glVertex3f(1.5f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        
        gl.glTranslatef(0.0f, -1f, 0f);//(-H+,V,f)
        gl.glBegin(GL.GL_POLYGON);/* f4: frente */
        
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.5f, 2f, 1.0f);
        gl.glVertex3f(1.5f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 2f, 1.0f);
        gl.glEnd();
        
        gl.glBegin(GL.GL_POLYGON);/* f1: abajo */
        
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.5f, 0.0f, 1.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glEnd();
        
        gl.glBegin(GL.GL_POLYGON);/* f2: atras */
        
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glEnd();
        
        gl.glTranslatef(0.0f, 0f, 0f);//(-H+,V,f)
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 1.0f);
        gl.glVertex3f(1.5f, 2.0f, 1.0f);
        gl.glVertex3f(1.5f, 2.0f, 0.0f);
        gl.glEnd();
    }
    
    public void dibujar_Piernas(GL gl, GLU glu, char c, boolean izquierda)
    {
        
        gl.glPushMatrix();
        set_purpuraF_material(gl);//Pierna derecha
        gl.glTranslatef(1.12f, 0.0f, 0.5f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        
        gl.glTranslatef(0.0f, 0.0f, 2.25f);//Ajusta la posición de la base        
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);//Pinta la base del cilindro
        gl.glPopMatrix();

        //Pierna Izquierda
        gl.glPushMatrix();
        gl.glTranslatef(1.0f, 0.0f, 0.5f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(-0.6f, 0.0f, 0.0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        
        gl.glTranslatef(0.0f, 0.0f, 2.25f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
//zapatos
//      Rigth
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0999f, -2.29f, .2f);
        gl.glScalef(.61f, 0.2f, 0.9f);
        boxC(gl);
        gl.glPopMatrix();

        //    Left
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(.81f, -2.29f, .2f);
        gl.glScalef(.61f, 0.2f, 0.9f);
        boxC(gl);
        gl.glPopMatrix();
        set_white_material(gl);
    }
    
    public void set_skin_material(GL gl)
    {
        float[] mat_ambient = {1.0f, 0.79f, 0.68f, 0.0f};
        float[] mat_diffuse = {0.59f, 0.44f, 0.41f, 0.0f};
        float shine = 128f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_shirt_material(GL gl)
    {
        float mat_ambient[] = {0.5f, 0.45f, 0.3f, 1.0f};
        float[] mat_diffuse = {0.8f, 0.8f, 0.8f, 1.0f};
        float mat_specular[] = {0.4f, 0.3f, 0.2f, 1.0f};
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
    
    public void set_red_material(GL gl)
    {
        
        float[] mat_ambient = {0.8f, 0.05f, 0.15f, 0.2f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 15.0f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_green_material(GL gl)
    {
        
        float[] mat_ambient = {0.5f, 0.7f, 0.25f, 0.2f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 15.0f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_purpura_material(GL gl)
    {
        
        float mat_ambient[] = {0.2f, 0.2f, 0.8f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_purpura2_material(GL gl)
    {
        float mat_ambient[] = {0.45f, 0.35f, 0.75f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
    
    public void set_purpuraF_material(GL gl)
    {
        float mat_ambient[] = {0.50196078431f, 0.0f, 0.50196078431f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
    
    public void set_purpura3_material(GL gl)
    {
        float mat_ambient[] = {0.6f, 0.55f, 0.75f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
    
    public void set_white_material(GL gl)
    {
        
        float mat_ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 51.2f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_blue_material(GL gl)
    {
        
        float mat_ambient[] = {0.4f, 0.2f, 0.6f, 1.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_white_head_material(GL gl)
    {
        
        float mat_ambient[] = {0.8f, 0.8f, 0.8f, 1.5f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 1.5f};
        float mat_specular[] = {0.7f, 0.7f, 0.7f, 1.5f};
        float shine = 125.2f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void set_black_material(GL gl)
    {
        
        float mat_ambient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_diffuse[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_specular[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float shine = 125.2f;
        
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
    }
    
    public void fondo(GL gl, GLU glu, Texture t)
    {
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D, m);
        gl.glBegin(GL.GL_QUADS);
        
        gl.glTexCoord2d(0.0f, 1.0f);
        gl.glVertex3d(-7.0f, -7.0f, -7.0f);
        
        gl.glTexCoord2d(1.0f, 1.0f);
        gl.glVertex3d(7.0f, -7.0f, -7.0f);
        
        gl.glTexCoord2d(1.0f, 0.0f);
        gl.glVertex3d(7.0f, 7.0f, -7.0f);
        
        gl.glTexCoord2d(0.0f, 0.0f);
        gl.glVertex3d(-7.0f, 7.0f, -7.0f);
        
        gl.glEnd();
        gl.glDisable(GL.GL_TEXTURE_2D);
        gl.glFlush();
    }
    
}
