
package Controler;

import View.Ch;
import View.InterfazA1;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class ControlerA1 {
    public static void comenzar() {
        
        String ruta = "";
        String letra = "";
        String mipalabra="";
        int contador = 0;
        
        InterfazA1.mostarTxt();
        ruta = InterfazA1.pedirRutaLeer();
        letra = InterfazA1.pedirCaracter();
        
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String cadena = "";
            String[] cadenasplit = null;

            while ((cadena=br.readLine())!=null) {
            	cadenasplit = cadena.split(" ");
                for (String palabra : cadenasplit) {
                    for (int i = 0; i<palabra.length();i++) {
                        mipalabra=""+palabra.charAt(i);
                        if (mipalabra.equalsIgnoreCase(letra)) {
                            contador++;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Ch.lcd("i> EL NÚMERO DE APARICIONES DE '"+letra+"' ES: "+contador+"''");
    }
}
