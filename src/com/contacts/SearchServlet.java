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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Map<Integer, String[]> resultMap = searchContact(name);

        getServletContext().setAttribute("searchResults", resultMap);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/search_results.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/search.jsp");
        requestDispatcher.forward(request, response);
    }

    private Map<Integer, String[]> searchContact(String name) {
        Connection connection = ConnectionManager.getConnection();
        Map<Integer, String[]> contactMap = new TreeMap<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM contacts WHERE name=?")) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String[] data = new String[3];
                    data[0] = resultSet.getString("name");
                    data[1] = resultSet.getString("surname");
                    data[2] = resultSet.getString("tel_number");
                    contactMap.put(resultSet.getInt("id"), data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();

        return contactMap;
    }
}
