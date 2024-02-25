package main.repository;

import main.config.MysqlConfig;
import main.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public int addRole(String name, String description){
        String query = "INSERT INTO `Role` (name,description)\n" +
                "VALUES (?,?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

    public List<Role> showRole(){
        String query = "SELECT * FROM `Role` r ";
        Connection connection = MysqlConfig.getConnection();
        List<Role> listRoles = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setDescription(resultSet.getString("description"));
                listRoles.add(role);
            }
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listRoles;
    }

    public int deleteRoleById(int id){
        String query = "DELETE FROM `Role` \n" +
                "WHERE id = ?";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

    public int updateRoleById(int id, String name, String description){
        String query = "UPDATE `Role` \n" +
                "SET name = ?, description = ?\n" +
                "WHERE id = ?";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, id);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }
}
