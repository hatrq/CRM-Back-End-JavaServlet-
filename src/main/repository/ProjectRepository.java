package main.repository;

import main.config.MysqlConfig;
import main.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    public int addProject(String name, Date startDate, Date endDate){
        String query = "INSERT INTO Project(name,startDate,endDate)\n" +
                "VALUES (?,?,?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

    public List<Project> showProject(){
        String query = "SELECT * FROM Project p ";
        Connection connection = MysqlConfig.getConnection();
        List<Project> listProjects = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setStartDate(resultSet.getDate("startDate"));
                project.setEndDate(resultSet.getDate("endDate"));
                listProjects.add(project);
            }
        } catch (Exception e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listProjects;
    }

    public int deleteProjectById(int id){
        String query = "DELETE FROM Project WHERE id = ?";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
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

    public int updateProjectById(int id, String name, Date startDate, Date endDate){
        String query = "UPDATE Project \n" +
                "SET name = ?, startDate = ?, endDate = ? \n" +
                "WHERE id = ?";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);
            statement.setInt(4, id);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }
}
