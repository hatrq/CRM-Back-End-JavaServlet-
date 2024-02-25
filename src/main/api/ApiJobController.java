package main.api;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Job;
import main.payload.response.BaseResponse;
import main.service.JobService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "apiJobController", urlPatterns = {"/api/task","/api/task/delete","/api/task/update"})
public class ApiJobController extends HttpServlet {
    private JobService jobService = new JobService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/api/task")){
            List<Job> listJobs = jobService.showJob();
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage("");
            baseResponse.setData(listJobs);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        } else if (path.equalsIgnoreCase("/api/task/delete")){
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isSuccess = jobService.deleteJobById(id);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Delete Job Success!" : "Delete Job Failed!");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        } else if (path.equalsIgnoreCase("/api/task/update")){
            int idJob = Integer.parseInt(req.getParameter("idJob"));
            int idProject = Integer.parseInt(req.getParameter("idProject"));
            String nameJob = req.getParameter("nameJob");
            int idUser = Integer.parseInt(req.getParameter("idUser"));
            Date startDate = Date.valueOf(req.getParameter("startDate"));
            Date endDate = Date.valueOf(req.getParameter("endDate"));
            int idStatus = Integer.parseInt(req.getParameter("idStatus"));
            boolean isSuccess = jobService.updateJobById(idJob, idProject, nameJob, idUser, startDate, endDate, idStatus);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Update Job Success!" : "Update Job Failed!");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        }
    }
}
