/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

import java.util.ArrayList;

/**
 *
 * @author X
 */
public class Registro {
    int key;
    String name="";
    ArrayList<Object> data=new ArrayList();
    
    
    

    public Registro() {
    }

    public ArrayList<Object> getData() {
        return data;
    }


    public void setData(ArrayList<Object> data) {
        this.data = data;
    }
    

    public Registro(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return key +""+" ";
    }
    
    
    
}
