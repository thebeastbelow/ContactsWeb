package com.contacts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telNumber = request.getParameter("tel_number");

        editContact(id, name, surname, telNumber);

        response.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<Integer, String[]> searchResults = (Map<Integer, String[]>)
                getServletContext().getAttribute("searchResults");
        int id = Integer.parseInt(request.getParameter("id"));
        String[] contactData = searchResults.get(id);

        getServletContext().setAttribute("id", id);
        getServletContext().setAttribute("contactData", contactData);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editContact(int id, String name, String surname, String telNumber) {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE contacts SET name=?, surname=?, tel_number=? WHERE id=?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, telNumber);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionManager.closeConnection();
    }
}
