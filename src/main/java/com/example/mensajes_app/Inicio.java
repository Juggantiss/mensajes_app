package com.example.mensajes_app;

import java.sql.Connection;

public class Inicio {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try(Connection cnx = conexion.get_conection()){
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
