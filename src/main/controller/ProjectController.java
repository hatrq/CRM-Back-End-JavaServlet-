package main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Project;
import main.service.ProjectService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "projectController", urlPatterns = {"/groupwork","/groupwork-add"})
public class ProjectController extends HttpServlet {
    private final ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/groupwork")){
            List<Project> listProjects = projectService.showProject();
            req.setAttribute("listProjects", listProjects);
            req.getRequestDispatcher("groupwork.jsp").forward(req,resp);
        } else if (path.equalsIgnoreCase("/groupwork-add")) {
            req.getRequestDispatcher("groupwork-add.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        boolean isSuccess = projectService.addProject(name,startDate,endDate);
        req.setAttribute("isSuccess",isSuccess);
        req.getRequestDispatcher("groupwork.jsp").forward(req,resp);
    }
}
