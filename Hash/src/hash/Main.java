/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Maryanne Alice 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hash h = new Hash(8);
        
        h.insert(1, 1);
        h.insert(2, "A");
        h.insert(3, 5);
        h.insert(4, 7);
        h.remove(2);
        h.insert(5, "D");
        h.insert(6, "B");
        h.insert(7, 10);
        h.remove(6);
        
        h.getSize();
    }
    
}
