/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallersingleton;

/**
 *
 * @author romny
 */
public class InicioSingletonEj2 {
    public static void main(String[] args) {
        // TODO code application logic here
       
       System.out.println("Inicio proceso singleton v2");
       Configurador c = new Configurador.getConfigurador("miurl","mibaseDatos");
       System.out.println(c.getUrl());
       
    }
               
    
}
