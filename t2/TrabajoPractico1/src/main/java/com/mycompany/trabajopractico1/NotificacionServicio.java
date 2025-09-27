/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class NotificacionServicio {
    //Se utiliza esta clase para cordinar las notificaciones
    private final NotificacionEnviar emisor;
    
    public NotificacionServicio(NotificacionEnviar emisor){
        this.emisor = emisor;
    }
    
    public void Notificar(String destinatario, String mensaje){
        this.emisor.enviarNot(destinatario, mensaje);
    }
}
