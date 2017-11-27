/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinariapesquisa;

/**
 *
 * @author Maryanne Alice
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       ArvorePesquisa bst = new ArvorePesquisa(12, 0);
        bst.insert(2, 1);
        bst.insert(4, 2);
        bst.insert(1, 3);
        bst.insert(3, 4);
        bst.insert(9, 5);
        bst.insert(8, 6);
        bst.insert(7, 7);
        bst.insert(5, 8);
        bst.insert(12, 9);
        bst.insert(11, 10);
        bst.insert(10, 11);
        bst.insert(13, 12);
       
        
        bst.showTree();
        System.out.println("height: " + bst.height(bst.root()));
        
        System.out.println("\nremove: 2, 4, 9");
        bst.remove(2);
        bst.remove(4);
        bst.remove(9);
        
        bst.showTree();
        System.out.println("height: " + bst.height(bst.root()));
    }
    
}
