/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class NotificacionMail implements NotificacionEnviar{

    @Override
    public void enviarNot(String destinatario, String mensaje) {
        System.out.println(mensaje + destinatario);
    }
    
}
