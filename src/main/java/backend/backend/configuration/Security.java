/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.configuration;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;


// Declaramos nuestro archivo para gestionar toda la configuración correspondiente a la seguridad del sistema.
//@Configuration
//@EnableWebSecurity
public class Security {

    // Hacemos que spring boot se encargue de inicializar el componente de autenticación creado.
//    @Autowired
//    private CustomAuthProvider authProvider;

    // El filterChain se va a encargar de administrar nuestra seguridad mediante la URL
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf()
//            .disable(); // Con esta línea deshabilitamos el token de autenticación mediante formularios.
//        http
//            .authorizeRequests()// Generamos las request permitidas
//            .antMatchers("/login") // Si vamos a la página de login
//            .permitAll() // Permitimos que todos entren
//            .antMatchers("/test/*") // Si vamos a cualquir página que se encuentre dentro de la url test
//            .authenticated() // Pedimos que se autentiquen
//            
//            .antMatchers("/user/*") // Si es cualquir url perteneciente al usuario
//            .permitAll() // También permitiemos. Esto es solo para la prueba
//            .and() // Encadenamos con otra propiedad
//            .formLogin()
//            .loginPage("/login") // Decimos que url vamos a utilizar para el login
//            .permitAll() // Permitimos el acceso para esa url
//            .defaultSuccessUrl("/test/") // Una vez que el login se complete, definimos a donde nos redirigue la app
//            .and() // Encadenamos con otra propiedad
//            .logout() // Para el logout existe una url pre definida
//            .logoutSuccessUrl("/login") // Si hacemos el logout bien nos manda para el login
//            .and() // Encadenamos con otra propiedad
//            .httpBasic() // Decimos que utilice las propiedades básicas de las url de spring boot
//            ;
//            
//        return http.build(); // Construimos la configuración http  
//    }

    // Declaramos el encoder global a utilizar
//    @Bean
//    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    // Con este código decimos que el sistema debe utilizar nuestro CustomAuthProvider
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = 
//        http.getSharedObject(AuthenticationManagerBuilder.class);
//    authenticationManagerBuilder.authenticationProvider(authProvider);
//    return authenticationManagerBuilder.build();
//    }


}
