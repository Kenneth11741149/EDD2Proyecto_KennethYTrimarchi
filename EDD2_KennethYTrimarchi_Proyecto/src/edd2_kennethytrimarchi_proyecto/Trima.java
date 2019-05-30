package edd2_kennethytrimarchi_proyecto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * Bienvenido a Java Puterias y +      <---- HAHAHAHAHAHAHAHHA
 */
public class Trima {

    private RandomAccessFile file;

    public Trima() {

    }

    public Trima(RandomAccessFile file) {
        this.file = file;
    }

    // Apertura del fichero
    public void abrir()
            throws IOException {
        file = new RandomAccessFile("MetaData.dat", "rw");
    }

    public void escribir(Registro registro, Campos c) throws IOException {
        if (file != null) {
            registro.writeCampo(file, c);
        }
    }
    
    public void read(Registro reg) throws IOException, ParseException{
        reg.readFile(file);
    }
    
    
    
// Cierre del fichero
    public void cerrar()
            throws IOException {
        if (file != null) {
            file.close();
        }
    }

    public long File_size() throws IOException {

        return file.length();
    }

}
