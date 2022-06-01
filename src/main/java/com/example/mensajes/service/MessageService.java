package com.example.mensajes.service;

import com.example.mensajes.dao.MessageDAO;
import com.example.mensajes.model.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Message registro = new Message();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MessageDAO.createMessageDB(registro);
    }

    public static void listMessages(){
        ArrayList<Message> listMessages = MessageDAO.readMessagesDB();
        for (int i = 0; i < listMessages.size(); i++) {
            System.out.println(listMessages.get(i).toString());
        }
    }

    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el id del mensaje a eliminar");
        int id = sc.nextInt();

        MessageDAO.deleteMessageDB(id);
    }

    public static void updateMessage(){

    }
}
