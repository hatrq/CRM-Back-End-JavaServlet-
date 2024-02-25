package main.api;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.payload.response.BaseResponse;
import main.service.ProjectService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet(name = "apiProjectUpdate", urlPatterns = {"/api/project/update"})
public class ApiProjectUpdate extends HttpServlet {
    private final ProjectService projectService = new ProjectService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        boolean isSuccess = projectService.updateProjectById(id, name, startDate, endDate);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage(isSuccess ? "Update Project Success!" : "Update Project Failed!");
        baseResponse.setData(isSuccess);
        String dataJson = gson.toJson(baseResponse);
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("/application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.write(dataJson);
    }
}
