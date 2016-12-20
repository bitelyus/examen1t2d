
package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
@XmlRootElement(name = "empleado")  // Le decimos que el elemento base es "Receta"

public class Empleado {
    
    private int Id;
    private String Nombre;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public Empleado() {
        this.Id = 0;
        this.Nombre = "";
    }
 
}
