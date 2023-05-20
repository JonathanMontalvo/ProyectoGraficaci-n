/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author
 */
public class Menu
{

    private Texture tAtrasMenu, tFrenteMenu, tDerechaMenu, TIzquierdaMenu, tTechoMenu, tPisoMenu, tAtras2Menu, tFrente2Menu, tDerecha2Menu, TIzquierda2Menu, tTecho2Menu, tPiso2Menu,
            tAtras3Menu, tFrente3Menu, tDerecha3Menu, TIzquierda3Menu, tTecho3Menu, tPiso3Menu, tAtras4Menu, tFrente4Menu, tDerecha4Menu, TIzquierda4Menu, tTecho4Menu, tPiso4Menu,
            tAtras7Menu, tFrente7Menu, tDerecha7Menu, TIzquierda7Menu, tTecho7Menu, tPiso7Menu, tAtras5Menu, tFrente5Menu, tDerecha5Menu, TIzquierda5Menu, tTecho5Menu, tPiso5Menu,
            tAtras6Menu, tFrente6Menu, tDerecha6Menu, TIzquierda6Menu, tTecho6Menu, tPiso6Menu, tTeclaXMenu, tTeclaZMenu, tTeclaCMenu,
            tAtrasP1Menu, tFrenteP1Menu, tDerechaP1Menu, TIzquierdaP1Menu, tTechoP1Menu, tPisoP1Menu, tAtrasP2Menu, tFrenteP2Menu, tDerechaP2Menu, TIzquierdaP2Menu, tTechoP2Menu, tPisoP2Menu,
            tAtrasP3Menu, tFrenteP3Menu, tDerechaP3Menu, TIzquierdaP3Menu, tTechoP3Menu, tPisoP3Menu, tAtrasP4Menu, tFrenteP4Menu, tDerechaP4Menu, TIzquierdaP4Menu, tTechoP4Menu, tPisoP4Menu,
            tAtrasP5Menu, tFrenteP5Menu, tDerechaP5Menu, TIzquierdaP5Menu, tTechoP5Menu, tPisoP5Menu, tAtrasP6Menu, tFrenteP6Menu, tDerechaP6Menu, TIzquierdaP6Menu, tTechoP6Menu, tPisoP6Menu,
            tAtrasP7Menu, tFrenteP7Menu, tDerechaP7Menu, TIzquierdaP7Menu, tTechoP7Menu, tPisoP7Menu, tAtrasK1Menu, tFrenteK1Menu, tDerechaK1Menu, TIzquierdaK1Menu, tTechoK1Menu, tPisoK1Menu, tAtrasK2Menu, tFrenteK2Menu, tDerechaK2Menu, TIzquierdaK2Menu, tTechoK2Menu, tPisoK2Menu,
            tAtrasK3Menu, tFrenteK3Menu, tDerechaK3Menu, TIzquierdaK3Menu, tTechoK3Menu, tPisoK3Menu, tAtrasK4Menu, tFrenteK4Menu, tDerechaK4Menu, TIzquierdaK4Menu, tTechoK4Menu, tPisoK4Menu,
            tAtrasK5Menu, tFrenteK5Menu, tDerechaK5Menu, TIzquierdaK5Menu, tTechoK5Menu, tPisoK5Menu, tAtrasK6Menu, tFrenteK6Menu, tDerechaK6Menu, TIzquierdaK6Menu, tTechoK6Menu, tPisoK6Menu,
            tAtrasK7Menu, tFrenteK7Menu, tDerechaK7Menu, TIzquierdaK7Menu, tTechoK7Menu, tPisoK7Menu;

    //Menu
    private final JMenuBar jMenuBar = new JMenuBar();

    private final JMenu jMInstucciones = new JMenu();
    private final JMenu jMTransformaciones = new JMenu();
    private final JMenu jMSonido = new JMenu();
    private final JMenu jMAcerca = new JMenu();
    private final JMenuItem jMISonidoEncendido = new JMenuItem();
    private final JMenuItem jMISonidoApagado = new JMenuItem();

    private final JMenuItem jMIOriginal = new JMenuItem();
    private final JMenuItem jMITraslacion = new JMenuItem();
    private final JMenuItem jMIEscalacionAumentar = new JMenuItem();

