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
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {

        JOptionPane.showMessageDialog(null, "GUI VERSION 1.7. \nNo try catch enabled. \nTable Issues Resolved");


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


        Registro test = new Registro();
        test.abrir(test);
        int resp = 0;
        //test.moficarC(test);
        do {
            System.out.println("==================================");
            System.out.print("1)Agergar Campo \n"
                    + "2)Listar Campos\n"
                    + "3)Modificar Campos\n"
                    + "4)Eliminar Campo\n"
                    + "5)Buscar Campo\n"
                    + "Que dese hacer?:");
            resp = sc.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("==================================");
                    if (test.numCampos == 0) {
                        System.out.print("Ingrese Llave primaria tipo Int: ");
                        String nombre = sc.next();
                        //tipo int =1;
                        Campos prueba = new Campos(1, test.File_size(), true);
                        prueba.agregarNombre(nombre);
                        test.escribir(test, prueba);
                    } else {
                        System.out.print("Ingrese nombre del campo: ");
                        String nombre = sc.next();
                        System.out.print("1)Int\n"
                                + "2)Long\n"
                                + "3)String\n"
                                + "4)Char\n"
                                + "Que tipo de Dato Desea?: ");
                        int tipo = sc.nextInt();
                        Campos prueba = new Campos(tipo, test.File_size(), false);
                        prueba.agregarNombre(nombre);
                        test.escribir(test, prueba);
                    }

                    break;
                case 2:
                    System.out.println("==================================");
                    test.readC(test);
                    System.out.println("==================================");
                    System.out.println(test.Camps.get(0));

                    break;
                case 3:
                    System.out.println("==================================");
                    System.out.print("1)Nombre\n"
                            + "2)Tipo\n"
                            + "Que deasea Modifcar:"
                    );
                    int cambio = sc.nextInt();
                    switch (cambio) {
                        case 1:
                            String nuevo_nombre = "";
                            do {
                                System.out.print("Ingrese el Nuevo Nombre: ");
                                nuevo_nombre = sc.next();
                            } while (test.Camps.get(0).agregarNombre(nuevo_nombre) == false);
                            System.out.println("-----------" + test.Camps.get(0).cadena);
                            System.out.println("######################"+test.Camps.get(0).getSize_dec());
                            test.modificarC(test, test.Camps.get(0));
                            System.out.println("Registro Exitoso");
                            break;
                    }
                    break;
                case 4:
                    break;
            }
        } while (resp != 4);


        //test.escribir(test, prueba);
        //System.out.println(test.File_size() + "------" + prueba.sizeBytes);

    } //Fin del Main

}
