package main.service;

import main.entity.Job;
import main.repository.JobRepository;

import java.sql.Date;
import java.util.List;

public class JobService {
    private final JobRepository jobRepository = new JobRepository();

    public boolean addJob(int idProject, String name, int idUser, Date startDate, Date endDate){
        return jobRepository.addJob(idProject, name, idUser, startDate, endDate) > 0;
    }

    public List<Job> showJob(){
        return jobRepository.showJob();
    }

    public boolean deleteJobById(int id){
        return jobRepository.deleteJobById(id) > 0;
    }

    public boolean updateJobById(int idJob, int idProject, String nameJob, int idUser, Date startDate, Date endDate, int idStatus){
        return jobRepository.updateJob(idJob, idProject, nameJob, idUser, startDate, endDate, idStatus) > 0;
    }
}