    private static TextRenderer tituloMenu = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
    private static TextRenderer tituloNivel = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
    private static TextRenderer tituloPlay = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));

    public Menu()
    {
    }

    public void parteMain(JFrame frame)
    {

        jMInstucciones.setText("Instrucciones");
        jMenuBar.add(jMInstucciones);
        jMTransformaciones.setText("Selecciona el personaje");
        jMenuBar.add(jMTransformaciones);
        jMIOriginal.setText("Cuphead -> Presiona C");
        jMTransformaciones.add(jMIOriginal);
        jMITraslacion.setText("King Dice -> Presiona X");
        jMTransformaciones.add(jMITraslacion);
        jMIEscalacionAumentar.setText("Pingu -> Presiona Z");
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
                Main.jMIOriginalMouseClicked(aE);
            }
        });
        jMITraslacion.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent aE)
            {
                Main.jMITraslacionMouseClicked(aE);
            }
        });
        jMIEscalacionAumentar.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent aE)
            {
                Main.jMIEscalacionAumentarMouseClicked(aE);
            }
        });

        jMISonidoEncendido.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent aE)
            {
                Main.jMISonidoEncendidoMouseClicked(aE);
            }
        });

        jMISonidoApagado.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent aE)
            {
                Main.jMISonidoApagadoMouseClicked(aE);
            }
        });

        jMAcerca.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Main.acercaMouseClicked(e);
            }
        });

        jMInstucciones.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Main.jMInstruccionesMouseClicked(e);
            }
        });
        frame.setJMenuBar(jMenuBar);
    }

    public void cargarMenu(JFrame frame)
    {
        tituloMenu = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
        tituloPlay = new TextRenderer(new Font("Comic Sans MS", Font.BOLD, 42));
        frame.setTitle("Menu");
        frame.setJMenuBar(jMenuBar);
        frame.revalidate();
        frame.repaint();
    }

    public void quitarParteMain(JFrame frame, int bndKey)
    {
        switch (bndKey) {
            case 1:
                frame.setTitle("Nivel 3");
                break;
            case 2:
                frame.setTitle("Nivel 2");
                break;
            case 3:
                frame.setTitle("Nivel 1");
                break;
        }
        frame.setJMenuBar(null);
        frame.revalidate();
        frame.repaint();
    }

    public void texturasInit()
    {
        try {
            File iAtras = new File("src/Fondos/f1.jpg");
            tAtrasMenu = TextureIO.newTexture(iAtras, true);
            File iFrente = new File("src/Fondos/f1.jpg");
            tFrenteMenu = TextureIO.newTexture(iFrente, true);
            File iDerecha = new File("src/Fondos/f1.jpg");
            tDerechaMenu = TextureIO.newTexture(iDerecha, true);
            File iIzquierda = new File("src/Fondos/f1.jpg");
            TIzquierdaMenu = TextureIO.newTexture(iIzquierda, true);
            File iTecho = new File("src/Fondos/r3.jpg");
            tTechoMenu = TextureIO.newTexture(iTecho, true);
            File iPiso = new File("src/Fondos/p.jpg");
            tPisoMenu = TextureIO.newTexture(iPiso, true);
            File iAtras2 = new File("src/Fondos/f2.jpg");
            tAtras2Menu = TextureIO.newTexture(iAtras2, true);
            File iFrente2 = new File("src/Fondos/f2.jpg");
            tFrente2Menu = TextureIO.newTexture(iFrente2, true);
            File iDerecha2 = new File("src/Fondos/f2.jpg");
            tDerecha2Menu = TextureIO.newTexture(iDerecha2, true);
            File iIzquierda2 = new File("src/Fondos/f2.jpg");
            TIzquierda2Menu = TextureIO.newTexture(iIzquierda2, true);
            File iTecho2 = new File("src/Fondos/r3.jpg");
            tTecho2Menu = TextureIO.newTexture(iTecho2, true);
            File iPiso2 = new File("src/Fondos/p.jpg");
            tPiso2Menu = TextureIO.newTexture(iPiso2, true);
            File iAtras3 = new File("src/Fondos/f3.jpg");
            tAtras3Menu = TextureIO.newTexture(iAtras3, true);
            File iFrente3 = new File("src/Fondos/f3.jpg");
            tFrente3Menu = TextureIO.newTexture(iFrente3, true);
            File iDerecha3 = new File("src/Fondos/f3.jpg");
            tDerecha3Menu = TextureIO.newTexture(iDerecha3, true);
            File iIzquierda3 = new File("src/Fondos/f3.jpg");
            TIzquierda3Menu = TextureIO.newTexture(iIzquierda3, true);
            File iTecho3 = new File("src/Fondos/r3.jpg");
            tTecho3Menu = TextureIO.newTexture(iTecho3, true);
            File iPiso3 = new File("src/Fondos/p.jpg");
            tPiso3Menu = TextureIO.newTexture(iPiso3, true);
            File iAtras4 = new File("src/Fondos/e.jpg");
            tAtras4Menu = TextureIO.newTexture(iAtras4, true);
            File iFrente4 = new File("src/Fondos/e.jpg");
            tFrente4Menu = TextureIO.newTexture(iFrente4, true);
            File iDerecha4 = new File("src/Fondos/e.jpg");
            tDerecha4Menu = TextureIO.newTexture(iDerecha4, true);
            File iIzquierda4 = new File("src/Fondos/e.jpg");
            TIzquierda4Menu = TextureIO.newTexture(iIzquierda4, true);
            File iTecho4 = new File("src/Fondos/r3.jpg");
            tTecho4Menu = TextureIO.newTexture(iTecho4, true);
            File iPiso4 = new File("src/Fondos/p.jpg");
            tPiso4Menu = TextureIO.newTexture(iPiso4, true);
            File iAtras5 = new File("src/Fondos/f4.jpg");
            tAtras5Menu = TextureIO.newTexture(iAtras5, true);
            File iFrente5 = new File("src/Fondos/f4.jpg");
            tFrente5Menu = TextureIO.newTexture(iFrente5, true);
            File iDerecha5 = new File("src/Fondos/f4.jpg");
            tDerecha5Menu = TextureIO.newTexture(iDerecha5, true);
            File iIzquierda5 = new File("src/Fondos/f4.jpg");
            TIzquierda5Menu = TextureIO.newTexture(iIzquierda5, true);
            File iTecho5 = new File("src/Fondos/r3.jpg");
            tTecho5Menu = TextureIO.newTexture(iTecho, true);
            File iPiso5 = new File("src/Fondos/p.jpg");
            tPiso5Menu = TextureIO.newTexture(iPiso, true);
            File iAtras6 = new File("src/Fondos/f5.jpg");
            tAtras6Menu = TextureIO.newTexture(iAtras6, true);
            File iFrente6 = new File("src/Fondos/f5.jpg");
            tFrente6Menu = TextureIO.newTexture(iFrente6, true);
            File iDerecha6 = new File("src/Fondos/f5.jpg");
            tDerecha6Menu = TextureIO.newTexture(iDerecha6, true);
            File iIzquierda6 = new File("src/Fondos/f5.jpg");
            TIzquierda6Menu = TextureIO.newTexture(iIzquierda6, true);
            File iTecho6 = new File("src/Fondos/r3.jpg");
            tTecho6Menu = TextureIO.newTexture(iTecho6, true);
            File iPiso6 = new File("src/Fondos/p.jpg");
            tPiso6Menu = TextureIO.newTexture(iPiso6, true);
            File iAtras7 = new File("src/Fondos/c.jpg");
            tAtras7Menu = TextureIO.newTexture(iAtras7, true);
            File iFrente7 = new File("src/Fondos/c.jpg");
            tFrente7Menu = TextureIO.newTexture(iFrente7, true);
            File iDerecha7 = new File("src/Fondos/c.jpg");
            tDerecha7Menu = TextureIO.newTexture(iDerecha7, true);
            File iIzquierda7 = new File("src/Fondos/c.jpg");
            TIzquierda7Menu = TextureIO.newTexture(iIzquierda7, true);
            File iTecho7 = new File("src/Fondos/r3.jpg");
            tTecho7Menu = TextureIO.newTexture(iTecho7, true);
            File iPiso7 = new File("src/Fondos/p.jpg");
            tPiso7Menu = TextureIO.newTexture(iPiso7, true);

            //Pingu
            //Escenario Pingu
            File iAtrasP = new File("src/Fondos/i1.jpg");
            File iFrenteP = new File("src/Fondos/i6.jpg");
            File iDerechaP = new File("src/Fondos/i3.jpg");
            File iIzquierdaP = new File("src/Fondos/i5.jpg");
            File iTechoP = new File("src/Fondos/i4.jpg");
            File iPisoP = new File("src/Fondos/i2.jpg");
            tAtrasP1Menu = TextureIO.newTexture(iAtrasP, true);
            tFrenteP1Menu = TextureIO.newTexture(iFrenteP, true);
            tDerechaP1Menu = TextureIO.newTexture(iDerechaP, true);
            TIzquierdaP1Menu = TextureIO.newTexture(iIzquierdaP, true);
            tTechoP1Menu = TextureIO.newTexture(iTechoP, true);
            tPisoP1Menu = TextureIO.newTexture(iPisoP, true);
            //2
            iAtrasP = new File("src/Fondos/i8.jpg");
            iFrenteP = new File("src/Fondos/i9.jpg");
            iDerechaP = new File("src/Fondos/i10.jpg");
            iIzquierdaP = new File("src/Fondos/i11.jpg");
            iTechoP = new File("src/Fondos/i4.jpg");
            iPisoP = new File("src/Fondos/i12.jpg");
            tAtrasP2Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP2Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP2Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP2Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP2Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP2Menu = TextureIO.newTexture(iPisoP, false);
            //3
            iAtrasP = new File("src/Fondos/i13.jpg");
            iFrenteP = new File("src/Fondos/i14.jpg");
            iDerechaP = new File("src/Fondos/i15.jpg");
            iIzquierdaP = new File("src/Fondos/i16.jpg");
            iTechoP = new File("src/Fondos/i18.jpg");
            iPisoP = new File("src/Fondos/i17.jpg");
            tAtrasP3Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP3Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP3Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP3Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP3Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP3Menu = TextureIO.newTexture(iPisoP, false);
            ///4
            iAtrasP = new File("src/Fondos/i19.jpg");
            iFrenteP = new File("src/Fondos/i20.jpg");
            iDerechaP = new File("src/Fondos/i21.jpg");
            iIzquierdaP = new File("src/Fondos/i22.jpg");
            iTechoP = new File("src/Fondos/i24.jpg");
            iPisoP = new File("src/Fondos/i23.jpg");
            tAtrasP4Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP4Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP4Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP4Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP4Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP4Menu = TextureIO.newTexture(iPisoP, false);
            //5
            iAtrasP = new File("src/Fondos/i25.jpg");
            iFrenteP = new File("src/Fondos/i26.jpg");
            iDerechaP = new File("src/Fondos/i27.jpg");
            iIzquierdaP = new File("src/Fondos/i28.jpg");
            iTechoP = new File("src/Fondos/i30.jpg");
            iPisoP = new File("src/Fondos/i29.jpg");
            tAtrasP5Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP5Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP5Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP5Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP5Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP5Menu = TextureIO.newTexture(iPisoP, false);
            //6
            iAtrasP = new File("src/Fondos/i31.jpg");
            iFrenteP = new File("src/Fondos/i32.jpg");
            iDerechaP = new File("src/Fondos/i33.jpg");
            iIzquierdaP = new File("src/Fondos/i34.jpg");
            iTechoP = new File("src/Fondos/i36.jpg");
            iPisoP = new File("src/Fondos/i35.jpg");
            tAtrasP6Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP6Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP6Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP6Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP6Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP6Menu = TextureIO.newTexture(iPisoP, false);
            //7 
            iAtrasP = new File("src/Fondos/i37.jpg");
            iFrenteP = new File("src/Fondos/i38.jpg");
            iDerechaP = new File("src/Fondos/i39.jpg");
            iIzquierdaP = new File("src/Fondos/i40.jpg");
            iTechoP = new File("src/Fondos/i41.jpg");
            iPisoP = new File("src/Fondos/i42.jpg");
            tAtrasP7Menu = TextureIO.newTexture(iAtrasP, false);
            tFrenteP7Menu = TextureIO.newTexture(iFrenteP, false);
            tDerechaP7Menu = TextureIO.newTexture(iDerechaP, false);
            TIzquierdaP7Menu = TextureIO.newTexture(iIzquierdaP, false);
            tTechoP7Menu = TextureIO.newTexture(iTechoP, false);
            tPisoP7Menu = TextureIO.newTexture(iPisoP, false);
            //Cuphead
            //Escenario 1
            File iAtrasC = new File("src/Fondos/casa.jpg");
            tAtrasK1Menu = TextureIO.newTexture(iAtrasC, true);
            File iFrenteC = new File("src/Fondos/feria.jpg");
            tFrenteK1Menu = TextureIO.newTexture(iFrenteC, true);
            File iDerechaC = new File("src/Fondos/bosque.jpg");
            tDerechaK1Menu = TextureIO.newTexture(iDerechaC, true);
            File iIzquierdaC = new File("src/Fondos/bosque.jpg");
            TIzquierdaK1Menu = TextureIO.newTexture(iIzquierdaC, true);
            File iTechoC = new File("src/Fondos/cielo.jpg");
            tTechoK1Menu = TextureIO.newTexture(iTechoC, true);
            File iPisoC = new File("src/Fondos/suelo.jpg");
            tPisoK1Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario2
            iAtrasC = new File("src/Fondos/minecraftLado.jpg");
            tAtrasK2Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/minecraftFrente.jpg");
            tFrenteK2Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/minecraftLado.jpg");
            tDerechaK2Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/minecraftLado.jpg");
            TIzquierdaK2Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/minecraftCielo.jpg");
            tTechoK2Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/minecraftSuelo.jpg");
            tPisoK2Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario3
            iAtrasC = new File("src/Fondos/feriaLados.jpg");
            tAtrasK3Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/feriaFrente.jpg");
            tFrenteK3Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/feriaLados.jpg");
            tDerechaK3Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/feriaLados.jpg");
            TIzquierdaK3Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloNoche.jpg");
            tTechoK3Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/suelo.jpg");
            tPisoK3Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario4
            iAtrasC = new File("src/Fondos/atraccion.jpg");
            tAtrasK4Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/atraccion.jpg");
            tFrenteK4Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/atraccion.jpg");
            tDerechaK4Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/atraccion.jpg");
            TIzquierdaK4Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tTechoK4Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/techoYCieloAtraccion.jpg");
            tPisoK4Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario5
            iAtrasC = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tAtrasK5Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/frenteYAtrasCielo.jpg");
            tFrenteK5Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/ladoCiudad.jpg");
            tDerechaK5Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/ladoCiudad.jpg");
            TIzquierdaK5Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloCiudad.jpg");
            tTechoK5Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/sueloCiudad.jpg");
            tPisoK5Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario6
            iAtrasC = new File("src/Fondos/atrasCarretera.jpg");
            tAtrasK6Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/frenteCarretera.jpg");
            tFrenteK6Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/ladoCarretera.jpg");
            tDerechaK6Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/ladoCarretera.jpg");
            TIzquierdaK6Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/cieloCarretera.jpg");
            tTechoK6Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/sueloCarretera.jpg");
            tPisoK6Menu = TextureIO.newTexture(iPisoC, true);
            //Escenario7
            iAtrasC = new File("src/Fondos/desiertoAtras.jpg");
            tAtrasK7Menu = TextureIO.newTexture(iAtrasC, true);
            iFrenteC = new File("src/Fondos/desiertoFrente.jpg");
            tFrenteK7Menu = TextureIO.newTexture(iFrenteC, true);
            iDerechaC = new File("src/Fondos/desiertoLados.jpg");
            tDerechaK7Menu = TextureIO.newTexture(iDerechaC, true);
            iIzquierdaC = new File("src/Fondos/desiertoLados.jpg");
            TIzquierdaK7Menu = TextureIO.newTexture(iIzquierdaC, true);
            iTechoC = new File("src/Fondos/desiertoCielo.jpg");
            tTechoK7Menu = TextureIO.newTexture(iTechoC, true);
            iPisoC = new File("src/Fondos/desiertoSuelo.jpg");
            tPisoK7Menu = TextureIO.newTexture(iPisoC, true);
            //Teclas
            File iTeclaZ = new File("src/Fondos/keyboard_key_z.png");
            tTeclaZMenu = TextureIO.newTexture(iTeclaZ, true);
            File iTeclaX = new File("src/Fondos/X.jpg");
            tTeclaXMenu = TextureIO.newTexture(iTeclaX, true);
            File iTeclaC = new File("src/Fondos/keyboard_key_c.png");
            tTeclaCMenu = TextureIO.newTexture(iTeclaC, true);

        } catch (IOException iOE) {
            System.out.println("Error en carga de imagen en el menu");
        }
    }

    public void diplayTextura(GL gl, GLU glu, final float X_POSITION, final float Y_POSITION,
            final float Z_POSITION, float view_rotx, float view_roty, double zoom, int bndKey, int bnd, boolean[] keys)
    {

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
        switch (bndKey) {
            case 0:
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTechoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                kd.fondo(gl, glu, tTechoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tTechoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                kd.fondo(gl, glu, tPisoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                kd.fondo(gl, glu, tTechoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(0.0f, 2.5f, 2.5f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTechoMenu);
                gl.glPopMatrix();
                gl.glFlush();
                break;
            case 1:
                switch (bnd) {
                    case 1:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 2:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 3:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 4:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 5:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 6:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 7:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaP7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaP7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoP7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoP7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasP7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteP7Menu);
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
                        kd.fondo(gl, glu, tTechoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tTechoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tTechoMenu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 2:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 3:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 4:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 5:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 6:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 7:
                        //Dibujamos la texturas del lado derecho
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerecha7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del lado izquierdo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierda7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del cielo
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTecho7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas del piso
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPiso7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la casa
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtras7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        //Dibujamos la texturas de la feria
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrente7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                }
                break;
            case 3:
                switch (bnd) {
                    case 1:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK1Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 2:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK2Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 3:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK3Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 4:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK4Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 5:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK5Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 6:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK6Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        break;
                    case 7:
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, tDerechaK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
                        kd.fondo(gl, glu, TIzquierdaK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tTechoK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
                        kd.fondo(gl, glu, tPisoK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        kd.fondo(gl, glu, tAtrasK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                        gl.glPushMatrix();
                        gl.glTranslatef(0.0f, 2.5f, 2.5f);
                        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                        gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                        kd.fondo(gl, glu, tFrenteK7Menu);
                        gl.glPopMatrix();
                        gl.glFlush();
                }
                break;
        }
        switch (bndKey) {
            case 0:
                //Dibujamos la texturas de los botones
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaXMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaCMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glTranslatef(-5f, 0f, 0f);
                pingu.draw_pingu(gl, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
                gl.glPopMatrix();
                gl.glPushMatrix();
                //Aqui agregue un false por que agregue que camine el csm
                kd.draw_KingDice(gl, false, false, false, false, false, false, false, false);
                gl.glPopMatrix();
                gl.glPushMatrix();
                gl.glTranslatef(5f, 0f, 0f);
                cuphead.draw_cuphead(gl, false, false, false, false, false, false, false, false, true);
                gl.glPopMatrix();
                // Flush all drawing operations to the graphics card
                gl.glFlush();
                break;
            case 1:
                gl.glPushMatrix();
                gl.glTranslatef(-5f, 0f, 0f);
                pingu.draw_pingu(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], keys['J'], keys['Q'], keys['W'], keys['E'], keys['R'], keys['T'], keys['Y'], keys['U'], false, false);
                pingu.set_white_head_material(gl);
                gl.glPopMatrix();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaCMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaXMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-47f, 35.6f, 20.0f);
                kd.fondo(gl, glu, tAtrasP1Menu);
                gl.glPopMatrix();
                break;
            case 2:
                gl.glPushMatrix();
                //Agregue el caminar por ende hay que agregar una nueva key no lo agego pq no se cual estu logica para los movimientos
                //en la clase KingDice esta el orden de lo que hace en la linea 57
                kd.draw_KingDice(gl, keys['A'], keys['S'], keys['D'], keys['F'], keys['G'], keys['H'], false, false);
                gl.glPopMatrix();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(45.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaCMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-47f, 35.6f, 20.0f);
                kd.fondo(gl, glu, tAtrasK2Menu);
                gl.glPopMatrix();
                break;
            case 3:
                gl.glPushMatrix();
                gl.glTranslatef(5f, 0f, 0f);
                cuphead.draw_cuphead(gl, keys['W'], keys[' '], keys['C'], keys['E'], keys['B'], keys['Q'], keys['F'], false, false);
                gl.glPopMatrix();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(5.6f, -12.6f, 12.0f);
                gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
                gl.glRotatef(180, 0.0f, 0.0f, 1.0f);
                kd.fondo(gl, glu, tTeclaXMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-46.6f, -12.6f, 20.0f);
                kd.fondo(gl, glu, tTeclaZMenu);
                gl.glPopMatrix();
                gl.glFlush();
                gl.glPushMatrix();
                gl.glScalef(0.1f, 0.1f, 0.1f);
                gl.glTranslatef(-47f, 35.6f, 20.0f);
                kd.fondo(gl, glu, tAtras2Menu);
                gl.glPopMatrix();
                break;
        }
        tituloMenu.beginRendering(1000, 800);
        tituloMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        tituloMenu.draw("Selecccione un personaje", 230, 720);
        tituloMenu.endRendering();

        if (bndKey == 1 || bndKey == 2 || bndKey == 3) {
            tituloPlay.beginRendering(1000, 800);
            tituloPlay.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            tituloPlay.draw("Presiona \"P\" para jugar", 245, 670);
            tituloPlay.endRendering();
            tituloNivel.beginRendering(1000, 700);
            tituloNivel.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            tituloNivel.draw("Seleccionar nivel", 280, 540);
            tituloNivel.endRendering();
        }
    }
}
