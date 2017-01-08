
package Model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */

@XmlRootElement(name = "alquiler")

/**
 * Modelo para Albegar un listado de coches alquilados en un mes
 */
public class Alquiler {
    @XmlElement(name="Mes")    
    private String Mes;
    
    @XmlElementWrapper(name="Coches")
    @XmlElement(name="Coche")    
    private ArrayList<Coche> Coches;

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }
    
    @XmlTransient // Esto se pone a los gets de las listas para que no repita los datos en el xml
    public ArrayList<Coche> getCoches() {
        return Coches;
    }

    public void setCoches(ArrayList<Coche> Coches) {
        this.Coches = Coches;
    }

    public Alquiler() {
        this.Mes = "";
        this.Coches = new ArrayList<Coche>();
    }
    
    
    @Override
    public String toString() {
        String salida = "";
        salida+="SOY UN ALQUILER\n";
        salida+="MES...: " + this.getMes() +"\n";
        salida+="COCHEs: " + this.Coches.size()+"\n";
        
        return salida;
    }
       
}
