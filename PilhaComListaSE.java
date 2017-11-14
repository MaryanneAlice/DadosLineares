/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos;

import exceptions.EPilhaVazia;

/**
 *
 * @author MaryanneAlice
 */
public class PilhaComListaSE {
          
    private class No {
        public Object dado;
        public No prox;
        public No(Object dado, No prox) {
            this.dado = dado;
            this.prox = prox;
        }
    }
    
    private No inicioNo;
    private int t;
              
    public PilhaComListaSE (int tam) { 
        inicioNo = null;
        this.t = 0;
    }
    
    public boolean isEmpty() {
        return t == 0;
    }
    
    public int size() throws EPilhaVazia {
        if (isEmpty()) {
            throw new EPilhaVazia();
        }
        System.out.println("projetos.PilhaComListaSE.size() == " + t);
        return t;
    }
    
    public Object top() throws EPilhaVazia {
        if (isEmpty()){
            throw new EPilhaVazia();
        }
        System.out.println("projetos.PilhaComListaSE.top() == " + inicioNo.dado);
        return inicioNo.dado;
    }
    
    public Object push(Object o){
        No atual = new No(o, null);
        
        if (isEmpty()) {
            inicioNo = atual;
        } else {
            inicioNo.prox = atual;
        }
        inicioNo = atual;
        t++;
        System.out.println("projetos.FilaComListaSE.enqueue() == sucess; add == " + o);
        return o;
    }
    
    public Object pop() throws EPilhaVazia {
        if (isEmpty()) {
            throw new EPilhaVazia();
        }        
        No atual = inicioNo;
        inicioNo = inicioNo.prox;
        t--;
        System.out.println("projetos.PilhaComListaSE.pop() == " + atual.dado);
        return atual.dado;
    }    
 
}
