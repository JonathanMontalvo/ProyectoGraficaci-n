/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import static org.yourorghere.Main.cambiarEspacio;

/**
 *
 * @author Bryan Hernández Vázquez
 */
public class DrawPingu
{

    //precision and global variables
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static int mvt = 0;
    private static boolean cam = false;
    private static boolean salt = false;
    private static boolean pieDer = false;
    private static boolean pieIzq = false;

    //para cara
    private static final float HEIGHT_BODY = 1.1f;
    private static final float TOP_BODY = 0.5f;
    private static final float BOTTOM_BODY = 0.50f;
    private static final float HEIGHT_ARM = 0.22f;
    private static final float TOP_ARM = 0.28f;
    private static final float BOTTOM_ARM = 0.28f;
    private static final float WIDTH_HEAD = 0.7f;
    private static final float WIDTH_BELLY = 0.47f;
    private static final float WIDTH_EYES = 0.30f;
    private static final float WIDTH_PUPILS = 0.19f;
    private static final float WIDTH_OPEN_MOUTH = 0.32f;
    private static final float HEIGHT_FEET = 0.8f;
    private static final float HEIGHT_LEGS = 0.18f;
    private static final float WIDTH_LEGS = 0.185f;
    private static final float TOP_FEET = 0.5f;
    private static final float BOTTOM_FEET = 0.50f;
    private static final float WIDTH_SHOES = 0.45f;
    private static final float HEIGHT_SHOES = 0.07f;
    private static final float WIDTH_ARMS = 0.35f;
    private static final float HEIGHT_ARMS = 0.9f;

    public DrawPingu()
    {

    }

    public void draw_pingu(GL gl, boolean walk, boolean jump, boolean levanta,
            boolean agachar, boolean flex, boolean baile, boolean mov,
            boolean angry, boolean notnot, boolean sorprendido, boolean guinio,
            boolean mimido, boolean ojos2, boolean ojos3, boolean eliminado, boolean quieto)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //Cuphead only jumps once
        if (DrawPingu.mvt >= 40 && jump) {
            cambiarEspacio(false);
        }

