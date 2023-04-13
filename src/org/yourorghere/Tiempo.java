/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Montalvo Pérez
 */
public class Tiempo extends Thread
{

    private int segundos;
    private int milisegundos;
    private String tiempo;

    public Tiempo()
    {
        this.segundos = 0;
        this.milisegundos = 0;
        this.tiempo = "";

    }

    /**
     * @return the tiempo
     */
    public String getTiempo()
    {

        return tiempo;
    }

    public void contador()
    {
        this.segundos = 15;
        this.milisegundos = 0;
        this.tiempo = "00:15.00";
        do {
            try {
                sleep(1);
                milisegundos--;
                if (milisegundos == -1) {
                    this.milisegundos = 999;
                    segundos--;
                }

                if (segundos < 10) {
                    if ((milisegundos / 10) < 10) {
                        this.tiempo = "00:0" + segundos + ".0" + (milisegundos / 10);
                    } else {
                        this.tiempo = "00:0" + segundos + "." + (milisegundos / 10);
                    }
                } else {
                    if ((milisegundos / 10) < 10) {
                        this.tiempo = "00:" + segundos + ".0" + (milisegundos / 10);
                    } else {
                        this.tiempo = "00:" + segundos + "." + (milisegundos / 10);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (segundos >= 0);
        this.tiempo = "00:00.00";
    }

    public void run()
    {
        contador();
    }
}
