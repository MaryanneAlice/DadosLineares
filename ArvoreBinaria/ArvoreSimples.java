/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author marya
 */

import static java.lang.Integer.max;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class ArvoreSimples implements ArvoreGenerica {
    
	//Atributos da �rvore
	public No raiz;
	public int tamanho;
        
	//Construtor
	public ArvoreSimples(Object o)
	{
            raiz = new No(null, o);
            tamanho = 1;
	}
	/** Retorna a raiz da �rvore **/
        
	public No root()
	{
            return raiz;
	}
	/** Retorna o n� pai de um n� */
	public No parent(No v)
	{
            No n = (No) v;
            return (n.parent());
	}
	/** retorna os filhos de um n� */
	public Iterator children(No v)
	{
            No n = (No) v;
            return n.children();
	}
	/** Testa se um n� � interno */
	public boolean isInternal(No v)
	{
            No n = (No) v;
            return (n.childrenNumber() > 0);
	}
	/** Testa se um n� � externo*/
	public boolean isExternal(No v)
	{
            No n = (No) v;
            return (n.childrenNumber() == 0);
	}
	/** Testa se um n� � a raiz */
	public boolean isRoot(No v)
	{
            No n = (No) v;
            return n == raiz;
	}
	/** Adiciona um filho a um n� */
	public void addChild(No v, Object o)
	{
            No n = (No) v;
            No novo = new No(n, o);
            n.addChild(novo);
            tamanho++;
	}
	/** Remove um n�
	 *  S� pode remover n�s externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(No v) throws InvalidNoException
	{
            No n = (No) v;
            No pai = n.parent();
            if (pai != null || isExternal(n))
            	pai.removeChild(n);
            else
            	throw new InvalidNoException();
                Object o = n.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posi��o */
	public void swapElements(No v, No w)
	{
            No aux = v;
            v = w;
            w = aux;		
	}
	/** Retorna a profundidade de um n� */
	public int depth(No v)
	{
            No n = v;
            int profundidade = profundidade(n);
            return profundidade;
	}
	private int profundidade(No v)
	{
            if (v == raiz) {
		return 0;
            }
            return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da �rvore */
	public int height(No n)
	{
            // M�todo que serve de exerc�cio
            int h = 0;           
            if (isExternal(n)) 
                return h;
            return 1 + max(height(n.esquerda), height(n.direita));
	}
        /* INSERIDAS */
        public boolean hasLeft(No v) throws InvalidNoException { 
            No aux = v;
            return (aux.getEsquerda() != null);
        }
        public boolean hasRight(No v) throws InvalidNoException { 
            No aux = v;
            return (aux.getDireita() != null);
        }
        public No esquerda(No v) throws InvalidNoException { 
          if (!hasLeft(v))
            throw new InvalidNoException();
          return v.getEsquerda();
        }
        /** Returns the right child of a node. */
        public No direita(No v) throws InvalidNoException { 
          if (!hasRight(v))
            throw new InvalidNoException();
          return v.getEsquerda(); 
        }
        protected void inOrder(No v, List l) throws InvalidNoException {
            if (hasLeft(v))
              inOrder(esquerda(v), l);  // recurse on left child
            l.add(v);
            if (hasRight(v))
              inOrder(direita(v), l); // recurse on right child
          }
	public Iterator elements(){  
            Iterator positer = positions();
            List elements = new List() {
                @Override
                public int size() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean isEmpty() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean contains(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Iterator iterator() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object[] toArray() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object[] toArray(Object[] ts) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean add(Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean remove(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean containsAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean addAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean addAll(int i, Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean removeAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean retainAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void clear() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object get(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object set(int i, Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void add(int i, Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object remove(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int indexOf(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int lastIndexOf(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public ListIterator listIterator() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public ListIterator listIterator(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public List subList(int i, int i1) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            for (int i = 0; i < size(); i++)
                elements.add(((No)positer.next()).element());
            return elements.iterator();
	}
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator positions(){   
            List positions = new List() {
                @Override
                public int size() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean isEmpty() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean contains(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Iterator iterator() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object[] toArray() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object[] toArray(Object[] ts) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean add(Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean remove(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean containsAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean addAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean addAll(int i, Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean removeAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean retainAll(Collection clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void clear() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object get(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object set(int i, Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void add(int i, Object e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object remove(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int indexOf(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int lastIndexOf(Object o) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public ListIterator listIterator() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public ListIterator listIterator(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public List subList(int i, int i1) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            if(size() != 0)
              try {
                  inOrder(root(), positions);
            } catch (InvalidNoException ex) {
                Logger.getLogger(ArvoreSimples.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            return positions.iterator();
	}
	/** Retorna o n�mero de n�s da �rvore
	 */
	public int size(No no)
	{
            if (isEmpty()) {
                return 0;
            }
            return ( 1 + size(no.esquerda) + size(no.direita) );  
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return raiz == null;
	}
	public Object replace(No v, Object o) throws InvalidNoException
	{
            if (isEmpty())
                throw new InvalidNoException();
                
            No n = (No)v.element();
            v.setElement(o);
            return n;
	}
	/* In�cio da classe aninhada para armazenar o n�*/
	private class No 
	{
		private Object o;
		private No pai;
		private Vector filhos = new Vector();
                private No direita;
                private No esquerda;
             
		public No(No pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public No parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(No o)
		{
			filhos.add(o);
		}
		public void removeChild(No o)
		{
			filhos.remove(o);
		}
		public int childrenNumber()
		{
			return filhos.size();
		}
		public Iterator children()
		{
			return filhos.iterator();
		}
                public No getDireita() {
                    return direita;
                }
                public void setDireita(No direita) {
                    this.direita = direita;
                }

                public No getEsquerda() {
                    return esquerda;
                }

                public void setEsquerda(No esquerda) {
                    this.esquerda = esquerda;
                }
	}
	/* Fim da classe aninhada para armazenar o n� */
}