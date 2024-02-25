package main.repository;

import main.config.MysqlConfig;
import main.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository {
    public int login(String email, String password){
        String query = "select * \n" +
                " from Users u \n" +
                "where u.email = ? AND u.pwd = ?";
        Connection connection = MysqlConfig.getConnection();
        List<User> listUsers = new ArrayList<>();
        int count = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                listUsers.add(user);
            }
            if (!listUsers.isEmpty()){
                System.out.println(">>> Login Success!");
                count = 1;
            } else {
                System.out.println(">>> Login Failed!");
            }
        } catch (SQLException e){
            System.out.println(">>> Process data failed! " + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }
}
