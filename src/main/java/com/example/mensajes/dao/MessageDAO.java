package com.example.mensajes.dao;

import com.example.mensajes.ConnectionDB;
import com.example.mensajes.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
    public static  void createMessageDB(Message message){
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

    public static ArrayList<Message> readMessagesDB(){
        ConnectionDB db_connect = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Message> listMessages = new ArrayList<Message>();
        Message message = null;

        try(Connection connection = db_connect.get_conection()) {
            String query = "SELECT * FROM mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                message = new Message();
                message.setId_mensaje(rs.getInt(1));
                message.setMensaje(rs.getString(2));
                message.setAutor_mensaje(rs.getString(3));
                message.setFecha_mensaje(rs.getString(4));
                listMessages.add(message);
            }
        }catch (SQLException e){
            System.out.println("No se pudo leer los mensajes");
            System.out.println(e);
        }

        return listMessages;
    }

    public static void deleteMessageDB(int id_mensaje){

    }

    public static void updateMessageDB(Message message){

    }
}
