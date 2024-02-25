package main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.entity.Role;
import main.service.RoleService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleController", urlPatterns = {"/role-add", "/role"})
public class RoleController extends HttpServlet {
    private final RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/role-add")){
            req.getRequestDispatcher("role-add.jsp").forward(req, resp);
        } else if (path.equalsIgnoreCase("/role")){
            List<Role> listRoles = roleService.showRole();
            req.setAttribute("listRoles",listRoles);
            req.getRequestDispatcher("role-table.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        boolean isSuccess = roleService.addRole(name, description);
        req.setAttribute("isSuccess", isSuccess);
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);


    }


}
