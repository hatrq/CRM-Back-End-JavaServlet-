package main.repository;

import main.config.MysqlConfig;
import main.entity.Job;
import main.entity.Project;
import main.entity.Status;
import main.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    public int addJob(int idProject, String name, int idUser, Date startDate, Date endDate) {
//        Sử dụng store procedure trong CSDL
//        CREATE PROCEDURE insert_Job(IN idProject int, IN nameJob nvarchar(255), IN idUsers int, IN startDate date, IN endDate date)
//        BEGIN
//        INSERT INTO Job(id_project,name ,startDate,endDate)
//        VALUES (idProject, nameJob, startDate, endDate);
//        SELECT @IDJOB := j.id  FROM Job j;
//        INSERT INTO Job_Status_Users (id_user,id_status,id_job)
//        VALUES (idUsers, 1, @IDJOB);
//        END
        String query = "CALL insert_Job(?,?,?,?,?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idProject);
            statement.setString(2, name);
            statement.setInt(3, idUser);
            statement.setDate(4, startDate);
            statement.setDate(5, endDate);
            count = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }


//    CREATE VIEW view_jobDetails AS
//    SELECT j.id AS jobID , j.name AS jobName, p.name AS projectName, u.fullName AS fullName, j.startDate , j.endDate, s.name AS status
//    FROM Job j
//    JOIN Project p ON j.id_project = p.id
//    JOIN Job_Status_Users jsu ON jsu.id_job = j.id
//    CROSS JOIN Users u ON jsu.id_user = u.id
//    CROSS JOIN Status s ON s.id = jsu.id_status
    public List<Job> showJob(){
        String query = "SELECT * FROM view_jobDetails ";
        Connection connection = MysqlConfig.getConnection();
        List<Job> listJobs = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Job job = new Job();
                job.setId(resultSet.getInt("jobID"));
                job.setName(resultSet.getString("jobName"));
                Project project = new Project();
                project.setName(resultSet.getString("projectName"));
                job.setProject(project);
                User user = new User();
                user.setFullName(resultSet.getString("fullName"));
                job.setUser(user);
                job.setStartDate(resultSet.getDate("startDate"));
                job.setEndDate(resultSet.getDate("endDate"));
                Status status = new Status();
                status.setName(resultSet.getString("status"));
                job.setStatus(status);
                listJobs.add(job);
            }
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listJobs;
    }

    // Sử dụng view_listJob cho trang profile
//    CREATE VIEW view_listJob AS
//    SELECT j.id , j.name AS jobName , p.name AS projectName, j.startDate , j.endDate , s.name AS status
//    FROM Job j
//    JOIN Project p ON p.id = j.id_project
//    JOIN Job_Status_Users jsu ON j.id = jsu.id_job
//    CROSS JOIN Status s ON s.id = jsu.id_status
    public List<Job> showListJob(){
        String query = "SELECT * FROM view_listJob ";
        Connection connection = MysqlConfig.getConnection();
        List<Job> listJobs = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Job job = new Job();
                job.setId(resultSet.getInt("id"));
                job.setName(resultSet.getString("jobName"));
                Project project = new Project();
                project.setName(resultSet.getString("projectName"));
                job.setProject(project);
                job.setStartDate(resultSet.getDate("startDate"));
                job.setEndDate(resultSet.getDate("endDate"));
                Status status = new Status();
                status.setName(resultSet.getString("status"));
                job.setStatus(status);
                listJobs.add(job);
            }
        } catch (SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return listJobs;
    }

//    Sử dụng Store Procedure để thực hiện chức năng update
//    CREATE PROCEDURE update_Job(IN idJob int, IN idProject int, IN nameJob nvarchar(255), IN idUser int, IN startDate date, IN endDate date, IN statusID int)
//    BEGIN
//    UPDATE Job j
//    JOIN Job_Status_Users jsu ON j.id = jsu.id_job
//    SET j.name = nameJob, j.id_project = idProject, j.startDate = startDate , j.endDate = endDate , jsu.id_status  = statusID,
//    jsu.id_user = idUser
//    WHERE j.id = idJob;
//    END

    public int updateJob(int idJob, int idProject, String nameJob, int idUser, Date startDate, Date endDate, int idStatus){
        String query = "CALL update_Job(?,?,?,?,?,?,?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idJob);
            statement.setInt(2, idProject);
            statement.setString(3, nameJob);
            statement.setInt(4, idUser);
            statement.setDate(5, startDate);
            statement.setDate(6, endDate);
            statement.setInt(7, idStatus);
            count = statement.executeUpdate();
        } catch(SQLException e){
            System.out.println(">>> Error: Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }

//    Sử dụng Store procedure delete_Job để delete job
//    CREATE PROCEDURE delete_Job(IN idJob int)
//    BEGIN
//    DELETE FROM Job_Status_Users
//    WHERE id_job = idJob;
//    DELETE FROM Job
//    WHERE id = idJob;
//    END
    public int deleteJobById(int idJob){
        String query = "CALL delete_Job(?)";
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idJob);
            count = statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(">>> Process data failed!" + e.getLocalizedMessage());
        } finally {
            MysqlConfig.closeConnection(connection);
        }
        return count;
    }
}
