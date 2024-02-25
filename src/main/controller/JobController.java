package main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Job;
import main.entity.Project;
import main.entity.Status;
import main.entity.User;
import main.service.JobService;
import main.service.ProjectService;
import main.service.StatusService;
import main.service.UserService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "jobController", urlPatterns = {"/task-add","/task"})
public class JobController extends HttpServlet {
    private JobService jobService = new JobService();
    private UserService userService = new UserService();
    private ProjectService projectService = new ProjectService();
    private StatusService statusService = new StatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/task-add")){
            List<Project> listProjects = projectService.showProject();
            List<User> listUsers = userService.showUser();
            req.setAttribute("listProjects", listProjects);
            req.setAttribute("listUsers", listUsers);
            req.getRequestDispatcher("task-add.jsp").forward(req,resp);
        } else if (path.equalsIgnoreCase("/task")){
            List<Job> listJobs = jobService.showJob();
            List<Project> listProjects = projectService.showProject();
            List<User> listUsers = userService.showUser();
            List<Status> listStatus = statusService.showStatus();
            req.setAttribute("listProjects", listProjects);
            req.setAttribute("listUsers", listUsers);
            req.setAttribute("listStatus", listStatus);
            req.setAttribute("listJobs",listJobs);
            req.getRequestDispatcher("task.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProject = Integer.parseInt(req.getParameter("idProject"));
        String name = req.getParameter("name");
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        boolean isSuccess = jobService.addJob(idProject, name, idUser, startDate, endDate);
        req.getRequestDispatcher("task-add.jsp").forward(req,resp);
    }
}
