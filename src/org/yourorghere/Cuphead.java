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
import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import static org.yourorghere.Main.cambiarEspacio;

public class Cuphead
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
    private static final float HEIGHT_LEGS = 0.25f;
    private static final float HEIGHT_SOLE = 0.22f;
    private static final float HEIGHT_BACK_OF_SHOES = 0.04f;
    private static final float HEIGHT_FRONT_OF_SHOES = 0.04f;
    private static final float HEIGHT_ARMS = 0.5f;
    private static final float HEIGHT_FINGERS = 0.1f;
    private static final float WIDTH_HEAD = 0.62f;
    private static final float WIDTH_MILK = 0.56f;
    private static final float WIDTH_HANDLE = 0.18f;
    private static final float WIDTH_EYES = 0.33f;
    private static final float WIDTH_PUPIL = 0.1f;
    private static final float WIDTH_NOSE = 0.06f;
    private static final float WIDTH_MOUTH = 0.18f;
    private static final float WIDTH_SHORTS = 0.4f;
    private static final float WIDTH_LEGS = 0.05f;
    private static final float WIDTH_ARMS = 0.08f;
    private static final float WIDTH_HAND = 0.11f;
    private static final float WIDTH_BACK_OF_SHOES = 0.1f;
    private static final float WIDTH_FRONT_OF_SHOES = 0.12f;
    private static final float WIDTH_BACK_OF_SHOES_SOLE = 0.09f;
    private static final float WIDTH_FRONT_OF_SHOES_SOLE = 0.11f;
    private static final float WIDTH_SOLE_BACK = 0.08f;
    private static final float WIDTH_SOLE_FRONT = 0.10f;
    private static final float WIDTH_FINGERS = 0.03f;
    private static final float TOP_WHITE_STRAW = 0.09f;
    private static final float TOP_RED_STRAW = 0.091f;
    private static final float TOP_BODY = 0.25f;
    private static final float TOP_SHORT_LEGS = 0.08f;
    private static final float BOTTOM_WHITE_STRAW = 0.09f;
    private static final float BOTTOM_RED_STRAW = 0.091f;
    private static final float BOTTOM_BODY = 0.35f;
    private static final float BOTTOM_SHORT_LEGS = 0.1f;

    //position of each component int the window
    public Cuphead()
    {
    }

    public void draw_cuphead(GL gl, boolean caminar, boolean saltar, boolean agachar,
            boolean apuntar, boolean bailar, boolean mCintura, boolean mCara, boolean eliminado, boolean quieto)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //Cuphead only jumps once
        if (Cuphead.mvt >= 11 && saltar) {
            cambiarEspacio(false);
        }

        //Cuphead is walking
        if (caminar && mvt % 8 + 3 > 7) {
            Cuphead.pieDer = true;
            Cuphead.pieIzq = false;
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Pantalones(gl, glu, true, false, false);
            dibujar_Pierna_Derecha(gl, glu);

            dibujar_Zapato_Derecho(gl, glu);

            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, -0.15f);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glRotatef(25f, 1f, 0f, 0f);
            gl.glRotatef(25f, 1f, 0f, 0f);//
            gl.glRotatef(25f, 0f, 1f, 0f);
            gl.glTranslatef(0.0f, -0.03f, 0.0f);
            dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
            gl.glRotatef(-25f, 0f, 1f, 0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);//
            gl.glTranslatef(0.0f, 0.03f, 0.0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.03f, -0.05f, 0.2f);
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
        } else if (caminar && mvt % 8 + 3 <= 7) {
            Cuphead.pieIzq = true;
            Cuphead.pieDer = false;
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Pantalones(gl, glu, false, true, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, -0.15f);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
            gl.glRotatef(25f, 1f, 0f, 0f);

            gl.glRotatef(25f, 1f, 0f, 0f);//
            gl.glRotatef(-25f, 0f, 1f, 0f);
            gl.glTranslatef(0.0f, -0.03f, 0.0f);
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            gl.glRotatef(25f, 0f, 1f, 0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);//

            gl.glTranslatef(0.0f, 0.03f, 0.0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(-0.03f, -0.05f, 0.2f);
            dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
        } //Cuphead is jumping
        else if (saltar && mvt % 20 + 10 <= 20) {//26 9 9 Segundos
            Cuphead.pieIzq = false;
            Cuphead.pieDer = false;
            gl.glTranslatef(0f, 0.75f, 0f);
            dibujar_Cabeza(gl, glu, false, true, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Pantalones(gl, glu, false, false, false);
            gl.glRotatef(-15f, 1f, 0f, 0f);
            gl.glTranslatef(0f, 0.03f, -0.15f);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            gl.glPushMatrix();
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glPopMatrix();
            gl.glPushMatrix();
            dibujar_Zapato_Derecho(gl, glu);
            gl.glPopMatrix();
            gl.glRotatef(15f, 1f, 0f, 0f);
            gl.glTranslatef(0f, -0.03f, 0.15f);
            gl.glTranslatef(0f, 0.55f, 0.3f);
            gl.glRotatef(240f, 1f, 0f, 0f);
            gl.glRotatef(28f, 0f, 1f, 0f);
            dibujar_Brazo_Derecho(gl, glu, false, false, false, false);
            gl.glRotatef(-56f, 0f, 1f, 0f);
            dibujar_Brazo_Izquierdo(gl, glu, false, false);
        }//Cuphead is bend over
        else if (agachar && mvt % 10 + 10 > 10) {
            gl.glRotatef(35f, 1f, 0f, 0f);
            dibujar_Cabeza(gl, glu, false, false, true, false, false, false);
            dibujar_Cuerpo(gl, glu);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            dibujar_Brazo_Izquierdo(gl, glu, false, false);
            dibujar_Brazo_Derecho(gl, glu, false, false, false, false);
            gl.glRotatef(25f, 1f, 0f, 0f);
            dibujar_Pantalones(gl, glu, false, false, true);
            gl.glRotatef(-35f, 1f, 0f, 0f);
            gl.glTranslatef(0f, 0.0f, -0.24f);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
        }//cuphead is aiming
        else if (apuntar && mvt % 20 + 10 > 20) {
            dibujar_Cabeza(gl, glu, false, false, false, true, false, false);
            dibujar_Cuerpo(gl, glu);

            gl.glRotatef(25f, 1f, 0f, 0f);//
            gl.glRotatef(-25f, 0f, 1f, 0f);
            gl.glTranslatef(0.0f, -0.03f, 0.0f);
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            gl.glRotatef(25f, 0f, 1f, 0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);//
            gl.glTranslatef(0.0f, 0.03f, 0.0f);

            gl.glRotatef(-65f, 1f, 0f, 0f);
            gl.glRotatef(-10f, 0f, 0f, 1f);
            gl.glTranslatef(-0.05f, -0.12f, 0.27f);
            dibujar_Brazo_Derecho(gl, glu, false, true, false, false);
            gl.glTranslatef(0.05f, 0.12f, -0.27f);
            gl.glRotatef(10f, 0f, 0f, 1f);
            gl.glRotatef(65f, 1f, 0f, 0f);

            dibujar_Pantalones(gl, glu, false, false, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
        }//Cuphead is dancing
        else if (bailar && mvt % 20 + 10 > 20) {
            gl.glRotatef(-10f, 1f, 0f, 0f);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);

            gl.glRotatef(-65f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, -0.2f, 0.3f);
            gl.glRotatef(-45f, 0f, 0f, 1f);
            gl.glTranslatef(-0.15f, -0.3f, -0.01f);//
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            gl.glTranslatef(0.15f, 0.3f, 0.01f);//
            gl.glRotatef(45f, 0f, 0f, 1f);

            gl.glRotatef(45f, 0f, 0f, 1f);
            gl.glTranslatef(0.15f, -0.3f, -0.01f);//
            dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
            gl.glTranslatef(-0.15f, 0.3f, 0.01f);//
            gl.glRotatef(-45f, 0f, 0f, 1f);

            gl.glTranslatef(0.0f, 0.2f, -0.3f);
            gl.glRotatef(65f, 1f, 0f, 0f);

            dibujar_Pantalones(gl, glu, false, true, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, -0.15f);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
            gl.glRotatef(25f, 1f, 0f, 0f);
        } else if (bailar && mvt % 20 + 10 <= 20) {
            gl.glRotatef(10f, 1f, 0f, 0f);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            gl.glTranslatef(0.0f, 0.25f, -0.5f);//
            gl.glRotatef(-65f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, -0.2f, 0.3f);
            gl.glRotatef(45f, 0f, 0f, 1f);
            gl.glTranslatef(-0.12f, -0.3f, -0.01f);//
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            gl.glTranslatef(0.12f, 0.3f, 0.01f);//
            gl.glRotatef(-45f, 0f, 0f, 1f);

            gl.glRotatef(-45f, 0f, 0f, 1f);
            gl.glTranslatef(0.12f, -0.3f, -0.01f);//
            dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
            gl.glTranslatef(-0.12f, 0.3f, 0.01f);//
            gl.glRotatef(45f, 0f, 0f, 1f);

            gl.glTranslatef(0.0f, 0.2f, -0.3f);
            gl.glRotatef(65f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, -0.25f, 0.5f);//
            dibujar_Pantalones(gl, glu, true, false, false);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, -0.15f);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glRotatef(25f, 1f, 0f, 0f);
        } // Cuphead with hands on waist
        else if (mCintura && mvt % 20 + 10 > 20) {
            dibujar_Cabeza(gl, glu, false, false, false, false, true, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu, false, true);
            dibujar_Brazo_Derecho(gl, glu, false, false, true, false);
            dibujar_Pantalones(gl, glu, false, false, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
        } //Cuphead is thinking
        else if (mCara && mvt % 20 + 10 > 20) {
            gl.glRotatef(-4f, 1f, 0f, 0f);
            gl.glRotatef(-4f, 0f, 1f, 0f);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, true);
            gl.glRotatef(4f, 1f, 0f, 0f);
            gl.glRotatef(4f, 0f, 1f, 0f);

            dibujar_Cuerpo(gl, glu);

            gl.glRotatef(25f, 1f, 0f, 0f);//
            gl.glRotatef(-25f, 0f, 1f, 0f);
            gl.glTranslatef(0.0f, -0.03f, 0.0f);
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            gl.glRotatef(25f, 0f, 1f, 0f);
            gl.glRotatef(-25f, 1f, 0f, 0f);//
            gl.glTranslatef(0.0f, 0.03f, 0.0f);

            dibujar_Brazo_Derecho(gl, glu, false, false, false, true);

            dibujar_Pantalones(gl, glu, false, false, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
        } //Cuphead is Knockout
        else if (eliminado) {
            dibujar_Cabeza(gl, glu, false, false, true, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu, true, false);
            dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
            dibujar_Pantalones(gl, glu, false, true, false);
            dibujar_Pierna_Izquierda(gl, glu);
            gl.glPushMatrix();
            dibujar_Zapato_Izquierdo(gl, glu);
            gl.glPopMatrix();
            gl.glRotatef(-25f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, -0.15f);
            dibujar_Pierna_Derecha(gl, glu);
            gl.glPushMatrix();
            dibujar_Zapato_Derecho(gl, glu);
            gl.glPopMatrix();
        } //Cuphead is normal
        else if (quieto) {
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false);
            dibujar_Cuerpo(gl, glu);
            dibujar_Brazo_Izquierdo(gl, glu, false, false);
            dibujar_Brazo_Derecho(gl, glu, false, false, false, false);
            dibujar_Pantalones(gl, glu, false, false, false);
            dibujar_Pierna_Izquierda(gl, glu);
            dibujar_Pierna_Derecha(gl, glu);
            dibujar_Zapato_Izquierdo(gl, glu);
            dibujar_Zapato_Derecho(gl, glu);
        } else {
            if (mvt % 8 + 3 > 7) {
                Cuphead.pieDer = true;
                Cuphead.pieIzq = false;
                dibujar_Cabeza(gl, glu, true, false, false, false, false, false);
                dibujar_Cuerpo(gl, glu);
                dibujar_Pantalones(gl, glu, true, false, false);
                dibujar_Pierna_Derecha(gl, glu);
                gl.glPushMatrix();
                dibujar_Zapato_Derecho(gl, glu);
                gl.glPopMatrix();
                gl.glRotatef(-25f, 1f, 0f, 0f);
                gl.glTranslatef(0.0f, 0.0f, -0.15f);
                dibujar_Pierna_Izquierda(gl, glu);
                gl.glPushMatrix();
                dibujar_Zapato_Izquierdo(gl, glu);
                gl.glPopMatrix();
                gl.glRotatef(25f, 1f, 0f, 0f);
                gl.glRotatef(25f, 1f, 0f, 0f);//
                gl.glRotatef(25f, 0f, 1f, 0f);
                gl.glTranslatef(0.0f, -0.03f, 0.0f);
                dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
                gl.glRotatef(-25f, 0f, 1f, 0f);
                gl.glRotatef(-25f, 1f, 0f, 0f);//
                gl.glTranslatef(0.0f, 0.03f, 0.0f);
                gl.glRotatef(-25f, 1f, 0f, 0f);
                gl.glTranslatef(0.03f, -0.05f, 0.2f);
                dibujar_Brazo_Izquierdo(gl, glu, true, false);
            } else if (mvt % 8 + 3 <= 7) {
                Cuphead.pieIzq = true;
                Cuphead.pieDer = false;
                dibujar_Cabeza(gl, glu, true, false, false, false, false, false);
                dibujar_Cuerpo(gl, glu);
                dibujar_Pantalones(gl, glu, false, true, false);
                dibujar_Pierna_Izquierda(gl, glu);
                gl.glPushMatrix();
                dibujar_Zapato_Izquierdo(gl, glu);
                gl.glPopMatrix();

                gl.glRotatef(-25f, 1f, 0f, 0f);
                gl.glTranslatef(0.0f, 0.0f, -0.15f);
                dibujar_Pierna_Derecha(gl, glu);
                gl.glPushMatrix();
                dibujar_Zapato_Derecho(gl, glu);
                gl.glPopMatrix();

                gl.glRotatef(25f, 1f, 0f, 0f);

                gl.glRotatef(25f, 1f, 0f, 0f);//
                gl.glRotatef(-25f, 0f, 1f, 0f);
                gl.glTranslatef(0.0f, -0.03f, 0.0f);
                dibujar_Brazo_Izquierdo(gl, glu, true, false);
                gl.glRotatef(25f, 0f, 1f, 0f);
                gl.glRotatef(-25f, 1f, 0f, 0f);//

                gl.glTranslatef(0.0f, 0.03f, 0.0f);
                gl.glRotatef(-25f, 1f, 0f, 0f);
                gl.glTranslatef(-0.03f, -0.05f, 0.2f);
                dibujar_Brazo_Derecho(gl, glu, true, false, false, false);
            }
        }
        mvt++;
    }

    public void dibujar_Cabeza(GL gl, GLU glu, boolean triste, boolean sorprendido,
            boolean enojado, boolean guinio, boolean serio, boolean pensativo)
    {
        //Creamos el popote
        set_white_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 1.3f, -0.2f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glRotatef(20f, 0f, 1f, 0f);
        glu.gluCylinder(q, TOP_WHITE_STRAW, BOTTOM_WHITE_STRAW, HEIGHT_WHITE_STRAW, SLICES, STACKS);//Cilindro Vertical Blanco 
        glu.gluDisk(q, 0f, BOTTOM_WHITE_STRAW, SLICES, STACKS);//Pinta la tapa del cilindro
        set_red_material(gl);
        gl.glTranslatef(0.0f, 0.0f, 0.1f);
        glu.gluCylinder(q, TOP_RED_STRAW, BOTTOM_RED_STRAW, HEIGHT_RED_STRAW, SLICES, STACKS);//Cilindro Vertical Rojo 1
        gl.glTranslatef(0.0f, 0.0f, 0.2f);
        glu.gluCylinder(q, TOP_RED_STRAW, BOTTOM_RED_STRAW, HEIGHT_RED_STRAW, SLICES, STACKS);//Cilindro Vertical Rojo 2
        set_white_material(gl);
        gl.glTranslatef(0.03f, 0.02f, -0.25f);
        gl.glRotatef(100f, 1f, 0f, 0f);
        gl.glRotatef(310f, 0f, 1f, 0f);
        glu.gluCylinder(q, TOP_WHITE_STRAW, BOTTOM_WHITE_STRAW, HEIGHT_WHITE_STRAW, SLICES, STACKS);//Cilindro Horizontal Blanco
        gl.glTranslatef(0.0f, 0.0f, 0.4f);
        glu.gluDisk(q, 0f, BOTTOM_WHITE_STRAW, SLICES, STACKS);//Pinta la tapa del cilindro horizontal
        gl.glTranslatef(0.0f, 0.0f, -0.4f);
        glu.gluDisk(q, 0f, BOTTOM_WHITE_STRAW, SLICES, STACKS);//Pinta la base del cilindro horizontal
        set_red_material(gl);
        gl.glTranslatef(0.0f, 0.0f, 0.1f);
        glu.gluCylinder(q, TOP_RED_STRAW, BOTTOM_RED_STRAW, HEIGHT_RED_STRAW, SLICES, STACKS);//Cilindro Horizontal Rojo 1
        gl.glTranslatef(0.0f, 0.0f, 0.2f);
        glu.gluCylinder(q, TOP_RED_STRAW, BOTTOM_RED_STRAW, HEIGHT_RED_STRAW, SLICES, STACKS);//Cilindro Horizontal Rojo 2
        gl.glPopMatrix();

        //Creamos la cabeza de Cuphead   
        set_white_head_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 1.0f, 0.0f);
        double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_HEAD, 100, 100);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Creamos el relleno de la cabeza de Cuphead
        set_white_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.965f, 0.0f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_MILK, 100, 100);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Creamos el mango de la taza
        set_white_head_material(gl);
        cutplane[0] = -1.0f;
        cutplane[1] = 0.0f;
        cutplane[2] = 0.0f;
        cutplane[3] = 0.40 * WIDTH_HANDLE;
        gl.glPushMatrix();
        gl.glRotatef(29f, 0.0f, 0.0f, 1.0f);
        gl.glRotatef(23f, 0.0f, -1.0f, 0.0f);
        gl.glTranslatef(-0.16f, 0.89f, 0.0f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Creamos la nariz
        set_red_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.7f, 0.55f);
        glu.gluSphere(q, WIDTH_NOSE, 100, 100);
        gl.glPopMatrix();

        if (triste == false && sorprendido == false && enojado == false
                && guinio == false && serio == false && pensativo == false) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.65 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.71f, 0.44f);
            gl.glRotatef(30f, 1f, 0f, 0f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.060f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (triste) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.55 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.48f, 0.26f);
            gl.glRotatef(240f, 1f, 0f, 0f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.060f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Sorprendido cejas
            set_black_material(gl);
            cutplane[0] = 0.0f;
            cutplane[1] = 1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.85 * WIDTH_HANDLE;//63

            gl.glPushMatrix();
            gl.glTranslatef(-0.27f, 0.84f, 0.59f);
            gl.glRotatef(165f, 0f, 1f, 0f);
            gl.glRotatef(350f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.20f, 0.035f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glTranslatef(-0.51f, -0.08f, 0.13f);
            gl.glRotatef(30f, 0f, 1f, 0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.20f, 0.035f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (sorprendido) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Sorprendido boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.65f, 0.32f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_MOUTH, 100, 100);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Sorprendido cejas
            set_black_material(gl);
            cutplane[0] = 0.0f;
            cutplane[1] = 1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.80 * WIDTH_HANDLE;//63
            gl.glPushMatrix();
            gl.glTranslatef(-0.27f, 0.86f, 0.59f);
            gl.glRotatef(165f, 0f, 1f, 0f);
            gl.glRotatef(350f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.20f, 0.035f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glTranslatef(-0.51f, -0.08f, 0.13f);
            gl.glRotatef(30f, 0f, 1f, 0f);
            gl.glRotatef(15f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.20f, 0.035f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (enojado) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos las cejas
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.9 * WIDTH_MOUTH;
            set_black_material(gl);

            //Ceja Izquierda
            gl.glPushMatrix();
            gl.glTranslatef(-0.13f, 0.96f, 0.49f);
            gl.glRotatef(270f, 1f, 0f, 0f);
            gl.glRotatef(45f, 0f, 1f, 0f);
            gl.glRotatef(25f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.15f, 0.050f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Ceja Derecha
            gl.glPushMatrix();
            gl.glTranslatef(0.13f, 0.96f, 0.49f);
            gl.glRotatef(270f, 1f, 0f, 0f);
            gl.glRotatef(135f, 0f, 1f, 0f);
            gl.glRotatef(25f, 0f, 0f, 1f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.15f, 0.050f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.55 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.48f, 0.26f);
            gl.glRotatef(240f, 1f, 0f, 0f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.060f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (guinio) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla del ojo Derecho
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.65 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.71f, 0.44f);
            gl.glRotatef(30f, 1f, 0f, 0f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.060f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos el ojo cerrado
            cutplane[1] = 1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.9 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.20f, 0.80f, 0.34f);
            gl.glRotatef(-25f, 0f, 0f, 1f);
            gl.glRotatef(-15f, 0f, 1f, 0f);
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.050f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (serio) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.84f, 0.6f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.65 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.57f, 0.24f);//44 z
            gl.glRotatef(-90f, 1f, 0f, 0f);//90
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.24f, 0.030f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (pensativo) {
            //Creamos lo blanco de los ojos
            cutplane[0] = 0.0f;
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.0f;
            set_white_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.2f, 0.95f, 0.35f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.4f, 0.0f, 0.0f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la pupíla de los ojos
            cutplane[1] = 0.0f;
            cutplane[2] = 1.0f;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.33f, 0.86f, 0.58f);
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glTranslatef(0.5f, 0.0f, 0.03f);
            glu.gluSphere(q, WIDTH_PUPIL, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();

            //Creamos la boca
            cutplane[1] = -1.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = -0.65 * WIDTH_MOUTH;
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.57f, 0.24f);//44 z
            gl.glRotatef(-90f, 1f, 0f, 0f);//90
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.24f, 0.030f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        }
        set_white_material(gl);
    }

    public void dibujar_Cuerpo(GL gl, GLU glu)
    {
        // Creamos el cuerpo de Cuphead
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.0f, 0.0f, -0.45f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);//Cilindro del cuerpo
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -0.55f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);//Base del cuerpo
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Brazo_Derecho(GL gl, GLU glu, boolean caminar, boolean apuntar, boolean cintura, boolean pensar)
    {
        if (pensar) {
            //Creamos los hombro y el brazo
            set_red_material(gl);
            //set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.3f, 0.0f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(70f, 1f, 0f, 0f);//90
            gl.glRotatef(20f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 3, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.18f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.01f, 0.0f);
            gl.glRotatef(-90f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 1.6, SLICES, STACKS);
            gl.glPopMatrix();

        } else if (cintura) {
            //Creamos los hombro y el brazo
            set_red_material(gl);
            //set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.3f, 0.0f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(90f, 1f, 0f, 0f);//90
            gl.glRotatef(70f, 0f, 1f, 0f);//20
            gl.glRotatef(330f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 2, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.25f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(-90f, 0f, 1f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 1.8, SLICES, STACKS);
            gl.glPopMatrix();

        } else {
            //Creamos los hombro y el brazo
            set_red_material(gl);
            //set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.3f, 0.3f, 0.0f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glRotatef(20f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            gl.glPopMatrix();
        }

        //Creamos la mano
        gl.glPushMatrix();
        set_white_head_material(gl);
        gl.glTranslatef(0.3f, 0.3f, 0.0f);
        if (pensar) {
            gl.glRotatef(70f, 1f, 0f, 0f);//90
            gl.glRotatef(20f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, 0.18f);//0.3
            gl.glTranslatef(0.0f, 0.35f, 0.0f);
            gl.glRotatef(-90f, 1f, 0f, 0f);
        } else if (cintura) {
            gl.glRotatef(90f, 1f, 0f, 0f);//90
            gl.glRotatef(70f, 0f, 1f, 0f);//20
            gl.glRotatef(330f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, 0.25f);//0.3
            gl.glTranslatef(-0.3f, 0.0f, 0.0f);
            gl.glRotatef(-90f, 0f, 1f, 0f);
        } else {
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glRotatef(20f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, 0.42f);
        }
        draw_torus(gl, 0.04f, 0.045f, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, -0.42f);
        gl.glTranslatef(0.0f, 0.0f, 0.5f);
        glu.gluSphere(q, WIDTH_HAND, SLICES, STACKS);

        if (caminar) {
            gl.glRotatef(90f, 0f, 0f, 1f);
            gl.glRotatef(-35f, 1f, 0f, 0f);
        } else if (pensar) {
            gl.glRotatef(-35f, 1f, 0f, 0f);
        } else if (cintura) {
            gl.glRotatef(230f, 0f, 0f, 1f);
        }
        if (apuntar) {
            //Dedo índice
            gl.glTranslatef(0.01f, 0.03f, 0.09f);
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.09f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);

            //Dedo pulgar
            gl.glTranslatef(0.0f, 0.04f, -0.18f);
            gl.glRotatef(270f, 1f, 0f, 0f);//10 grados dif
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.09f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        } else {
            //Dedo 1
            gl.glTranslatef(0.02f, 0.03f, 0.0f);
            gl.glRotatef(170f, 0f, 0f, 1f);//10 grados dif
            gl.glRotatef(340f, 1f, 0f, 0f);//20 grados
            gl.glTranslatef(-0.05f, 0.0f, 0.06f);
            gl.glRotatef(345f, 0f, 1f, 0f);
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.09f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
            //Dedo 2
            gl.glRotatef(25f, 0f, 1f, 0f);
            gl.glTranslatef(0.10f, 0.0f, -0.07f);
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.1f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
            //Dedo 3
            gl.glRotatef(35f, 0f, 1f, 0f);
            gl.glTranslatef(0.125f, 0.0f, -0.08f);
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.1f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
            //Dedo pulgar
            gl.glTranslatef(-0.07f, 0.0f, -0.21f);
            gl.glRotatef(270f, 0f, 1f, 0f);
            glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.1f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Brazo_Izquierdo(GL gl, GLU glu, boolean caminar, boolean cintura)
    {
        if (cintura) {
            //Creamos los hombro y el brazo
            set_red_material(gl);
            //set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.3f, 0.3f, 0.0f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(90f, 1f, 0f, 0f);//90
            gl.glRotatef(290f, 0f, 1f, 0f);//20
            gl.glRotatef(330f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 2, SLICES, STACKS);
            gl.glTranslatef(0.0f, 0.0f, 0.25f);//0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(90f, 0f, 1f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS / 1.8, SLICES, STACKS);
            gl.glPopMatrix();
        } else {
            //Creamos el hombro y el brazo
            set_red_material(gl);
            //set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.3f, 0.3f, 0.0f);//-0.3
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glRotatef(340f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            gl.glPopMatrix();
        }

        //Dibujar la mano
        gl.glPushMatrix();
        set_white_head_material(gl);
        gl.glTranslatef(-0.3f, 0.3f, 0.0f);;
        if (cintura) {
            gl.glRotatef(90f, 1f, 0f, 0f);//90
            gl.glRotatef(290f, 0f, 1f, 0f);//20
            gl.glRotatef(330f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, 0.25f);//0.3
            gl.glTranslatef(0.3f, 0.0f, 0.0f);
            gl.glRotatef(90f, 0f, 1f, 0f);
        } else {
            gl.glRotatef(90f, 1f, 0f, 0f);
            gl.glRotatef(340f, 0f, 1f, 0f);
            gl.glRotatef(330f, 1f, 0f, 0f);
            gl.glTranslatef(0.0f, 0.0f, 0.42f);
        }
        draw_torus(gl, 0.04f, 0.045f, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, -0.42f);
        gl.glTranslatef(0.0f, 0.0f, 0.5f);
        glu.gluSphere(q, WIDTH_HAND, SLICES, STACKS);

        if (caminar) {
            gl.glRotatef(-90f, 0f, 0f, 1f);
            gl.glRotatef(-35f, 1f, 0f, 0f);
        } else if (cintura) {
            gl.glRotatef(130f, 0f, 0f, 1f);
        }

        //Dedo 1
        gl.glTranslatef(-0.02f, 0.03f, 0.0f);
        gl.glRotatef(10f, 0f, 0f, 1f);//10 grados dif
        gl.glRotatef(20f, 1f, 0f, 0f);//15 grados
        gl.glTranslatef(-0.05f, 0.0f, 0.06f);
        gl.glRotatef(345f, 0f, 1f, 0f);
        glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.09f);
        glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        //Dedo 2
        gl.glRotatef(25f, 0f, 1f, 0f);
        gl.glTranslatef(0.10f, 0.0f, -0.07f);
        glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.1f);
        glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        //Dedo 3
        gl.glRotatef(35f, 0f, 1f, 0f);
        gl.glTranslatef(0.125f, 0.0f, -0.08f);
        glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.1f);
        glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        //Dedo pulgar
        gl.glTranslatef(-0.07f, 0.0f, -0.21f);
        gl.glRotatef(270f, 0f, 1f, 0f);
        glu.gluCylinder(q, WIDTH_FINGERS, WIDTH_FINGERS, HEIGHT_FINGERS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.1f);
        glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Pantalones(GL gl, GLU glu, boolean izquierda, boolean derecha, boolean agacharse)
    {
        //Creamos los shorts
        set_red_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.1f, 0.0f);
        double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_SHORTS, 100, 100);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Creamos las partes de los pantalones
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.36f, 0.05f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        if (agacharse) {
            gl.glTranslatef(0.0f, 0.0f, 0.04f);
            gl.glRotatef(-35f, 1f, 0f, 0f);
        }
        if (izquierda) {
            gl.glRotatef(-25f, 1f, 0f, 0f);
        }
        glu.gluCylinder(q, TOP_SHORT_LEGS, BOTTOM_SHORT_LEGS, HEIGHT_SHORT_LEGS, SLICES, STACKS);//Cilindro Vertical Blanco 
        gl.glTranslatef(0.0f, 0.0f, 0.198f);//Ajusta la posición de la base
        glu.gluDisk(q, 0f, BOTTOM_WHITE_STRAW, SLICES, STACKS);//Pinta la base del cilindro
        gl.glTranslatef(0.25f, 0.0f, -0.198f);
        if (izquierda) {
            gl.glRotatef(25f, 1f, 0f, 0f);
        } else if (derecha) {
            gl.glRotatef(-25f, 1f, 0f, 0f);
        }
        glu.gluCylinder(q, TOP_SHORT_LEGS, BOTTOM_SHORT_LEGS, HEIGHT_SHORT_LEGS, SLICES, STACKS);//Cilindro Vertical Blanco 
        gl.glTranslatef(0.0f, 0.0f, 0.198f);//Ajusta la posición de la base
        glu.gluDisk(q, 0f, BOTTOM_WHITE_STRAW, SLICES, STACKS);//Pinta la base del cilindro
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Pierna_Izquierda(GL gl, GLU glu)
    {
        //Creamos las piernas
        set_white_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.55f, 0.05f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.25f);//Ajusta la posición de la base
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);//Pinta la base del cilindro
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Pierna_Derecha(GL gl, GLU glu)
    {
        //Creamos las piernas
        set_white_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.1f, -0.55f, 0.05f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.25f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Zapato_Izquierdo(GL gl, GLU glu)
    {
        //Creamos las donas de los zapatos
        set_red_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.8f, 0.05f);
        gl.glRotatef(93f, 1f, 0f, 0f);
        draw_torus(gl, 0.08f, 0.035f, SLICES, STACKS);
        gl.glPopMatrix();

        //Creamos los zapatos
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        double[] cutplane = new double[]{0.0f, 1.0f, 0.0f, 0.55 * WIDTH_BACK_OF_SHOES};
        //Primeras esferas
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_BACK_OF_SHOES, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Primeras suelas
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        gl.glTranslatef(0.0f, -0.04f, 0.0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_BACK_OF_SHOES_SOLE, WIDTH_BACK_OF_SHOES_SOLE, HEIGHT_BACK_OF_SHOES, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.04f);
        glu.gluDisk(q, 0f, WIDTH_BACK_OF_SHOES_SOLE, SLICES, STACKS);
        gl.glPopMatrix();

        //Segundas esferas
        set_red_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.9f, 0.35f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, WIDTH_FRONT_OF_SHOES, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Segundas suelas
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        gl.glTranslatef(0.0f, -0.04f, 0.30f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_FRONT_OF_SHOES_SOLE, WIDTH_FRONT_OF_SHOES_SOLE, HEIGHT_FRONT_OF_SHOES, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.04f);
        glu.gluDisk(q, 0f, WIDTH_FRONT_OF_SHOES_SOLE, SLICES, STACKS);
        gl.glPopMatrix();

        //Unión de los zapatos
        set_red_material(gl);
        cutplane[3] = 0.19 * WIDTH_BACK_OF_SHOES;//18
        gl.glPushMatrix();
        gl.glTranslatef(-0.15f, -0.93f, 0.09f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluCylinder(q, WIDTH_SOLE_BACK, WIDTH_SOLE_FRONT, HEIGHT_SOLE, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Unión de las suelas
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glRotatef(355f, 0f, 1f, 0f);
        gl.glTranslatef(-0.13f, -0.95f, 0.33f);
        gl.glScalef(-0.1f, -0.033f, -0.23f);
        box(gl);
        gl.glRotatef(20f, 0f, 1f, 0f);
        gl.glTranslatef(-1.0f, 0.0f, -0.2f);
        box(gl);
        gl.glPopMatrix();
        set_white_material(gl);
    }

    public void dibujar_Zapato_Derecho(GL gl, GLU glu)
    {
        //Creamos las donas de los zapatos
        gl.glPushMatrix();
        set_red_material(gl);
        gl.glTranslatef(-0.15f, -0.8f, 0.05f);
        gl.glRotatef(93f, 1f, 0f, 0f);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        draw_torus(gl, 0.08f, 0.035f, SLICES, STACKS);
        gl.glPopMatrix();

        //Creamos los zapatos
        gl.glPushMatrix();
        set_red_material(gl);
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        double[] cutplane = new double[]{0.0f, 1.0f, 0.0f, 0.55 * WIDTH_BACK_OF_SHOES};
        //Primeras esferas
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glu.gluSphere(q, WIDTH_BACK_OF_SHOES, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Primeras suelas
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        gl.glTranslatef(0.0f, -0.04f, 0.0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glu.gluCylinder(q, WIDTH_BACK_OF_SHOES_SOLE, WIDTH_BACK_OF_SHOES_SOLE, HEIGHT_BACK_OF_SHOES, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.04f);
        glu.gluDisk(q, 0f, WIDTH_BACK_OF_SHOES_SOLE, SLICES, STACKS);
        gl.glPopMatrix();

        //Segundas esferas
        gl.glPushMatrix();
        set_red_material(gl);
        gl.glTranslatef(-0.15f, -0.9f, 0.35f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glu.gluSphere(q, WIDTH_FRONT_OF_SHOES, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Segundas suelas
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(-0.15f, -0.9f, 0.05f);
        gl.glTranslatef(0.0f, -0.04f, 0.30f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glu.gluCylinder(q, WIDTH_FRONT_OF_SHOES_SOLE, WIDTH_FRONT_OF_SHOES_SOLE, HEIGHT_FRONT_OF_SHOES, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, 0.04f);
        glu.gluDisk(q, 0f, WIDTH_FRONT_OF_SHOES_SOLE, SLICES, STACKS);
        gl.glPopMatrix();

        //Unión de los zapatos
        cutplane[3] = 0.19 * WIDTH_BACK_OF_SHOES;//18
        gl.glPushMatrix();
        set_red_material(gl);
        gl.glTranslatef(-0.15f, -0.93f, 0.09f);
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glu.gluCylinder(q, WIDTH_SOLE_BACK, WIDTH_SOLE_FRONT, HEIGHT_SOLE, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        gl.glPopMatrix();

        //Unión de las suelas
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glRotatef(355f, 0f, 1f, 0f);
        gl.glTranslatef(-0.13f, -0.95f, 0.33f);
        gl.glScalef(-0.1f, -0.033f, -0.23f);
        gl.glTranslatef(-2.62f, 0.0f, 0.0f);
        box(gl);
        gl.glTranslatef(2.62f, 0.0f, 0.0f);
        gl.glRotatef(20f, 0f, 1f, 0f);
        gl.glTranslatef(-3.42f, 0.0f, -1.0f);
        box(gl);
        gl.glPopMatrix();
        set_white_material(gl);
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

    public void set_brown_material(GL gl)
    {
        float[] mat_ambient = {0.35294117647f, 0.15294117647f, 0.16078431372f, 0.2f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 15.0f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_gray_material(GL gl)
    {

        float mat_ambient[] = {0.66274509803f, 0.66274509803f, 0.66274509803f, 1.0f};
        float[] mat_diffuse = {0.66274509803f, 0.66274509803f, 0.66274509803f, 1.0f};
        float mat_specular[] = {0.66274509803f, 0.66274509803f, 0.66274509803f, 1.0f};
        float shine = 28f;

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

        float mat_ambient[] = {0.2f, 0.2f, 0.6f, 1.0f};
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

        float mat_ambient[] = {0.8f, 0.8f, 0.8f, 0.5f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 0.5f};
        float mat_specular[] = {0.7f, 0.7f, 0.7f, 0.5f};
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

    public void box(GL gl)
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

    public void fondo(GL gl, GLU glu, Texture t)
    {
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D, m);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2d(0.0f, 1.0f);
        gl.glVertex3d(-6.0f, -6.0f, -6.0f);

        gl.glTexCoord2d(1.0f, 1.0f);
        gl.glVertex3d(6.0f, -6.0f, -6.0f);

        gl.glTexCoord2d(1.0f, 0.0f);
        gl.glVertex3d(6.0f, 6.0f, -6.0f);

        gl.glTexCoord2d(0.0f, 0.0f);
        gl.glVertex3d(-6.0f, 6.0f, -6.0f);

        gl.glEnd();
        gl.glDisable(GL.GL_TEXTURE_2D);
        gl.glFlush();
    }

    public void cambioInstruccion(boolean caminar, boolean saltar, boolean agachar,
            boolean apuntar, boolean bailar, boolean mCintura, boolean mCara)
    {
        if (Cuphead.cam != caminar || Cuphead.salt != saltar || Cuphead.agach != agachar
                || Cuphead.apunt != apuntar || Cuphead.bail != bailar || Cuphead.mCint != mCintura
                || Cuphead.mCar != mCara) {
            Cuphead.cam = caminar;
            Cuphead.salt = saltar;
            Cuphead.agach = agachar;
            Cuphead.apunt = apuntar;
            Cuphead.bail = bailar;
            Cuphead.mCint = mCintura;
            Cuphead.mCar = mCara;
            Cuphead.mvt = 0;
        }
    }

    public boolean pieIzq()
    {
        return Cuphead.pieIzq;
    }

    public boolean pieDer()
    {
        return Cuphead.pieDer;
    }
}
