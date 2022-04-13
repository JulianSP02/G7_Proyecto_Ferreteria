package com.ferreteria;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
    //El siguiente método funciona para hacer la auttenticación del usuario
    //Se añaden en este caso ejemplos con los nombres de los usuarios integrantes del proyecto como clientes, y un usuario admin.
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Julian")
                    .password("{noop}Julian123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("Diego")
                    .password("{noop}Diego123")
                    .roles("VENDEDOR","USER")
                .and()
                .withUser("Ignacio")
                    .password("{noop}Ignacio123")
                    .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo",        "/articulo/guardar", 
                             "/articulo/modificar/**", "/articulo/eliminar/**",
                             "/categoria/nuevo",       "/categoria/guardar",
                             "/categoria/modificar/**","/categoria/eliminar/**",
                             "/cliente/nuevo",         "/cliente/guardar",  
                             "/cliente/modificar/**",  "/cliente/eliminar/**",
                             "/usuario/listado",  
                             "/usuario/nuevo",         "/usuario/guardar",  
                             "/usuario/modificar/**",  "/usuario/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers("/articulo/listado", "/categoria/listado",
                             "/cliente/listado")
                    .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/")
                    .hasAnyRole("USER","VENDEDOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
    
}
