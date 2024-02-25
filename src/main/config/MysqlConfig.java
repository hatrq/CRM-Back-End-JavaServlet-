package main.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/crm","root","Danbakugan007@");
        } catch (Exception e){
            System.out.println(">>> Error: Connect to database failed!" + e.getLocalizedMessage());
            return null;
        }
    }

    public static void closeConnection(Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        } catch (Exception e){
            System.out.println(">>> Error: Close connection failed!" + e.getLocalizedMessage());
        }
    }
}
