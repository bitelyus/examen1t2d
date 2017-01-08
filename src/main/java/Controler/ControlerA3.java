/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Alquiler;
import View.Ch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class ControlerA3 {

    public static void comenzar() {

        // 1. Comprobar existencia carpeta JSON
        // 2. Si no existe... Crearla
        
        File midir = new File("JSON");
        File miworkingdir = new File("datos");
        File[] misxmls = null;
        
        int i = 0;
        boolean salir = false;
        Alquiler alquiler;
        
        ArrayList<Alquiler> misalquileres = new ArrayList<>();

        
        if (!midir.exists()) {
            midir.mkdir();
            Ch.lcd("SE HA CREADO LA CARPETA 'JSON' DE TRABAJO");
        }
        
        // 3. Comprobamos que existe el directorio con los xmls. Sino.. reintentar
        if (!miworkingdir.exists()) {
            Ch.lcd("i> PSS! No existe la carpeta con los datos. Revísalo!");
            salir = true;
        } else {
            Ch.lcd("i> Directorio de trabajo localizado");
            misxmls = miworkingdir.listFiles(new MiFiltro("xml"));
            if (misxmls.length > 0) {
                Ch.lcd("\nLISTADO DE ARCHIVOS XML");
                Ch.lcd("-----------------------");
                for (i = 0; i < misxmls.length; i++) {
                    System.out.println((i + 1) + ". " + misxmls[i].getName());
                }
            } else {
                Ch.lcd("i> No hay ficheros xml disponibles");
                salir = true;
            }
        }
        
        // 4. SI EXISTE.. A LEERLOS LOS XMLS
        if (!salir) {
            // A LEER XML Y VOLCAR A OBJETO
            // VAMOS Y LEEEMOS EL ARCHIVO...
            try {
                for (i = 0; i < misxmls.length; i++) {
                    //System.out.println((i + 1) + ". " + misxmls[i].getName());

                    // Creamos un contexto de la clase JAXB y lo intanciamos
                    // Es como el motorcito que hace que todo funciones. El contexto es DIOS
                    JAXBContext context = JAXBContext.newInstance(Alquiler.class);
                    Marshaller m = context.createMarshaller();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    // Obtenemos las variables obtenidas del XML creado anteriormente
                    Unmarshaller um = context.createUnmarshaller();
                    alquiler = (Alquiler) um.unmarshal(new FileReader("datos/" + misxmls[i].getName()));
                    misalquileres.add(alquiler);
                    Ch.lcd(alquiler.toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR: " + ex.getMessage());
            }

            // AHORA VOLCAMOS LA CLASE ALQUILERS A GSON
            Ch.lcd(("i> Tamaño: " + misalquileres.size()));
            guardarJSON(misalquileres);
            Ch.lcd("i> Fichero json creado en directorio 'JSON'");
        }
        Ch.pausa();

    }

    /**
     * Método que recibo un objeto Alquiler, crea un json y lo guarda en archivo
     *
     * @param alquiler El alquiler que vamos a serializar con Gson
     */
    public static void guardarJSON(ArrayList<Alquiler> alquiler) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String misAlquileres = gson.toJson(alquiler);
            FileWriter fw = null;
            fw = new FileWriter("JSON/misalquileres.json");
            fw.write(misAlquileres);
            fw.flush();
            fw.close();
            Ch.lcd(misAlquileres);
        } catch (Exception ex) {
            Logger.getLogger(ControlerA3.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}