        //Pingu is walking
        if (walk && mvt % 32 + 16 > 31) {
            DrawPingu.pieDer = true;
            DrawPingu.pieIzq = false;
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, 'A', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, 'A', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, 'A', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (walk && mvt % 32 + 16 <= 31) {
            DrawPingu.pieIzq = true;
            DrawPingu.pieDer = false;
            dibujar_pierna(gl, glu, 'A', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, 'A', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, 'A', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } //Pingu is jumping
        else if (jump && mvt % 80 + 40 <= 79) {
            DrawPingu.pieIzq = false;
            DrawPingu.pieDer = false;
            gl.glTranslatef(0f, 1.25f, 0f);
            dibujar_pierna(gl, glu, 'S', true);
            dibujar_pierna(gl, glu, 'S', false);
            dibujar_patas(gl, glu, 'S', true);
            dibujar_patas(gl, glu, 'S', false);
            dibujar_brazos(gl, glu, 'S', true);
            dibujar_brazos(gl, glu, 'S', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } //Pingu is normal
        else if (levanta && mvt % 20 + 10 <= 20) ///&& mvt % 30 + 10 == 30
        {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, 'D', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (agachar && mvt % 20 + 10 <= 20) {
            gl.glTranslatef(0f, -0.35f, 0f);
            gl.glRotatef(30, 100f, 0f, 0f);
            dibujar_pierna(gl, glu, 'F', true);
            dibujar_pierna(gl, glu, 'F', false);
            dibujar_patas(gl, glu, 'F', true);
            dibujar_patas(gl, glu, 'F', false);
            dibujar_brazos(gl, glu, 'F', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (flex && mvt % 20 + 10 <= 20) {
            dibujar_pierna(gl, glu, 'G', true);
            dibujar_pierna(gl, glu, 'G', false);
            dibujar_patas(gl, glu, 'G', true);
            dibujar_patas(gl, glu, 'G', false);
            dibujar_brazos(gl, glu, 'G', true);
            dibujar_brazos(gl, glu, 'G', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (baile && mvt % 32 + 16 <= 31) {
            dibujar_pierna(gl, glu, 'H', true);
            dibujar_pierna(gl, glu, 'H', false);
            dibujar_patas(gl, glu, 'H', true);
            dibujar_patas(gl, glu, 'H', false);
            dibujar_brazos(gl, glu, 'H', true);
            dibujar_brazos(gl, glu, 'H', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (mov && mvt % 20 + 10 <= 20) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, 'J', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else if (angry) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false, false);
        } else if (notnot && mvt % 20 + 10 <= 20) {
            dibujar_Cabeza(gl, glu, false, true, false, false, false, false, false);
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
        } else if (sorprendido) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, true, false, false, false, false);
        } else if (guinio && mvt % 20 + 10 <= 20) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, true, false, false, false);
        } else if (mimido) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, true, false, false);

        } else if (ojos2) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, true, false);
        } else if (ojos3 && mvt % 20 + 10 <= 20) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, true);
        } else if (eliminado && mvt % 80 + 40 <= 79) {
            gl.glTranslatef(0f, -0.35f, 0f);
            gl.glRotatef(30, 100f, 0f, 0f);
            dibujar_pierna(gl, glu, 'F', true);
            dibujar_pierna(gl, glu, 'F', false);
            dibujar_patas(gl, glu, 'F', true);
            dibujar_patas(gl, glu, 'F', false);
            dibujar_brazos(gl, glu, 'F', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, true, false, false, false, false, false, false);
        } else if (quieto) {
            dibujar_pierna(gl, glu, ' ', true);
            dibujar_pierna(gl, glu, ' ', false);
            dibujar_patas(gl, glu, ' ', true);
            dibujar_patas(gl, glu, ' ', false);
            dibujar_brazos(gl, glu, ' ', true);
            dibujar_brazos(gl, glu, ' ', false);
            dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
        } else {
            if (mvt % 32 + 16 > 31) {
                DrawPingu.pieDer = true;
                DrawPingu.pieIzq = false;
                dibujar_pierna(gl, glu, 'A', true);
                dibujar_pierna(gl, glu, ' ', false);
                dibujar_patas(gl, glu, 'A', true);
                dibujar_patas(gl, glu, ' ', false);
                dibujar_brazos(gl, glu, 'A', true);
                dibujar_brazos(gl, glu, ' ', false);
                dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
            } else if (mvt % 32 + 16 <= 31) {
                DrawPingu.pieIzq = true;
                DrawPingu.pieDer = false;
                dibujar_pierna(gl, glu, ' ', true);
                dibujar_pierna(gl, glu, 'A', false);
                dibujar_patas(gl, glu, ' ', true);
                dibujar_patas(gl, glu, 'A', false);
                dibujar_brazos(gl, glu, ' ', true);
                dibujar_brazos(gl, glu, 'A', false);
                dibujar_Cabeza(gl, glu, false, false, false, false, false, false, false);
            }
        }
        dibujar_hombro(gl, glu);
        mvt++;
        dibujar_cuerpo(gl, glu);
        dibujar_sombrero(gl, glu);
    }

    public void dibujar_Cabeza(GL gl, GLU glu, boolean angry, boolean notnot, boolean somprendido, boolean guinio, boolean mimido, boolean ojos2, boolean ojos3)
    {
//Creamos la cabezare
        set_skin_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, 0f);
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();
        if (guinio) {
            set_eyes_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.30f, 0.65f, 0.288f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glPopMatrix();
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(-0.38f, 0.70f, 0.385f);
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glPopMatrix();
            double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
            set_black_material(gl);
            cutplane[0] = -1.0f;
            cutplane[1] = 0.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.40 * 0.18;
            gl.glPushMatrix();
            gl.glTranslatef(0.34f, 0.6f, 0.48f);
            gl.glRotatef(-90f, -1.0f, -0.9f, 2.7f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (mimido) {
            set_eyes_material(gl);
            double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
            set_black_material(gl);
            cutplane[0] = -1.0f;
            cutplane[1] = 0.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.40 * 0.18;
            gl.glPushMatrix();
            gl.glTranslatef(0.34f, 0.6f, 0.48f);
            gl.glRotatef(-90f, -1.0f, -0.9f, 2.7f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            //segundo Ojo
            gl.glPushMatrix();
            gl.glTranslatef(-0.34f, 0.6f, 0.48f);
            gl.glRotatef(-90f, -1.0f, -0.9f, 2.7f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        } else if (ojos2) {
            //Dibujamos los ojos
            set_eyes_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.30f, 0.65f, 0.288f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.60f, 0.0f, 0.0f);//mover para la izquierda o derecha ,altura,Profundidad
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glPopMatrix();
            //Dibujamos la pupila de todos
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(-0.36f, 0.70f, 0.385f);
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glTranslatef(0.74f, 0.01f, -0.016f);//mover para la izquierda o derecha ,altura,Profundidad
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glPopMatrix();
        } else if (ojos3) {
            set_eyes_material(gl);
            double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
            set_black_material(gl);
            cutplane[0] = -1.0f;
            cutplane[1] = 0.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.40 * 0.18;
            gl.glPushMatrix();
            gl.glTranslatef(-0.34f, 0.6f, 0.48f);
            gl.glRotatef(-90f, -1.0f, -0.9f, 2.7f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            //
            set_eyes_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.29f, 0.65f, 0.296f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glPopMatrix();
            //Pupila
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(0.39f, 0.69f, 0.40f);//mover para la izquierda o derecha ,altura,Profundidad
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glPopMatrix();
        } else {
            //Dibujamos los ojos
            set_eyes_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(-0.30f, 0.65f, 0.288f);
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glTranslatef(0.60f, 0.0f, 0.0f);//mover para la izquierda o derecha ,altura,Profundidad
            glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
            gl.glPopMatrix();
            //Dibujamos la pupila de todos
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(-0.38f, 0.70f, 0.385f);
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glTranslatef(0.77f, 0.0f, 0.0f);//mover para la izquierda o derecha ,altura,Profundidad
            glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
            gl.glPopMatrix();
        }
        //Dibujamos la boca
        gl.glPushMatrix();
        set_red_material(gl);
        gl.glTranslatef(0.0f, 0.5f, 0.630f);
        glu.gluCylinder(q, WIDTH_LEGS + 0.14f, 0.0f, HEIGHT_LEGS + 0.4f, SLICES, STACKS);
        gl.glPopMatrix();
        if (angry == true) {
            //Rigth
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(0.28f, 0.75f, 0.520f);
            gl.glRotatef(45f, 0f, 0f, 1f);
            gl.glScalef(0.2f, 0.1f, 0.1f);
            box(gl);
            gl.glPopMatrix();
            //Left
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(-0.24f, 0.80f, 0.520f);
            gl.glRotatef(135f, 0f, 0f, 1f);
            gl.glScalef(0.2f, 0.1f, 0.1f);
            box(gl);
            gl.glPopMatrix();
        }
        if (notnot) {
            gl.glPushMatrix();
            set_red_material(gl);
            gl.glTranslatef(0.0f, 0.5f, 0.600f);
            glu.gluCylinder(q, WIDTH_LEGS + 0.14f, WIDTH_LEGS + 0.19f, HEIGHT_LEGS + 0.6f, SLICES, STACKS);
            gl.glPopMatrix();
            gl.glPushMatrix();
            set_black_material(gl);
            gl.glTranslatef(0.0f, 0.5f, 1.36f);
            glu.gluDisk(q, 0f, WIDTH_LEGS + 0.14F, SLICES, STACKS);
            gl.glPopMatrix();
        }
        if (somprendido) {
            double[] cutplane = new double[]{0.0f, -1.0f, 0.0f, 0.0f};
            set_black_material(gl);
            cutplane[0] = -1.0f;
            cutplane[1] = 0.0f;
            cutplane[2] = 0.0f;
            cutplane[3] = 0.40 * 0.18;
            //Ceja izquierda
            gl.glPushMatrix();
            gl.glTranslatef(-0.46f, 0.74f, 0.42f);
            gl.glRotatef(-96f, 0.0f, 0.0f, 2.0f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
            //Ceja derecha
            gl.glPushMatrix();
            gl.glTranslatef(0.465f, 0.74f, 0.42f);
            gl.glRotatef(-120f, 0.0f, 0.0f, 2.0f);//grados,x,y,z
            gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
            gl.glEnable(GL.GL_CLIP_PLANE2);
            draw_torus(gl, 0.19f, 0.080f, SLICES, STACKS);
            gl.glDisable(GL.GL_CLIP_PLANE2);
            gl.glPopMatrix();
        }
    }

    public void dibujar_pierna(GL gl, GLU glu, char c, boolean left)
    {
        gl.glPushMatrix();
        //we orientate axes if stan is jumping or is walking
        if (c == 'A') {
            gl.glTranslatef(0f, -0.18f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'S') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }
        if (c == 'F') {
            gl.glTranslatef(0f, -0.18f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'G') {
            gl.glTranslatef(0f, -0.20f, -0.50f);
            if (left) {
                gl.glRotatef(50, -100f, -100f, 0f);
            } else {
                gl.glRotatef(50, -100f, 100f, 0f);
            }
        }
        if (c == 'H') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -120f, 0f);
            } else {
                gl.glRotatef(30, -100f, 120f, 0f);
            }
        }
        if (c == 'J') {

        }
        //we create legs
        set_orange_material(gl);
        gl.glPushMatrix();
        if (left) {
            gl.glTranslatef(-0.22f, -1.20f, 0f);
        } else {
            gl.glTranslatef(0.22f, -1.20f, 0f);
        }
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    public void dibujar_patas(GL gl, GLU glu, char c, boolean left)
    {
        //        //we create feet
        set_orange_material(gl);
        gl.glPushMatrix();
        if (c == 'A') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'S') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }
        if (c == 'F') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'G') {
            gl.glTranslatef(0f, -0.22f, -0.59f);
            if (left) {
                gl.glRotatef(60, -100f, -100f, 0f);
            } else {
                gl.glRotatef(60, -100f, 100f, 0f);
            }
        }
        if (c == 'H') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }
        if (left) {
            gl.glTranslatef(-0.03f, -1.52f, -0.22f);
            gl.glScalef(-WIDTH_SHOES, HEIGHT_SHOES + 0.09f, 0.9f);
        } else {
            gl.glTranslatef(-0.005f, -1.52f, -0.22f);
            gl.glScalef(WIDTH_SHOES, HEIGHT_SHOES + 0.09f, 0.9f);
        }
        box(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glPopMatrix();
    }

    public void dibujar_hombro(GL gl, GLU glu)
    {
        set_skin_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.32f, -0.30f, -0.10f);
        gl.glRotatef(590f, -100f, 95f, 90f);
        glu.gluCylinder(q, TOP_ARM, BOTTOM_ARM, HEIGHT_ARM + 0.16f, SLICES, STACKS);
        gl.glPopMatrix();
        //Hombro derecho
        gl.glPushMatrix();
        gl.glTranslatef(0.70f, -0.30f, -0.02f);
        gl.glRotatef(600f, -90f, 100f, 90f);  ///primera inclinacion, segunda inclinacion 
        glu.gluCylinder(q, TOP_ARM, BOTTOM_ARM, HEIGHT_ARM + 0.22f, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void dibujar_brazos(GL gl, GLU glu, char c, boolean left)
    {
        //set_white_head_material(gl);
        set_skin_material(gl);
        gl.glPushMatrix();
        if (c == 'A') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'S') {
            gl.glTranslatef(0f, -0.01f, -0.1f);
            if (left) {
                gl.glRotatef(25, -100f, -100f, 0f);
            } else {
                gl.glRotatef(-10, -100f, 120f, 0f);
            }
        }
        if (c == 'D') {
            gl.glTranslatef(-0.087f, -0.58f, -0.1f);
            if (left) {
                gl.glRotatef(180, 100f, 0f, 0f);//,rotacion,lado,horizontal,enfrente
            } else {
                gl.glRotatef(-10, -100f, 120f, 0f);
            }
        }
        if (c == 'F') {
            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(65, -100f, 0f, 0f);
        }
        if (c == 'G') {
            if (left) {
                gl.glTranslatef(0f, -0.2f, -0.45f);
                gl.glRotatef(90, -100f, 0f, 0f);
            } else {
                gl.glTranslatef(0f, -0.2f, 0.3f);
                gl.glRotatef(-55, -100f, 0f, 0f);
            }
        }
        if (c == 'H') {
            if (left) {
                gl.glTranslatef(0f, -0.2f, -0.45f);
                gl.glRotatef(90, -100f, 15f, 0f);
            } else {
                gl.glTranslatef(0f, -0.2f, -0.3f);
                gl.glRotatef(90, -100f, -15f, 0f);
            }
        }
        if (c == 'J') {
            gl.glTranslatef(0.087f, 0.58f, -0.1f);
            if (left) {
                gl.glRotatef(180, 100f, 0f, 0f);//,rotacion,lado,horizontal,enfrente
            } else {
                gl.glRotatef(-10, -100f, 120f, 0f);
            }
        }
        if (left) {
            gl.glTranslatef(-0.58f, -1.05f, -0.44f);
            gl.glScalef(-WIDTH_ARMS, HEIGHT_ARMS + 0.15f, 0.84f);
        } else {
            gl.glTranslatef(0.57f, -1.05f, -0.44f);
            gl.glScalef(WIDTH_ARMS, HEIGHT_ARMS + 0.15f, 0.84f);
        }
        box(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glPopMatrix();
    }

    public void dibujar_sombrero(GL gl, GLU glu)
    {
        set_brown_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.49f, WIDTH_HEAD + 0.30f, -0.40f);
        gl.glScalef(1.05f, 1.05f, 1.0f);
        box(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        set_brown_material(gl);
        gl.glTranslatef(-1.19f, 0.50f + 0.42f, -0.80f);
        gl.glScalef(2.60f, 0.37f, 1.72f);// del otro lado,altura,ATRAS
        box(gl);
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    public void dibujar_cuerpo(GL gl, GLU glu)
    {
        //we create pingu body
        set_skin_material(gl);
        gl.glPushMatrix();
        // gl.glTranslatef(0.0f, 0.5f, 0f);
        gl.glRotatef(90f, 600f, 0f, 0f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glPopMatrix();
        //panza
//        gl.glPushMatrix();
//        set_yellow_material(gl);
//        gl.glTranslatef(0.0f, -0.60f, 0.14f);
//        gl.glRotatef(90f, -1f, 0f, 0f);
//        glu.gluSphere(q, WIDTH_BELLY, SLICES, STACKS);
//        gl.glPopMatrix();
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

    public void set_eyes_material(GL gl)
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

    public void set_skin_material(GL gl)
    {
        float[] mat_ambient = {0.25f, 0.25f, 0.25f, 1.0f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float shine = 76.8f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
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

    public void set_yellow_material(GL gl)
    {
        float mat_ambient[] = {0.05f, 0.05f, 0.0f, 1.0f};
        float mat_diffuse[] = {0.5f, 0.5f, 0.4f, 1.0f};
        float mat_specular[] = {0.7f, 0.7f, 0.04f, 1.0f};
        float shine = 10.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_orange_material(GL gl)
    {
        float mat_ambient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_diffuse[] = {0.5f, 0.4f, 0.4f, 1.0f};
        float mat_specular[] = {0.7f, 0.04f, 0.04f, 1.0f};
        float shine = 10.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_brown_material(GL gl)
    {
        float mat_ambient[] = {0.2125f, 0.1275f, 0.054f, 1.0f};
        float mat_diffuse[] = {0.714f, 0.4284f, 0.18144f, 1.0f};
        float mat_specular[] = {0.393548f, 0.271906f, 0.166721f, 1.0f};
        float shine = 25.6f;
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

    public void cambioInstruccion(boolean caminar, boolean saltar)
    {
        if (DrawPingu.cam != caminar || DrawPingu.salt != saltar) {
            DrawPingu.cam = caminar;
            DrawPingu.salt = saltar;
            DrawPingu.mvt = 0;
        }
    }

    public boolean pieIzq()
    {
        return DrawPingu.pieIzq;
    }

    public boolean pieDer()
    {
        return DrawPingu.pieDer;
    }
}
