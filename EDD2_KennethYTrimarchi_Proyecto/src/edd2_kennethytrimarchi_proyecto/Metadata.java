package edd2_kennethytrimarchi_proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Kenneth Van Yableth
 */
public class Metadata implements Serializable {

    private ArrayList<Campos> Campo = new ArrayList<>();//Arraylist para manejar los campos en el Archivo
    private String nombre;
    private ArrayList campos;
    private ArrayList tipos;
    private int numregistros = 0;
    private boolean estado; // True significa que hay informacion en la metadata.
    private File file;
    RandomAccessFile RAfile;
    private long Campos_en_Archivo;

    public Metadata() {
        estado = false;
    }

    public ArrayList getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList tipos) {
        this.tipos = tipos;

    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumregistros() {
        return numregistros;
    }

    public void setNumregistros(int numregistros) {
        this.numregistros = numregistros;
    }

    public void addnumregistros() {
        this.numregistros++;
    }

    public ArrayList getCampos() {
        return campos;
    }

    public void setCampos(ArrayList campos) {
        this.campos = campos;

    }

    public Metadata(String nombre) {
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) throws FileNotFoundException {
        this.file = file;
        RAfile = new RandomAccessFile(file, "rw");
    }

    public void setCamposArchivo(int nCampos) throws IOException, ParseException {
        //Metodo para llenar simultaneamente mi arraylist de Campos para escribir en el archivo
        file = new File("./Prueba.dat");
        Campos_en_Archivo = nCampos;
        RAfile = new RandomAccessFile(file, "rw");
        RAfile.seek(0);//busca el inicio del archivo
        RAfile.writeLong(Campos_en_Archivo);//escribe en la primera linea cuantos campos van a haber en la metdata
        RAfile.writeBytes(System.getProperty("line.separator"));

        for (int i = 0; i < nCampos; i++) {
            Campos c = new Campos();
            if (i == 0) {
                c.setKey(true);
            } else {
                c.setKey(false);
            }
            c.agregarNombre((String) campos.get(i));//agrega el nombre del campo
            c.setFieldType((int) tipos.get(i));//agrega el tipo de dato a la clase campo
            c.setSize_dec(RAfile.length());//agrega la ubicacion en la que va a estar el campo en el archivo
            writeCampo(c);

        }
        readCampos();
    }


    public void writeCampo(Campos c) throws IOException {
        //long pesa 8 Bytes   String 1 bytes por letra
        //boolean pesa 1 Bytes
        // |= 1 Byte    \n= 2Bytes
        RAfile.seek(RAfile.length());
        String name = "";
        long size_total = c.sizeBytes;//pide de la lcase campo el size total del Campo
        RAfile.writeLong(file.length());//escribe la ubicacion del campo
        RAfile.writeBytes("|");//delimitador para que se vea Bonis
        RAfile.writeLong(size_total);
        RAfile.writeBytes("|");
        // System.out.println("-----------" + c.cadena.length());
        for (int i = 0; i < c.cadena.length(); i++) {
            char string[] = c.getName();
            RAfile.writeByte(string[i]);//for que esccribe cgar por char al archivo en forma dde bytes
        }
        RAfile.writeBytes("|");
        RAfile.writeInt(c.FieldType);//esto cuarda el tipo de dato del campo
        RAfile.writeBytes("|");
        //file.writeLong(c.size_dec);
        //file.writeBytes("|");
        RAfile.writeBoolean(c.key);//guarda si es primary o no ya se sabe que el primero es, pero para efectos de la clase se pone
        RAfile.writeBytes(System.getProperty("line.separator"));//escribe una nueva linea y pesa 2 bytes

    }

    public void readCampos()
            throws IOException, java.text.ParseException {
        boolean registro_elimando = false;
        RAfile.seek(0);
        Campos_en_Archivo = RAfile.readLong();
        RAfile.skipBytes(2);

        for (int j = 0; j < Campos_en_Archivo; j++) {
            boolean frase_encontrada = false;
            long ubicacion = RAfile.readLong();

            //int nCampos=file.readInt();
            //file.readByte();
            System.out.print(ubicacion);
            System.out.print((char) RAfile.readByte());
            long size = RAfile.readLong();
            System.out.print(size);
            System.out.print((char) RAfile.readByte());
            String nombre = "";
            String acumulador = "";
            Campos c = new Campos();

            while (frase_encontrada == false) {
                acumulador = "";
                acumulador += (char) RAfile.readByte();
                if (acumulador.contains("|")) {
                    //System.out.println("SIIIIIIIIIII");
                    frase_encontrada = true;
                } else {
                    nombre += acumulador;
                    // System.out.println("NOOOOOOOOOOOOOO");
                }

                //System.out.print(file.readChar());         
            }
            System.out.print(nombre + acumulador);
            int tipo = RAfile.readInt();
            System.out.print(tipo);
            System.out.print((char) RAfile.readByte());
            //long nose = file.readLong();
            //System.out.print(nose);
            //System.out.print((char) file.readByte());
            boolean key = RAfile.readBoolean();
            System.out.print(key);
            RAfile.skipBytes(2);
            System.out.println("");
            //file.skipBytes(2);
            c.setKey(key);
            c.agregarNombre(nombre);
            c.setFieldType(tipo);
            c.setSizeBytes(size);
            c.setSize_dec(ubicacion);

            Campo.add(c);

            //file.writeBytes(System.getProperty("line.separator"));
            Campo.add(c);
        }
    }

}
