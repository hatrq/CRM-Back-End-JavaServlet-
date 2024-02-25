package main.repository;

import main.config.MysqlConfig;
import main.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository {
    public List<Status> showStatus(){
        String query = "SELECT * FROM Status";
        Connection connection = MysqlConfig.getConnection();
        List<Status> listStatus = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setName(resultSet.getString("name"));
                listStatus.add(status);
            }
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listStatus;
    }
}
