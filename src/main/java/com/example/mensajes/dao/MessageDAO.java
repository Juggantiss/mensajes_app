package com.example.mensajes.dao;

import com.example.mensajes.ConnectionDB;
import com.example.mensajes.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    public static  void CreateMessageDB(Message message){
        ConnectionDB db_connect = new ConnectionDB();

        try(Connection connection = db_connect.get_conection()) {
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) values(?, ?, CURRENT_TIMESTAMP)";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMensaje());
                ps.setString(2, message.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void readMessagesDB(){

    }

    public static void deleteMessageDB(int id_mensaje){

    }

    public static void updateMessageDB(Message message){

    }
}
