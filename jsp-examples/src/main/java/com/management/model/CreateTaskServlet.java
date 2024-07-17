package com.management.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");
        String priority = request.getParameter("priority");

        String proxyUri = System.getenv("VSCODE_PROXY_URI");

        if (title != null && !title.isEmpty() &&
            description != null && !description.isEmpty() &&
            dueDate != null && !dueDate.isEmpty() &&
            priority != null && !priority.isEmpty()) {

            Task task = new Task(title, description, dueDate, priority);
            request.setAttribute("task", task);

            response.sendRedirect(proxyUri + "/success.jsp");
        } else {
            response.sendRedirect(proxyUri + "/error.jsp");
        }
    }
}
