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
public class Hash {
    private int tamAtual, tamMax;
    private Object[] keys;   
    private Object[] valor;
    
    public Hash(int capacidade){
        tamAtual = 0;
        tamMax = capacidade;
        keys = new Object[tamMax];
        valor = new Object[tamMax];
    }  

    public void makeEmpty(){
        tamAtual = 0;
        keys = new Object[tamMax];
        valor = new Object[tamMax];
    }

    public int getSize() {
        System.out.println("hash.Hash.getSize() == " + tamAtual);
        return tamAtual;
    }

    public boolean isFull() {
        return tamAtual == tamMax;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public boolean contains(Object key) {
        System.out.println("hash.Hash.contains() == " + get(key));
        return get(key) !=  null;
    }

    private int hash(Object key) {
        System.out.println("hash.Hash.hash() == "+ (key.hashCode() % tamMax));
        return key.hashCode() % tamMax;
    }    

    public void insert(Object key, Object val) {                
        int tmp = hash(key);
        int i = tmp;
        do {
            if (keys[i] == null){
                keys[i] = key;
                valor[i] = val;
                tamAtual++;
                System.out.println("hash.Hash.insert() == " + key + " -> " + val);
                return;
            }
            if (keys[i].equals(key)){ 
                valor[i] = val; 
                return; 
            }            
            i = (i + 1) % tamMax;            
        } while (i != tmp);       
        
    }

    public Object get(Object key) {
        int i = hash(key);
        while (keys[i] != null){
            if (keys[i]==key)
                return valor[i];
            i = (i + 1) % tamMax;
        }          
        System.out.println("hash.Hash.get() == " + valor[i]);
        return null;
    }

    public void remove(Object key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        
        while (!key.equals(keys[i])){ 
            i = (i + 1) % tamMax;
        }
        keys[i] = valor[i] = null;

        for (i = (i + 1) % tamMax; keys[i] != null; i = (i + 1) % tamMax){
            Object tmp1 = keys[i], tmp2 = valor[i];
            keys[i] = valor[i] = null;
            tamAtual--;  
            insert(tmp1, tmp2);            
        }
        System.out.println("hash.Hash.remove() == " + key);
        tamAtual--;        
    }
    
}