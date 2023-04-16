//Parte de variables locales
    //Texture
    Texture tAtras1, tFrente1, tDerecha1, TIzquierda1, tTecho1, tPiso1,
            tAtras2, tFrente2, tDerecha2, TIzquierda2, tTecho2, tPiso2,
            tAtras3, tFrente3, tDerecha3, TIzquierda3, tTecho3, tPiso3,
            tAtras4, tFrente4, tDerecha4, TIzquierda4, tTecho4, tPiso4,
            tAtras5, tFrente5, tDerecha5, TIzquierda5, tTecho5, tPiso5,
            tAtras6, tFrente6, tDerecha6, TIzquierda6, tTecho6, tPiso6,
            tAtras7, tFrente7, tDerecha7, TIzquierda7, tTecho7, tPiso7;




//Parte de de init
//Escenario 1
            File iFrente = new File("src/Fondos/feria.jpg");
            tFrente1 = TextureIO.newTexture(iFrente, true);
            File iTecho = new File("src/Fondos/cielo.jpg");
            tTecho1 = TextureIO.newTexture(iTecho, true);

//Escenario 2
            iFrente = new File("src/Fondos/minecraftFrente.jpg");
            tFrente2 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/minecraftCielo.jpg");
            tTecho2 = TextureIO.newTexture(iTecho, true);            

//Escenario 3
            iFrente = new File("src/Fondos/feriaFrente.jpg");
            tFrente3 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/cieloNoche.jpg");
            tTecho3 = TextureIO.newTexture(iTecho, true);

//Escenario 4
            iFrente = new File("src/Fondos/atraccion.jpg");
            tFrente4 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tTecho4 = TextureIO.newTexture(iTecho, true);

//Escenario 5
            iFrente = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tFrente5 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/cieloCiudad.jpg");
            tTecho5 = TextureIO.newTexture(iTecho, true);

//Escenario 6
            iFrente = new File("src/Fondos/frenteCarretera.jpg");
            tFrente6 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/cieloCarretera.jpg");
            tTecho6 = TextureIO.newTexture(iTecho, true);

//Escenario 7
            iFrente = new File("src/Fondos/desiertoFrente.jpg");
            tFrente7 = TextureIO.newTexture(iFrente, true);
            iTecho = new File("src/Fondos/desiertoCielo.jpg");
            tTecho7 = TextureIO.newTexture(iTecho, true);




//Parte de display
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
 
        
        
