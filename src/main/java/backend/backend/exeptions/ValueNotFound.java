/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Admin
 */
// Esto es para crear exceptions personalizadas
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValueNotFound extends Exception{
    public ValueNotFound(){}
    public ValueNotFound(String msg){super(msg);}
}