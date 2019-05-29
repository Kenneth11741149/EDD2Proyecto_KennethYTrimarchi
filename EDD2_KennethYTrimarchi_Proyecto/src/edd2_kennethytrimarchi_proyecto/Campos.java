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
    public char[] name=new char[30];
    public int FieldType;
    public long sizeBytes;
    public long size_dec;
    public boolean key=false;

    public Campos() {
        
    }
    

    @SuppressWarnings("empty-statement")
    public Campos(int FieldType, long sizeBytes, long size_dec, boolean key) {
        this.FieldType = FieldType;
        this.sizeBytes = sizeBytes;
        this.size_dec = size_dec;
        this.key = key;
        
    }

    public char[] getName() {
        return name;
    }
    public char getChar(int x){
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

    public void setSize_dec(int size_dec) {
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
        return name+"|"+FieldType+"|"+key;
    }
    
   
    
    
    
}
