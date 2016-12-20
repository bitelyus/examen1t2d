/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.MiFiltro2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class InterfazA2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void mostarCarpetas() {

        int i = 0;
        // 1. VAMOS A LISTAR LOS ARCHIVOS CON EXTENSIÓN XML Y JSON DISPONIBLES
        File miDir = new File(System.getProperty("user.dir"));           // EL DIRECTORIO DE TRABAJO MAS CARPETA DE RECETAS
        Ch.lcd("i> Directorio de trabajo: " + miDir.getAbsolutePath());
        File[] archivos = miDir.listFiles(); // CON FILTRO PARA XML
        Ch.lcd("\nLISTADO CARPETAS DISPONIBLES");
        Ch.lcd("----------------------------");
        for (i = 0; i < archivos.length; i++) {
            if (archivos[i].isDirectory()) {
                System.out.println("d> " + archivos[i].getName());
            }
        }

    }

    public static void mostarNoTxt(String ruta) {

        Date date;
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");

        int i = 0;
        // 1. VAMOS A LISTAR LOS ARCHIVOS CON EXTENSIÓN XML Y JSON DISPONIBLES
        File miDir = new File(System.getProperty("user.dir") + "/" + ruta);           // EL DIRECTORIO DE TRABAJO MAS CARPETA DE RECETAS
        Ch.lcd("i> Directorio de trabajo: " + miDir.getAbsolutePath());
        File[] archivos = miDir.listFiles(new MiFiltro2("txt")); // CON FILTRO PARA XML
        if (archivos.length > 0) { //?????!!!!!!
            Ch.lcd("\nLISTADO DE ARCHIVOS NO! TXT");
            Ch.lcd("-----------------------------");
            for (i = 0; i < archivos.length; i++) {
                if (!archivos[i].isDirectory()) {
                    date = new Date(archivos[i].lastModified());
                    String dateText = df2.format(date);
                    System.out.println((i + 1) + ". " + archivos[i].getName() + " | ULTIMA MODIFICACION: " + dateText);
                }
            }
        } else {
            Ch.lcd("i> No hay datos para mostrar!!");
        }

    }

    public static String pedirRutaLeer() {
        String aux = "";
        String ruta = "";
        boolean salir = false;
        do {
            System.out.print("\n?> DÁME EL NOMBRE DE UNA CARPETA: ");
            try {
                aux = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(InterfazA2.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (!aux.isEmpty()) {
                System.out.println("i> archivo: " + aux);
                ruta = aux;
                //String desktop = System.getProperty("user.home") + "/Desktop/";
                File myFile = new File(ruta);
                if (myFile.isDirectory()) {
                    //System.out.println(myFile.getAbsolutePath());
                    salir = true;
                } else {
                    System.out.println("!> No se encontro el archivo...");
                }
            }
            //}

            //}
        } while (!salir);
        return ruta;
    }

    public static String pedirCaracter() {
        String aux = "";
        String ruta = "";
        String miletra = "";

        boolean salir = false;
        do {
            System.out.print("\n?> DÁME UN CARACTER A CONTAR: ");
            try {
                aux = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(InterfazA2.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (!aux.isEmpty() && aux.length() == 1) {
                System.out.println("i> char: " + aux);
                miletra = aux;
                salir = true;
                //String desktop = System.getProperty("user.home") + "/Desktop/";
            } else {
                Ch.lcd("!> Perdona?!?...");
            }

        } while (!salir);
        return miletra;
    }

}
