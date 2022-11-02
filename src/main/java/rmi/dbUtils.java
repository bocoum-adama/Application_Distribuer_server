/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author mac
 */
public class dbUtils {

    private static Connection cnn;
    public static final SimpleDateFormat SQL_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Connection getConnection() throws Exception {

        //connetion a la base
        if (cnn == null) {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi", "root", "");

        }
        return cnn;
    }

    public static void disconnect() throws SQLException {
        if (cnn != null) {
            cnn.close();
            cnn = null;
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = dbUtils.getConnection();
        System.out.println("connexion ok");
        dbUtils.disconnect();
        System.out.println("deconnexion ok");

    }

}
