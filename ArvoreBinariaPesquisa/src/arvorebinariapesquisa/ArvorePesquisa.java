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
    
    public int depth(No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + depth(no.pai());
    }
    
    public void swap(No x, No y) {
        x.setElement(y.element());
        x.setKey(y.key());
    }
    
    public No find(int k) {
        return treeSearch(k, raiz);
    }
    
    public No treeSearch(int c, No no) {
        if (isExternal(no) || c == chave(no)) {
            return no;
        } else if (c < chave(no)) {
            if (esquerda(no) != null)
                return treeSearch(c, esquerda(no));
            return no;
        } else {
            if (direita(no) != null)
                return treeSearch(c, direita(no));
            return no;
        }
    }
    
    public void insert(int k, Object o) {
        No v = find(k);
        if (k < chave(v)){
            No w = new No(v, null, null, k, o);
            v.setFilhoEsquerdo(w);
            tamanho++;
        } else if (k > chave(v)) {
            No w = new No(v, null, null, k, o);
            v.setFilhoDireito(w);
            tamanho++;
        } else {
            v.setElement(o);
        }
    }
    
    public Iterator nodes() {
        ArrayList<No> no = new ArrayList() ;
        inOrder(raiz, no);
        return no.iterator();
    }
    
    public void inOrder(No no, ArrayList<No> nos) {
        if (isInternal(no) && no.filhoEsquerdo() != null)
            inOrder(no.filhoEsquerdo(), nos);
        
        nos.add(no);
        
        if (isInternal(no) && no.filhoDireito() != null)
            inOrder(no.filhoDireito(), nos);
    }
    
    public void remove(int c) {
        if (removeNode(c) != null){
            removeNode(c);
            tamanho--;
        }
    } 
    
    public Object removeNode(int c) {
        No no = find(c);
        No pai;
        Object o = null;
        
        // Encontrou a chave
        if (c == chave(no)) {
            pai = no.pai();
            
            // Não tem filhos
            if (isExternal(no)) {
                if (chave(no) < chave(pai))
                    pai.setFilhoEsquerdo(null);
                else
                    pai.setFilhoDireito(null);
                
            // Só tem filho na esquerda
            } else if (no.filhoEsquerdo() != null && no.filhoDireito() == null) {
                if (chave(no) < chave(pai))
                    pai.setFilhoEsquerdo(no.filhoEsquerdo());
                else
                    pai.setFilhoDireito(no.filhoEsquerdo());
                
                no.filhoEsquerdo().setPai(pai);
                no.setFilhoEsquerdo(null);
                
            // Só tem filho na direita
            } else if (no.filhoEsquerdo() == null && no.filhoDireito() != null) {
                if (chave(no) < chave(pai))
                    pai.setFilhoEsquerdo(no.filhoDireito());
                else
                    pai.setFilhoDireito(no.filhoDireito());
                
                no.filhoDireito().setPai(pai);
                no.setFilhoDireito(null);
                
            // Tem dois filhos
            } else if (no.filhoEsquerdo() != null && no.filhoDireito() != null) {
                nos.clear();
                inOrder(no.filhoDireito(), nos);
                //TreeNode w = v.rightChild().leftChild() != null ? v.rightChild().leftChild() : v.rightChild();
                No w = nos.get(0);
                removeNode(chave(w));
                swap(no, w);
            }
            
            o = no.element();
            no = null;
        }
        return o;
    }
    
    public void setPositions(No[][] t) {
        int i = 0;
        No v;
        for (Iterator<No> w = nodes(); w.hasNext(); ++i) {
            v = w.next();
            t[depth(v)][i] = v;
        }
    }
    
    public void showTree() {
        No[][] t = new No[height(raiz) + 1][tamanho];
        setPositions(t);
        for (int j = 0; j < t.length; ++j) {
            for (int i = 0; i < t[j].length; ++i) {
                System.out.print(" ");
                System.out.print(t[j][i] != null ? t[j][i].key() : " ");
            }
            System.out.println();
        }
    }
    
}