package main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Role;
import main.entity.User;
import main.service.RoleService;
import main.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", urlPatterns = {"/user","/user-add"})
public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/user")){
            List<User> listUsers = userService.showUser();
            req.setAttribute("listUsers",listUsers);
            List<Role> listRoles = roleService.showRole();
            req.setAttribute("listRoles", listRoles);
            req.getRequestDispatcher("user-table.jsp").forward(req,resp);
        } else if (path.equalsIgnoreCase("/user-add")){
            List<Role> listRoles = roleService.showRole();
            req.setAttribute("listRoles",listRoles);
            req.getRequestDispatcher("user-add.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        int idRole = Integer.parseInt(req.getParameter("idRole"));
        boolean isSuccess = userService.addUser(fullName,email,password,phoneNumber,idRole);
        req.setAttribute("isSuccess",isSuccess);
        req.getRequestDispatcher("user-add.jsp").forward(req,resp);
    }
}
