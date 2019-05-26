
package edd2_kennethytrimarchi_proyecto;

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
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Kenneth {
    static Scanner read = new Scanner(System.in);
    public Kenneth(){
        
    }
    /*RandomAccessFile raf = new RandomAccessFile(new File("Raf.txt"), "rw");
       raf.writeBytes("PENE0");
       raf.seek(0);
        //System.out.println(raf.getFilePointer());
        for (int i = 0; i < raf.length(); i++) {
            
            System.out.println( (char)raf.readByte() );
        }
        raf.close();*/
       //Metadata meta = new Metadata("Kenneth");
       //Write(meta);
    
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
 
    public static void ByteDelete(){
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try{
            file = new File("Metadata.project");
            fis = new FileInputStream(file);
           // bis = new BufferedInputStream(bis);
            ois = new ObjectInputStream(fis);
            
            
            
            
            
            
        }catch(Exception e){
            
        }
        
    }
    
    public static void Write(Metadata meta){
        File file = null;
        FileOutputStream fis = null;
        ObjectOutputStream ous = null;
        
        try{
            file = new File("Metadata.project");
            fis = new FileOutputStream(file);
            ous = new ObjectOutputStream(fis);
            
            ous.writeObject(meta);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            ous.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void RAF(){
        
    }
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    public void CreateCampos(Metadata metadata){
        if(metadata.getNumregistros() == 0){
            //System.out.println("Para dejar de insertar utilize el 0");
            JOptionPane.showMessageDialog(null, "Para dejar de insertar Ingrese 0");
            String input = "";
            ArrayList<String> campos = new ArrayList<String>();
            // preparing containers for the information
            while(input.equals("0") != true){ //Mientras con centinela para que el usuario eliga cuando detenerse TEMP To deprecate.
             //   System.out.println("Ingrese el nombre del campo: ");
                input = JOptionPane.showInputDialog(null, "Ingrese el nombre del Campo");
                if (input.equals("0") != true){
                    campos.add(input);  //Guardo en el arraylist todos los campos
                }
            } //End while de insertar campos por usuario.
            metadata.setCampos(campos); //Lo guardo en la metadata para la Jtable.
           // System.out.println("Successfull!, check table");
            JOptionPane.showMessageDialog(null, "Success! Check Table.");
        } else {
          //  System.out.println("Ya no se puede ingresar campos. Se ingresaron registros.");
            JOptionPane.showMessageDialog(null, "Registro Ingresado, imposible realizar accion.");
        }
      
    } //End CreateCampos.
    
    public void ListCampos(Metadata metadata){
        //System.out.println(metadata.getCampos().toString());
        JOptionPane.showMessageDialog(null,metadata.getCampos().toString());
    } //Fin de listar campos.
    
    public void ModificarCampos(Metadata metadata){
        //System.out.println("Ingrese el numero de cammpo que va a modificar: Ingresar apartir de 1.");
        //JOptionPane.showMessageDialog(null, "Ingrese el campo a modificar a partir de 1.");
        int campo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el campo a modificar a partir de 1")); //Leo el campo a borrar
        //System.out.println("Ingrese el nuevo valor del campo:");
        //read.nextLine(); //Leo el nuevo nombre del campo
        String input = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor");
        campo--; 
        ArrayList campos = metadata.getCampos(); 
        if(campo >= 0 && campo < campos.size()){
            campos.set(campo, input);
            metadata.setCampos(campos);
            //System.out.println("Successfull! Check Table");
            JOptionPane.showMessageDialog(null,"Success! Check Table" );
        } else {
            //System.out.println("Invalid Size. Action could not be performed.");
            JOptionPane.showMessageDialog(null,"Invalid Size");
        }
    }
    
    public void DeleteCampos(Metadata metadata){
        if(metadata.getNumregistros() == 0){
            //System.out.println("Ingrese el numero del campo a borrar. Contar desde 1.");
            int campo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero del campo a borrar A PARTIR DE 1"));
            campo--;
            ArrayList campos = metadata.getCampos();
            if(campo >= 0 && campo < campos.size()){
                campos.remove(campo);
                metadata.setCampos(campos);
                //System.out.println("Successfull! Check table!");
                JOptionPane.showMessageDialog(null,"Success Check table" );
            } else {
                JOptionPane.showMessageDialog(null, "Action could not be performed!");
            }
            
        }
        
    }
}
