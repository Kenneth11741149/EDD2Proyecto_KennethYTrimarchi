
package edd2_kennethytrimarchi_proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kenneth Van Yableth
 */
public class Metadata implements Serializable{
    private String nombre;
    private ArrayList campos;
    private ArrayList tipos;
    private int numregistros = 0;
    
    public Metadata() {
    }

    public int getNumregistros() {
        return numregistros;
    }

    public void setNumregistros(int numregistros) {
        this.numregistros = numregistros;
    }
    
    public void addnumregistros(){
        this.numregistros++;
    }

    public ArrayList getCampos() {
        return campos;
    }

    public void setCampos(ArrayList campos) {
        this.campos = campos;
    }
    
    

    
    
    
    public Metadata(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Metadata{" + "nombre=" + nombre + '}';
    }
    
    
}
