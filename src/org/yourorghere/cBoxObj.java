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
public class cBoxObj {
   float [] centro;
   float [] extend;
   public cBoxObj(final float ancho, final float alto, final float profundidad, float [] c){
       centro = c;
       extend = new float[3];
       extend [0] = ancho;
       extend [1] = alto;
       extend [2] = profundidad;
   }
}
