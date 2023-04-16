/*
* Está parte de código es la que pintaba la textura frontal, pero no es visible por el ángulo de la cámara, asi que no es necesaria de momento
*/
        //Dibujamos la texturas de la feria
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tFrente2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tFrente3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tFrente4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tFrente5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tFrente6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tFrente7);
        } else {
            cuphead.fondo(gl, glu, tFrente1);
        }
        gl.glPopMatrix();
        gl.glFlush();
        
/*
* Está parte de código es la que pintaba la textura del cielo y su movimiento, pero no es visible por el ángulo de la cámara, asi que no es necesaria de momento
*/
        
        //Dibujamos la texturas del cielo 1
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, parte1);
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, -((float) velocidadP1 / 10), 0.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tTecho2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tTecho3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tTecho4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tTecho5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tTecho6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tTecho7);
        } else {
            cuphead.fondo(gl, glu, tTecho1);
        }
        gl.glPopMatrix();
        gl.glFlush();

        //Dibujamos la texturas del cielo 2
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.0f);
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(0.0f, 12.0f - ((float) velocidadP2 / 10), 0.0f);
        if (keys['2']) {
            cuphead.fondo(gl, glu, tTecho2);
        } else if (keys['3']) {
            cuphead.fondo(gl, glu, tTecho3);
        } else if (keys['4']) {
            cuphead.fondo(gl, glu, tTecho4);
        } else if (keys['5']) {
            cuphead.fondo(gl, glu, tTecho5);
        } else if (keys['6']) {
            cuphead.fondo(gl, glu, tTecho6);
        } else if (keys['7']) {
            cuphead.fondo(gl, glu, tTecho7);
        } else {
            cuphead.fondo(gl, glu, tTecho1);
        }
        gl.glPopMatrix();
        gl.glFlush();
 
        
        
