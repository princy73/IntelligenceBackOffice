package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

    public Connection connectto() throws Exception {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/intelligence", "postgres", "princy");
            con.setAutoCommit(false);
            System.out.println("Connection Succes");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return con;
    }
}
