package com.example.mensajes;

import java.sql.Connection;

public class Home {
    public static void main(String[] args) {
        ConnectionDB conexion = new ConnectionDB();

        try(Connection cnx = conexion.get_conection()){
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
