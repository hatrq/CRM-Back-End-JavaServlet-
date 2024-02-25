package main.api;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Role;
import main.payload.response.BaseResponse;
import main.service.RoleService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "apiRoleController", urlPatterns = {"/api/role","/api/role/delete","/api/role/update"})
public class ApiRoleController extends HttpServlet {
    private final RoleService roleService = new RoleService();
    private final Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/api/role")) {
            List<Role> listRoles = roleService.showRole();
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage("");
            baseResponse.setData(listRoles);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.print(dataJson);
        } else if (path.equalsIgnoreCase("/api/role/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isSuccess = roleService.deleteRoleById(id);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Delete Role Success!" : "Delete Role Failed!");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        } else if (path.equalsIgnoreCase("/api/role/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("nameUpdate");
            String desc = req.getParameter("descUpdate");
            boolean isSuccess = roleService.upDateRoleById(id, name, desc);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Update Role Success!" : "Update Role Failed!");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        }
    }
}
