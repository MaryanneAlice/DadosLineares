/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.awt.SystemColor;
/**
 * @author Robinson
 *
 */
public class InvalidNoException extends Exception
{
	public InvalidNoException()
	{
		super();
	}
	public InvalidNoException(String message)
	{
		super(message);
	}
}