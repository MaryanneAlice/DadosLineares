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
public class Heap {
    
    private int qtdE;            
   private Object[] heap;     

    public Heap(int capacidade) {
        qtdE = 0;
        heap = (Object[]) new Comparable[capacidade];
    }
   
    public Heap(Object[] array) {
        qtdE = array.length;
        heap = (Object[]) new Comparable[array.length+1];
        System.arraycopy(array, 0, heap, 1, array.length);
        buildHeap();
    }

    private void buildHeap() {
        for (int k = qtdE/2; k > 0; k--) {
            percolatingDown(k);
        }
    }
    
    private void percolatingDown(int k) {
         Object aux = heap[k];
         int filho;

         for(; 2*k <= qtdE; k = filho) {
            filho = 2*k;
            if(filho != qtdE && heap[filho]==heap[filho + 1]){
                filho++;
            }
            if(aux == heap[filho]) {
                heap[k] = heap[filho];
            } else {
                break;
            }
         }
         heap[k] = aux;
    }

    public void heapSort(Object[] array) {
       qtdE = array.length;
       heap = (Object[]) new Comparable[qtdE+1];
       System.arraycopy(array, 0, heap, 1, qtdE);
       buildHeap();

         for (int i = qtdE; i > 0; i--) {
             Object tmp = heap[i]; 
             heap[i] = heap[1];
             heap[1] = tmp;
             qtdE--;
             percolatingDown(1);
         }
         for(int k = 0; k < heap.length-1; k++) {
           array[k] = heap[heap.length - 1 - k];
         }
    }

 
    public Object deleteMin() throws RuntimeException {
        if (qtdE == 0) {
            throw new RuntimeException();
        }
            Object min = heap[1];
            heap[1] = heap[qtdE--];
            percolatingDown(1);
            System.out.println("heap.Heap.deleteMin() == " + min);
        return min;
    }

 
    public void insert(Object x) {
        if(qtdE == heap.length - 1) {
            doubleSize();
        }
        int pos = ++qtdE;
        for(; pos > 1 && x != heap[pos/2]; pos = pos/2) {
           heap[pos] = heap[pos/2];
        }
        heap[pos] = x;
        System.out.println("heap.Heap.insert() == " + x);
    }

    private void doubleSize() {
        Object [] old = heap;
        heap = (Object []) new Comparable[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            heap = old;
        }
        System.out.println("heap.Heap.doubleSize() == " + heap);
    }

    @Override
    public String toString() {
        String out = "";
        for(int k = 1; k <= qtdE; k++) {
            out = out + heap[k] + " ";
        }
        System.out.println(out);
        return out;
    }

}