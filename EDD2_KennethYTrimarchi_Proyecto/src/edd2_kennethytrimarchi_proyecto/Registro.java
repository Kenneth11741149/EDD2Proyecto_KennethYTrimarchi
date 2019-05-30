/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 *
 * @author X
 */
public class Registro  extends Trima {

    public int size;
    public int numCampos;
    public ArrayList<Campos> Camps = new ArrayList<>();

    public Registro() {

    }

    public Registro(int size, int numCampos) {
        this.size = size;
        this.numCampos = numCampos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumCampos() {
        return numCampos;
    }

    public void setNumCampos(int numCampos) {
        this.numCampos = numCampos;
    }

    public ArrayList<Campos> getCamps() {
        return Camps;
    }

    public void setCamps(ArrayList<Campos> Camps) {
        this.Camps = Camps;
    }

    public Campos getCampo(int x) {
        return Camps.get(x);
    }

    public void addCampo(Campos e) {
        Camps.add(e);
    }

    public void readFile(RandomAccessFile file)
            throws IOException, java.text.ParseException {
        System.out.print(file.readLong());
        System.out.print((char) file.readByte());
        System.out.print(file.readLong());
        System.out.print((char) file.readByte());
        for (int i = 0; i<10; i++) {
           System.out.print(file.readChar());
        }
        System.out.print((char) file.readByte());
        System.out.print(file.readInt());
        System.out.print((char) file.readByte());
        System.out.print(file.readLong());
        System.out.print((char) file.readByte());
        System.out.print(file.readBoolean());
        //file.writeBytes(System.getProperty("line.separator"));
    }

    private String readString(RandomAccessFile file) throws IOException {
        char campo[] = new char[size];
        for (int i = 0; i < size; i++) {

            campo[i] = file.readChar();

        }

        return new String(campo).replace('\0', ' ');
    }

    public void writeCampo(RandomAccessFile file, Campos c) throws IOException {
        //long pesa 8 Bytes   String 2 bytes por letra
        //boolean pesa 1 Bytes
        // |= 1 Byte    \n= 2Bytes

        //long-long-string-int-long-boolean
        String name = "";
        long Bytes_en_Caracteres = 1 + 1 + 1 + 1 + 1 + 2;
        long size_total = 8 + 8 + c.sizeBytes + 8 + 4 + Bytes_en_Caracteres;
        file.writeLong(file.length());
        file.writeBytes("|");
        file.writeLong(size_total);
        file.writeBytes("|");

        for (int i = 0; i < 10; i++) {
            System.out.print(c.getChar(i));
            String tiene = Character.toString('a');
            System.out.println(tiene + "--");

            String letras = "abcdefghijklmnopqrstuvwxyz"
                    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "1234567890";
            if (letras.contains(tiene)) {
                //System.out.println("Enocntrados" + tiene.length());
                //name += tiene;
                file.writeChar('a');
            } else {
                //System.out.println("NAada");
            }
        }
        //file.writeChars(name);
        file.writeBytes("|");
        file.writeInt(c.FieldType);
        file.writeBytes("|");
        file.writeLong(c.size_dec);
        file.writeBytes("|");
        file.writeBoolean(c.key);
        file.writeBytes(System.getProperty("line.separator"));

    }

}
