package edd2_kennethytrimarchi_proyecto;

import java.awt.JobAttributes;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EDD2_KennethYTrimarchi_Proyecto {
    //static Scanner read = new Scanner(System.in);
    static Metadata metadata;
    static int option;
    public static void main(String[] args) throws IOException, ParseException {
        JOptionPane.showMessageDialog(null,"GUI VERSION 1.7. \nNo try catch enabled. \nTable Issues Resolved");
        
        GUI graphics = new GUI();
        graphics.setVisible(true);
        //Menu Temporal
        /*Kenneth metodos = new Kenneth();
        String resp = "S";
        metadata = new Metadata();
        while(resp.equals("S") || resp.equals("s")){
        System.out.println("Bienvenido al proyecto: ");
        System.out.println("MENU:");
        System.out.println("1. Crear Campos. ");
        System.out.println("2. Listar Campos. ");
        System.out.println("3. Modificar Campos. ");
        System.out.println("4. Borrar campos. ");
        System.out.println("5. Crear Registro. ");
        System.out.println("6. Modificar Registro. ");
        System.out.println("7. Buscar Registro. ");
        System.out.println("8. Borrar Registro. ");
        System.out.println("9. Listar Registro. ");
        System.out.println("INGRESE SU OPCION: ");
        option = read.nextInt();
        switch(option){
            case 1:
                metodos.CreateCampos(metadata);
                break;
            case 2:
                metodos.ListCampos(metadata);
                break;
            case 3:
                metodos.ModificarCampos(metadata);
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("INVALIDO!!! ");
                break;
        } //Fin del switch menu.  
            System.out.println("Desea volver al menu del programa ? [S/N] ?");
            read.nextLine();
            resp = read.nextLine();
        } //Fin del while con respuesta de usuario. Menu
         */
        char[] name=new char [10];
        for (int i = 0; i < 10; i++) {
            name[i]='a';
        }
        Registro test=new Registro();
        Campos prueba=new Campos(1,20,40,true);
        test.abrir();
       test.read(test);
        //test.escribir(test, prueba);
        //System.out.println("File----"+test.File_size());
    } //Fin del Main
    
}
