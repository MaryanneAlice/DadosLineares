/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;


/**
 *
 * @author Maryanne Alice
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap h = new Heap(5);
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.deleteMin();
        h.deleteMin();
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.deleteMin();
        h.toString();
    }
    
}
