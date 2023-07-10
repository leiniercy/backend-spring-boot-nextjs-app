/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.configuration;

import java.util.ArrayList;

//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.stereotype.Component;
//import com.teatro.reserva.Utils.Util;
// Esto se crea para poder modificar el comportamiento por defecto que tiene spring boot para manejar la autenticación
//@Component
public class CustomAuthProvider /*implements AuthenticationProvider*/  {

    //  Con este método, capturamos los datos provenientes del login
//    @Override
//    public org.springframework.security.core.Authentication authenticate(
//            org.springframework.security.core.Authentication authentication)
//            throws org.springframework.security.core.AuthenticationException {
//                String name = authentication.getName(); // El nombre
//                String password = authentication.getCredentials().toString(); // El password

                // Para terminar, retornamos un token de autenticación generado por spring boot
//                return new UsernamePasswordAuthenticationToken(
//                      name, // Nombre del usuario
//                      Util.encrypteMe(password),  // Tenemos que encriptar el passwrod
//                      new ArrayList<>() // Aqui van los roles del usuario, en este caso se queda sin nada, ya que del frontend no viene nada
//                      );
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//    

}