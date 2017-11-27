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
public class No {
    private int chave;
    private Object o;
    private No pai;
    private No filhoEsquerdo, filhoDireito;
    
    public No(No pai, No filhoEsquerdo, No filhoDireito, int chave, Object o) {
        this.chave = chave;
        this.o = o;
        this.pai = pai;
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
    }

    public int key() {
        return chave;
    }

    public void setKey(int chave) {
        this.chave = chave;
    }
    
    public Object element() {
        return o;
    }

    public void setElement(Object o) {
        this.o = o;
    }

    public No pai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }
        
    public No filhoEsquerdo() {
        return filhoEsquerdo;
    }
    
    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }
    
    public No filhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
}