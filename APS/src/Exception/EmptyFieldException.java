/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Gustavo.Alves
 */
public class EmptyFieldException extends Exception{
    public EmptyFieldException(String s){
        super(s);
    }
    
    @Override
    public String getMessage()
    {
        return super.getMessage();
    }
}
