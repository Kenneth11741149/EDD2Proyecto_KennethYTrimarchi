/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

/**
 *
 * @auth
 */
public class Campos {

    // Under maintenance, waiting for update Project 3.0
    /**
     * char name[30]; FieldType type; int size; int size_dec; bool key;
     *
     */
    public char[] name;
    public int FieldType;
    public long sizeBytes;
    public long size_dec;
    public boolean key = false;
    public String cadena = "123456789012345678901234567890";

    public boolean entro = false;

    public Campos() {

    }

    @SuppressWarnings("empty-statement")
    public Campos(int FieldType, long size_dec, boolean key) {
        this.FieldType = FieldType;
        long Bytes_en_Caracteres = 5 + 1;
        this.sizeBytes = 8  + 8 + 4 + Bytes_en_Caracteres + 1;
        this.size_dec = size_dec;
        this.key = key;

    }

    public boolean agregarNombre(String a) {
        if (a.length() <= cadena.length()) {
            if (entro == false) {
                name = new char[a.length()];
                for (int i = 0; i < a.length(); i++) {
                    name[i] = a.charAt(i);
                }
                sizeBytes += (a.length());
                cadena = a;
                entro = true;
            } else {
                for (int i =   0; i < cadena.length(); i++) {
                    if (i < a.length()) {
                        name[i] = a.charAt(i);
                    } else {
                        name[i] =' ';
                        a+=" ";
                    }
                }
                cadena=a;
            }
            return true;
        } else {
            System.out.println("El Registro es Muy Grande debe ser mas pequeño");
            return false;
        }
    }

    public char[] getName() {
        return name;
    }

    public char getChar(int x) {
        return name[x];
    }

    public void setName(char[] name) {
        this.name = name;
    }

    public int getFieldType() {
        return FieldType;
    }

    public void setFieldType(int FieldType) {
        this.FieldType = FieldType;
    }

    public Long getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public Long getSize_dec() {
        return size_dec;
    }

    public void setSize_dec(long size_dec) {
        this.size_dec = size_dec;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return cadena + "|" + FieldType + "|" + key;
    }

}