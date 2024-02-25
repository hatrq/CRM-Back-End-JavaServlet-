package main.service;

import main.entity.Status;
import main.repository.StatusRepository;

import java.util.List;

public class StatusService {
    private StatusRepository statusRepository = new StatusRepository();

    public List<Status> showStatus(){
        return statusRepository.showStatus();
    }
}
