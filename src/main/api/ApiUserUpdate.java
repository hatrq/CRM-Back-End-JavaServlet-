package main.api;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.payload.response.BaseResponse;
import main.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiUserUpdate", urlPatterns = {"/api/user/update"})
public class ApiUserUpdate extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        int idRole = Integer.parseInt(req.getParameter("idRole"));
        boolean isSuccess = userService.updateUserById(id, email, password, firstname, lastname, username, phone, idRole);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage(isSuccess ? "Update User Success!" : "Update User Failed!");
        baseResponse.setData(isSuccess);
        String dataJson = gson.toJson(baseResponse);
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("/application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.write(dataJson);
    }
}
