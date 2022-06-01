package com.example.mensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection get_conection(){
        Connection connection = null;

        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app?enabledTLSProtocols=TLSv1.2", "root","");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return connection;
    }
}
