/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos;

import exceptions.EFilaVazia;

/**
 *
 * @author MaryanneAlice 
 */
public class FilaComArray {
    
    private Object[] objetos, aux;
    int i, t, f;
    
    public FilaComArray(int t) {
        this.objetos = new Object[t];
        this.i = 0;
        this.f = 0;
    }
    
    public boolean isEmpty() {
        return (i == f);
    }
    
    public boolean isFull() {
        return (size() == objetos.length-1);
    }
    
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (objetos.length - i + f) % objetos.length;
    }
    
    public Object peek() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia(); 
        }
        System.out.println(objetos[i]);
        return objetos[i];
    }
    
    public Object enqueue(Object o) {
       if (isFull()) {
            aux = new Object[objetos.length];
            System.arraycopy(objetos, 0, aux, 0, objetos.length);
            objetos = new Object[objetos.length*2];         
            System.arraycopy(aux, 0, objetos, 0, aux.length);
        }              
            objetos[f] = o;
            f = (f + 1) % objetos.length;
            t++;
        return objetos[size()];
    }
    
    public Object dequeue() throws EFilaVazia {
        Object item = objetos[i];
        if (isEmpty()) {
            throw new EFilaVazia(); 
        } else {
            objetos[i] = null;
            i = (i + 1) % objetos.length;
            t--;
        }
        return item;
    }
    
    public void ViewQueue() {
        for (int i = 0; i < objetos.length; i++) {
            System.out.println("Item[" + (i+1) + "] = " + objetos[i]);
        }
    }  
    
}
