public class Pilha {
 
    private Object[] objs;
    private Object[] aux;
    private int t;
    
    public Pilha(int tamanhoPilha) {
        this.objs = new Object[tamanhoPilha];
        this.t = -1;
    }
    
    public boolean isEmpty() {
        if (this.t == -1) {
            System.out.println("PILHA VAZIA");
            return true;
        }
        return false;
    }
    
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.t+1;
    }
    
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return this.objs[this.t];
    }
   
    public Object pop() {
        if (isEmpty()) {
            System.out.println("EROO! PILHA VAZIA");
            return null;
        }
        return this.objs[this.t--];
    }
    
    public void push(Object valor) {
          if (this.t < this.objs.length-1) {
              aux = new String[objs.length];
             System.arraycopy(objs, 0, aux, 0, objs.length);
             objs = new String[objs.length*2];
             System.arraycopy(aux, 0, objs, 0, aux.length);
         } 
       t++;
       objs[t] = valor;
    }
    
    public void show(){
        for (int i = 0; i < objs.length; i++) {
             System.out.println("Item[" + (i) + "] = " + objs[i]);
        }
    }
    
}
