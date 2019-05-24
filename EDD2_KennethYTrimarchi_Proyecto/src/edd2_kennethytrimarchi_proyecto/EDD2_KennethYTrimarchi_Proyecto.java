package edd2_kennethytrimarchi_proyecto;

import java.awt.JobAttributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
        String input2;
        System.out.println("***MENU // PROGRAMA NO OPTIMIZADO CON TRY CATCH");
        System.out.println("1. Borrar");
        System.out.println("2. Modificar");
        System.out.println("Ingrese su eleccion: ");
        input = read.nextInt();
        switch(input){
            case 1:
                System.out.println("Ingrese la posicion del registro a borrar.");
                position = 0;
                position = read.nextInt();
                DeleteP2(position);
                break;
            case 2:
                System.out.println("Ingrese la posicion para modificar: ");
                position = 0;
                position = read.nextInt();
                System.out.println("Ingrese el valor por el que va a modificar:");
                read.nextLine();
                input2 = read.nextLine();
                ModifyP2(position,input2);
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
            fw = new FileWriter(file,true);
            
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            //Si le das reset al buffered reader asi vuelve al inicio :)
            boolean continuar = true;
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            //////////////////////////////////
            char actual; //Character que estoy extrayendo
            char invalido = (char)-1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            int DisqueByte = -1; //Para reset el lector;
            int BytePosition = -1;
            int DeleterStart = 0;
            int ByteLength = 0;
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
                        String insertion = "";
                        ByteLength = (BytePosition-1) - DeleterStart;
                        insertion += Integer.toString(ByteLength);
                        for(int i = insertion.length(); i < ByteLength ;i++){
                            insertion += "*";
                           
                        }
                          raf.writeBytes(insertion);
                         //bw.write(insertion, DeleterStart,ByteLength);
                        
                        
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
        bw.close();
        fr.close();
        fw.close();
       
    }
    public static void DeleteP2(int position) throws IOException{
        File file = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try{
            file = new File("Registro.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file,false);
            
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            
            String linea = br.readLine();
            String Metadata = linea;
            String registros = br.readLine();
            int ijk = 0;
            char actual; //Character que estoy extrayendo
            char invalido = (char)-1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            int DisqueByte = -1; //Para reset el lector;
            int BytePosition = -1;
            int DeleterStart = 0;
            int ByteLength = 0;
            System.out.println("--------------------"+registros.length());
            while( ijk < registros.length()){
                actual = registros.charAt(ijk);
                DisqueByte++; //Posicion que usare para marcar el inicio del borrado
                BytePosition++; //Posicion que estoy leyendo en el texto lo usare para marcar el final del borrado.
                if(actual == '/' && contadorchar == 0){
                    contadorchar++;
                } else if (actual == '/' && contadorchar == 1) {
                    contador++;
                    char elimval;
                    if(contador == position && (elimval = registros.charAt(ijk-1))!= '>'){
                        
                        System.out.println("Position has been reached, commencing the elimination process.");
                        String insertion = "";
                        ByteLength = (BytePosition-1) - DeleterStart;
                        insertion += "<";
                        
                        insertion += Integer.toString(ByteLength)+"*";
                        if(Metadata.equals("")){
                            Metadata = Integer.toString(position);
                            insertion += "-1";
                        } else {
                            insertion += Metadata.toString()+"*";
                            Metadata = Integer.toString(position);
                        }
                        System.out.println("Metadata:"+Metadata);
                        for(int i = insertion.length(); i < ByteLength ;i++){
                            
                            if(i == ByteLength-1){
                                insertion+= ">";
                            } else {
                                insertion += "*";
                            }
                           
                        }
                        System.out.println(insertion);
                        String registros2 = registros.substring(0,DeleterStart+1);
                        
                       // System.out.println("Linea2"+registros2);
                        String registros3 = registros.substring(DeleterStart+1,BytePosition);
                        registros3 += ">";
                        //System.out.println("Linea3"+registros3);
                        String majo = registros2+registros3;
                        String registros4 = registros.substring(BytePosition);
                        //System.out.println("Linea4"+registros4);
                        String print = registros2+insertion+registros4;
                        System.out.println(print);
                        
                        //bw.write(Metadata);
                        //bw.write(linea);
                        
                        
                        break;
                    }else{
                        DeleterStart = DisqueByte;
                        br.mark(DisqueByte);
                    
                    
                    } //end if interno
                }
                ijk++;
            }
        }catch(Exception e){
            System.out.println("ERROR AL CARGAR EL ARCHIVO.");
            e.printStackTrace();
        }
        br.close();
        fr.close();
        bw.close();
        fw.close();
        
    }
    
    public static void ModifyP2(int position, String phrase) throws IOException{
        File file = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try{
            file = new File("Registro.txt");
            fr = new FileReader(file);
            //fw = new FileWriter(file,false);

            br = new BufferedReader(fr);
            //bw = new BufferedWriter(fw);

            String linea = br.readLine();
            System.out.println("linea"+linea);
            String Metadata = linea;

            String registros = br.readLine();
            int ijk = 0;
            char actual; //Character que estoy extrayendo
            char invalido = (char)-1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            int DisqueByte = -1; //Para reset el lector;
            int BytePosition = -1;
            int DeleterStart = 0;
            int ByteLength = 0;
            
            while( ijk < registros.length()){
                actual = registros.charAt(ijk);
                DisqueByte++; //Posicion que usare para marcar el inicio del borrado
                BytePosition++; //Posicion que estoy leyendo en el texto lo usare para marcar el final del borrado.
                if(actual == '/' && contadorchar == 0){
                    contadorchar++;
                } else if (actual == '/' && contadorchar == 1) {
                    contador++;
                    char elimval;
                    if(contador == position && (elimval = registros.charAt(ijk-1))!= '>'){                      
                        System.out.println("Position has been reached, commencing the modification process.");
                        
                        String insertion = "";
                        ByteLength = (BytePosition-1) - DeleterStart;
                        //insertion += "<";
                        int logic = 0;
                        if( phrase.length() < ByteLength){
                           insertion += phrase;
                           logic = 1;
                                    //MARCAS EL REGISTRO ACTUAL COMO ELIMINADO LO MANDO AL AVAILIST
                                    //ESCRIBIR AL FINAL.
                        } else if(phrase.length() >= ByteLength){
                            insertion += "<";
                            DeleteP2(position);
                            registros +=phrase+"/";
                        }
                        insertion += Integer.toString(ByteLength)+"*";
                        if(Metadata.equals("")){
                            Metadata = Integer.toString(position);
                            insertion += "-1";
                        } else {
                            insertion += Metadata.toString()+"*";
                            Metadata = Integer.toString(position);
                        }
                        System.out.println("Metadata:"+Metadata);
                        for(int i = insertion.length(); i < ByteLength ;i++){
                            
                            if(i == ByteLength-1 && logic == 0){
                                insertion+= ">";
                            } else {
                                insertion += "*";
                            }
                           
                        }
                        System.out.println(insertion);
                        String registros2 = registros.substring(0,DeleterStart+1);
                        
                       // System.out.println("Linea2"+registros2);
                        String registros3 = registros.substring(DeleterStart+1,BytePosition);
                        registros3 += ">";
                        //System.out.println("Linea3"+registros3);
                        String majo = registros2+registros3;
                        String registros4 = registros.substring(BytePosition);
                        //System.out.println("Linea4"+registros4);
                        String print = registros2+insertion+registros4;
                        System.out.println(print);
                        
                        //bw.write(Metadata);
                        //bw.write(linea);
                        
                        
                        break;
                    }else{
                        DeleterStart = DisqueByte;
                        br.mark(DisqueByte);
                    
                    
                    } //end if interno
                }
                ijk++;
            }
        }catch(Exception e){
            System.out.println("ERROR AL CARGAR EL ARCHIVO.");
            e.printStackTrace();
        }
        br.close();
        fr.close();
       // bw.close();
        //fw.close();
        
    }
}
