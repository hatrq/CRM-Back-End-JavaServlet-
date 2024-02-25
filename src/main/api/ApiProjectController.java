package main.api;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Project;
import main.payload.response.BaseResponse;
import main.service.ProjectService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "apiProjectController", urlPatterns = {"/api/project","/api/project/delete"})
public class ApiProjectController extends HttpServlet {
    private final ProjectService projectService = new ProjectService();
    private final Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/api/project")){
            List<Project> listProjects = projectService.showProject();
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage("");
            baseResponse.setData(listProjects);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        } else if (path.equalsIgnoreCase("/api/project/delete")){
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isSuccess = projectService.deleteProjectById(id);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Delete project Success" : "Delete project failed");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        }
    }
}
