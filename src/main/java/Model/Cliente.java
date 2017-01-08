
package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
@XmlRootElement(name = "cliente")  // Le decimos que el elemento base es "cliente"

public class Cliente {
    
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String FechaAlquiler;

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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public String getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.FechaAlquiler = fechaAlquiler;
    }

    public Cliente() {
        this.Id=0;
        this.Nombre = "";
        this.Apellidos = "";
        this.FechaAlquiler="";
    }
    
    
    
}
