/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connex;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author itu
 */
public class Connexi {
    public Connection getConnexion() throws Exception{
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/intelligence","postgres","princy");
             System.err.println("ok");
        }
        catch(Exception e){
            System.err.println("failed");
            throw e;
        }
        finally{
            return conn;    
        }
         
    }
}
