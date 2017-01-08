
package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
@XmlRootElement(name = "Coche")  // Le decimos que el elemento base es "Coche"

public class Coche {
    
    private int Id;
    private String Marca;
    private String Modelo;
    private int Anio;
    private String Matricula;
    private Cliente Cliente;
    private Empleado Empleado;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        this.Anio = anio;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        this.Cliente = cliente;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.Empleado = empleado;
    }

    public Coche() {
        this.Id=0;
        this.Marca="";
        this.Modelo="";
        this.Anio=0;
        this.Matricula="";
        this.Cliente=null;
        this.Empleado=null;
    }
    

}
