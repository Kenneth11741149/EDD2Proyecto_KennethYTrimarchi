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

        JOptionPane.showMessageDialog(null, "Pre Alpha PATCH 1.90: "
                + "\n1.Try catch is almost rolled out System Wide. "
                + "\n2.Binary File features not working, but are getting prepped."
                + "\n3.New File feature (option NO) is completely operational"
                + "\n4. Create Campos exports successfully all necesary info to metadata on class gui."
                + "\n5. Borrar Campos works as it should modyfing metadata"
                + "\n6. Modificar campos works as it should."
                + "\n7. Funcion Crear registro is existent but not operational."
                + "\n8. Table is being worked on"
                + "\n9. TABLE LISTENER THREAD IS NOW AWARE OF WHEN IT IS BEING EDITED AND WHEN IT IS NOT"
                + "\n\n\n Pre Alpha PATCH 1.91"
                + "\n10. TABLE NOW IS CAPABLE OF TELLING IF A VALUE IS THE SAME OR NOT, AND WHERE DID IT OCCUR."
                + "\n11. TABLE IS NOW CAPABLE OF VALIDATING USERS INPUT TO MAKE SURE NO WRONG TYPES ARE INSERTED."
                + "\n12. If user Inserts an incorrect data type on a cell (String on an Int), User value is downgraded to original value."
                + "\n13. Funcion Crear Registro is beginning to be operational, PENDING REGISTRO STRUCTURE.");


        GUI graphics = new GUI();
        graphics.setVisible(true);
       

        /*
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
        } while (resp != 4);*/


        //test.escribir(test, prueba);
        //System.out.println(test.File_size() + "------" + prueba.sizeBytes);

    } //Fin del Main

}
