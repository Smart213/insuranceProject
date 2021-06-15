package by.softclub.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Postgre {


    public Connection connect() throws SQLException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345");
        System.out.println(c.isValid(5));
        c.setAutoCommit(false);
        return c;
    }

    public int getCount() throws SQLException {
        ResultSet setr = connect()
                .createStatement()
                .executeQuery("SELECT max(id) as cnt from public.\"LearningDB\"");
        setr.next();
        return Integer.parseInt(setr.getString("cnt"));
    }

}
