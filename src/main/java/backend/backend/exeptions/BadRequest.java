/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.exeptions;

/**
 *
 * @author Admin
 */
public class BadRequest extends Exception{
    public BadRequest(){}
    public BadRequest(String msg){super(msg);}
}
