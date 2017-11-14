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
public class FilaComListaSE {
    
    public FilaComListaSE(int tam) { }
    
    private class No {
        public Object dado;
        public No prox;
        public No(Object dado, No prox) {
            this.dado = dado;
            this.prox = prox;
        }
    }
    
    private No inicioNo = null;
    private No fimNo = null;
    
    public boolean isEmpty() {
        return inicioNo == null;
    }
    
    public int size() throws EFilaVazia {
        int i = 0;
        if (isEmpty()) {
            throw new EFilaVazia();
        }
        for (No j = inicioNo; j != null; j = j.prox) {
            i++;
        }
        System.out.println("fila.FilaComListaSE.size() == " + i);
        return i;
    }
        
    public Object peek() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia(); 
        }
        System.out.println("fila.FilaComListaSE.peek() == " + inicioNo.dado);
        return inicioNo.dado;
    }
    
    public Object enqueue(Object o) {
        No atual = new No(o, null);
        
        if (isEmpty()) {
            inicioNo = atual;
        } else {
            fimNo.prox = atual;
        }
        
        fimNo = atual;
        System.out.println("projetos.FilaComListaSE.enqueue() == sucess; add == " + o);
        return o;
    }
    
    public Object dequeue() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia();
        }
        Object atual = inicioNo.dado;
        if (fimNo == inicioNo) {
            fimNo = null;
        }
        inicioNo = inicioNo.prox;
        System.out.println("projetos.FilaComListaSE.dequeue() == " + atual);
        return atual;
    }
    
}
