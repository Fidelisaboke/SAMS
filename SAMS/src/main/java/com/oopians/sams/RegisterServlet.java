/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.oopians.sams;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author fidel
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    // Declaring the database handler
    DatabaseHandler dbh = DatabaseHandler.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the form data
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_pass");
        String userType = request.getParameter("user_type");

        // Validate the form data
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            userType == null || userType.trim().isEmpty()) {
            // Invalid form data
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<p>Error: All fields are required.</p>");
            out.println("</body></html>");
            return;
        }

        // Check if the username already exists
        if (dbh.checkData("tbl_users", "user_name", username)) {
            // Username already exists
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<p>Error: Username already exists.</p>");
            out.println("</body></html>");
            return;
        }

        // Put user data in a hash-map
        Map<String, Object> userData = new HashMap<>();
        userData.put("user_name", username);
        userData.put("user_type", userType);
        userData.put("user_pass", password);

        // Add the user to the database
        dbh.setData("tbl_users", userData);

        // Display a success message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>Registration successful!</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
