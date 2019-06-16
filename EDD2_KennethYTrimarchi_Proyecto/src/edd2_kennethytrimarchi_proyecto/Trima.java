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
    public void abrir(ver_si_es_util r)
            throws IOException {
        file = new RandomAccessFile("MetaData.dat", "rw");
        //r.numCampos=file.readLong();
    }

    public void escribir(ver_si_es_util registro, Campos c) throws IOException {
        if (file != null) {
            registro.writeCampo(file, c);
        }
    }


    public void readC(ver_si_es_util reg) throws IOException, ParseException {
        reg.readCampos(file);

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
    public void modificarC(ver_si_es_util c,Campos p) throws IOException{
        c.modificarCampo(file,p.size_dec
                ,p);
    }
/**
 *    public void EliminarDatoArchivo(ArrayList<Object> TrimaExport) {

        try {
            Registro temporal = new Registro(Integer.parseInt(TrimaExport.get(0).toString()));
            if (BuscarDatoArchivo(temporal) != null) {
                System.out.println("===========================================================");
                System.out.println("ELIMANDO NODO...");
                Data temp = BuscarDatoArchivo(temporal);
                RAfile.seek(temp.ubicacion);
                int size_act = RAfile.readInt();//Este es el tamaño actual
                temp.setSize_alter("*"); //Pone un aterisco que marca ese registro o dato como eliminado

                ByteArrayOutputStream obArray = new ByteArrayOutputStream();
                ObjectOutputStream objeto = new ObjectOutputStream(obArray);

                obArray = new ByteArrayOutputStream();
                objeto = new ObjectOutputStream(obArray);
                objeto.writeObject(temp);
                byte[] dat2 = obArray.toByteArray();
                RAfile.write(dat2);
                System.out.println("Implementando Avail List....");
                temp.setKey(size_act);
                System.out.println("LLamar metodo del AvailList...");
                
                System.out.println("===========================================================");
                //Avai
                
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

 */
}
