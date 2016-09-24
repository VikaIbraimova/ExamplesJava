package ru.javacourse.db;

import java.sql.*;

public class FirstDB {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String id = rs.getString("id");
            String isdn = rs.getString("isdn");

            System.out.println("id : " + id);
            System.out.println("isdn : " + isdn);
        }
    }
}