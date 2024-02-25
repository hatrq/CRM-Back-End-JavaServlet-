package main.api;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.User;
import main.payload.response.BaseResponse;
import main.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "apiUserController",urlPatterns = {"/api/user","/api/user/delete"})
public class ApiUserController extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/api/user")) {
            List<User> userList = userService.showUser();
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage("");
            baseResponse.setData(userList);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.print(dataJson);
        } else if (path.equalsIgnoreCase("/api/user/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isSuccess = userService.deleteUserById(id);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode(200);
            baseResponse.setMessage(isSuccess ? "Delete User Success!" : "Delete User Failed!");
            baseResponse.setData(isSuccess);
            String dataJson = gson.toJson(baseResponse);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("/application/json");
            resp.setCharacterEncoding("UTF-8");
            printWriter.write(dataJson);
        }
    }
}
