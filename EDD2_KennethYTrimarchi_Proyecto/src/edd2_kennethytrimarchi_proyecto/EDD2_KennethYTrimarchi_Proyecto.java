package edd2_kennethytrimarchi_proyecto;

import java.awt.JobAttributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            file = new File("Registro.txt");
            fr = new FileReader(file);
            
            br = new BufferedReader(fr);
            //Si le das reset al buffered reader asi vuelve al inicio :)
            boolean continuar = true;
            //////////////////////////////////
            char actual; //Character que estoy extrayendo
            char invalido = (char)-1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            int DisqueByte = -1; //Para reset el lector;
            int BytePosition = -1;
            int DeleterStart = 0;
            while( (actual =(char)br.read()) != invalido){ 
                DisqueByte++; //Posicion que usare para marcar el inicio del borrado
                BytePosition++; //Posicion que estoy leyendo en el texto lo usare para marcar el final del borrado.
                if(actual == '/' && contadorchar == 0){
                    br.mark(DisqueByte);
                    contadorchar++;
                } else if(actual == '/' && contadorchar == 1){
                    contador++;
                    if(contador == position){
                        System.out.println("Position has been reached, commencing the elimination process.");
                        br.reset();
                        for(int i = DeleterStart; i < BytePosition-1; i++){
                            System.out.println((char)br.read());
                            br.
                        }
                            
                        
                        
                        break;
                    }else{
                        DeleterStart = DisqueByte;
                        br.mark(DisqueByte);
                    
                    
                    } //end if interno
                                   
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
