package com.example.mensajes;

import com.example.mensajes.service.MessageService;

import java.sql.Connection;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. editar mensaje");
            System.out.println(" 3. eliminar mensaje");
            System.out.println(" 5. salir");

            // Leemos la opcion del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessages();
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while (opcion != 5);
    }
}
