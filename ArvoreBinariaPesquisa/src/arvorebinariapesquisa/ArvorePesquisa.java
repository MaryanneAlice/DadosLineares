/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinariapesquisa;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Maryanne Alice
 */
public class ArvorePesquisa {
    private No raiz;
    private ArrayList<No> nos;
    private int tamanho;

    public ArvorePesquisa(int chave, Object o) {
        raiz = new No(null, null, null, chave, o);
        tamanho = 1;
        nos = new ArrayList();
    }
    
    public No root() {
        System.out.println(raiz);
        return raiz;
    }
    
    public No pai(No no) {
        return no.pai();
    }
    
    public No esquerda(No no) {
        return no.filhoEsquerdo();
    }
    
    public No direita(No no) {
        return no.filhoDireito();
    }
    
    public int chave(No no) {
        return no.key();
    }
    
    public Object element(No no) {
        return no.element();
    }
    
    public int size() {
        return tamanho;
    }
    
    public int height(No no) {
        if (no != null) {
            if (isExternal(no)) {
                return 0;
            } else {
                int h = 0;
                h = Math.max(height(no.filhoDireito()), height(no.filhoEsquerdo()));
                return 1 + h;
            }
        }
        return 0;
    }
    
    public boolean isExternal(No no) {
        boolean r = false;
        if ( (no.filhoEsquerdo() == null)&&(no.filhoDireito()==null) ){
            r = true;
        }
        return r;
    }
    
    public boolean isInternal(No no) {
        boolean r = false;
        if ( (no.filhoEsquerdo()!=null)&&(no.filhoDireito()!=null) ){
            r = true;
        }
        return r;
    }    
    
    public int depth (No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + depth(no.pai());
    }
    
    public void swap(No x, No y) {
         No aux = x;
         x = y;
         y = aux;
    }
    
}
