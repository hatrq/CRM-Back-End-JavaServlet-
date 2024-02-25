package main.repository;


import main.config.MysqlConfig;
import main.entity.Role;
import main.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public int addUser(String fullName, String email, String password, String phoneNumber, int idRole){
        String query = "INSERT INTO Users (fullName,email,pwd,phone,id_role)\n" +
                "VALUES(?,?,?,?,?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fullName);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phoneNumber);
            statement.setInt(5, idRole);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

    public List<User> showUser(){
        String query = "SELECT u.id , u.firstName , u.lastName , u.userName , r.name \n" +
                "FROM Users u \n" +
                "JOIN `Role` r ON r.id = u.id_role ";
        Connection connection = MysqlConfig.getConnection();
        List<User> listUsers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUserName(resultSet.getString("userName"));
                Role role = new Role();
                role.setName(resultSet.getString("name"));
                user.setRole(role);
                listUsers.add(user);
            }
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listUsers;
    }

    public int deleteUserById(int id){
        String query = "DELETE FROM Users WHERE id = ?";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

    public int upDateUserById(int id, String email, String password, String firstName, String lastName, String userName, String phone, int idRole){
        String query = "UPDATE Users \n" +
                "SET email = ?, pwd = ?, firstName = ?, lastName = ?, userName = ?, phone = ?, id_role = ?\n" +
                "WHERE id = ? ";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, userName);
            statement.setString(6, phone);
            statement.setInt(7, idRole);
            statement.setInt(8, id);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }
}
