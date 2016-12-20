/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import View.InterfazA2;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class ControlerA2 {
    
    public static void comenzar() {
    
        String ruta = "";
        InterfazA2.mostarCarpetas();
        ruta = InterfazA2.pedirRutaLeer();
        InterfazA2.mostarNoTxt(ruta);

        
    }
    
}
