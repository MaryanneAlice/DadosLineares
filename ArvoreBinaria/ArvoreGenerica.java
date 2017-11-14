/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;
/**
 * Classe que extende de Arvore e acrescenta m�todos para adicionar 
 * n�s em uma �rvore e remover n�s da �rvore
 */
public interface ArvoreGenerica extends Arvore
{
	
	public void addChild(No v, Object o);
	
	/**
	 * @param v
	 * @return Objeto que estava na pos��o que foi removida
	 * @throws InvalidNoException
	 */
	public Object remove(No v) throws InvalidNoException;
}