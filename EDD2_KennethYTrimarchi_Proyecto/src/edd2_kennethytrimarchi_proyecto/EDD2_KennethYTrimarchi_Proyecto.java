package edd2_kennethytrimarchi_proyecto;

import java.awt.JobAttributes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EDD2_KennethYTrimarchi_Proyecto {
    static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        //System.out.println("Creating GUI");
        //GUI graphics = new GUI();
        //graphics.setVisible(true);
        System.out.println("GRAPHICAL USER INTERFACE IS WORKING... REMOVE COMMENT TO USE.");
        int input;
        int position;
        System.out.println("***MENU // PROGRAMA NO OPTIMIZADO CON TRY CATCH");
        System.out.println("1. Borrar");
        System.out.println("2. Modificar");
        System.out.println("Ingrese su eleccion: ");
        input = read.nextInt();
        switch(input){
            case 1:
                System.out.println("Ingrese la posicion del bit a borrar.");
                position = 0;
                position = read.nextInt();
                Delete(position);
                break;
            case 2:
                break;
            default:
                System.out.println("Operacion no definida en el menu.");
        }
        
        
    }
    public static void Delete(int position) throws IOException{
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            file = new File("Registro.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            br.mark(0); //Si le das reset al buffered reader asi vuelve al inicio :)
            boolean continuar = true;
            //////////////////////////////////
            char actual; //Character que estoy extrayendo
            char invalido = (char)-1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            while( (actual =(char)br.read()) != invalido){              
                System.out.println(actual);
                if(actual == '/' && contadorchar == 0){
                    contadorchar++;
                } else if(actual == '/' && contadorchar == 1){
                    contador++;
                    System.out.println("contador: "+contador);
                    System.out.println("position"+position);
                    if(contador == position){
                        System.out.println("");
                        System.out.println("AHHHHHHHHHH");
                        break;
                    }
                    
                    
                   
                }
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Loading TXT File");
            
        }
        br.close();
        fr.close();
       
    }
}
