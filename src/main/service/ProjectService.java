package main.service;

import main.entity.Project;
import main.repository.ProjectRepository;

import java.sql.Date;
import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository = new ProjectRepository();

    public boolean addProject(String name, Date startDate, Date endDate){
        return projectRepository.addProject(name, startDate, endDate) > 0;
    }

    public List<Project> showProject(){
        return projectRepository.showProject();
    }

    public boolean deleteProjectById(int id){
        return projectRepository.deleteProjectById(id) > 0;
    }

    public  boolean updateProjectById(int id, String name, Date startDate, Date endDate){
        return projectRepository.updateProjectById(id, name, startDate, endDate) > 0;
    }
}
