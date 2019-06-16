/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

/**
 *
 * @author X
 */
public class DLL {
    // Class for Doubly Linked List 

    
    Node head; // Cabeza de la Lista

    /* D-Linked List Nodess*/
    class Node {

        Data reg;
        int data;
        Node prev;//valor previo ==null si es root o inicio
        Node next;//siguiente apuntador == null si es el ultimo

        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int d) {
            data = d;
        }
    }

    public void push(int new_data) {//Caso que ingresa al incio

        Node new_Node = new Node(new_data);      
        new_Node.next = head;
        new_Node.prev = null;// hace el anterior null como ingresa al inicio

        if (head != null) {
            head.prev = new_Node;
        }

        // hace el nodo cabeza
        head = new_Node;
    }

    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data) {

        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }
        //2) Encuntrea el Nodo o Pos 
        //3) Mete los datos
        Node new_node = new Node(new_data);
        //4. Hacer el next del siguiente nodo comosiguiente del nodo previo   
        new_node.next = prev_Node.next;
        prev_Node.next = new_node;// al apuntador de anterior le asigno next
        new_node.prev = prev_Node;//al anterior del nuevo nodo le asigno el nodo anterior
        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }
    }

    
    
    public void bestFist(Data datos){

        
        
        
    }
    public Data searchBestFit(){
       
        
        
        return null;
    }
    public void InsertEnd(int new_data) {//este metodo lo agrega al final

        Node new_node = new Node(new_data);
        Node last = head;
        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null) {//busca el final de la lista para insertar
            last = last.next;
        }
        // al ultimo nodo le agrega un siguiente
        last.next = new_node;

        //ahora al nuevo nodo le setiamos el anterior
        new_node.prev = last;
    }

    public void ImprimeListaEnlazada(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
    void deleteNode(Node head_ref, Node delete) 
    { 
        // Caso Base
        if (head == null || delete == null) { 
            return; 
        }  
        // If node to be deleted is head node 
        if (head == delete) { 
            head = delete.next; 
        } 
        if (delete.next != null) { //entra si no es el ultimo nodo
            delete.next.prev = delete.prev; 
        } 
        if (delete.prev != null) { //no lo hace si es el primer nodo
            delete.prev.next = delete.next; 
        } 
        return; 
    } 
  

}
