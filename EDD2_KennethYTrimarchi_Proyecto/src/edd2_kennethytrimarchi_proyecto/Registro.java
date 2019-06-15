/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author X
 */
public class Registro implements Serializable{
    int key;
    int byteOffset;
    int size;
     // ArrayList<Object> data;

    /*public Registro(ArrayList<Object> data) {
        this.data = data;
        this.key = Integer.valueOf(data.get(0).toString());
    }*/
    
    
    

    public Registro() {
    }
    
    /*public ArrayList<Object> getData() {
        return data;
    }


    public void setData(ArrayList<Object> data) {
        this.data = data;
    }*/
    

    public Registro(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getByteOffset() {
        return byteOffset;
    }

    public void setByteOffset(int byteOffset) {
        this.byteOffset = byteOffset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    



    @Override
    public String toString() {
        return key +""+" ";
    }
    
    
    
}
